// ============================================================================
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
// 
// This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License along with this library; See http://www.gnu.org/licenses/.
// ============================================================================
package com.braintribe.gwt.gme.workbench.client;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.braintribe.model.generic.i18n.LocalizedString;
import com.braintribe.model.meta.GmEntityType;
import com.braintribe.model.meta.GmMetaModel;
import com.braintribe.model.meta.data.MetaData;
import com.braintribe.model.meta.data.display.SelectiveInformation;
import com.braintribe.model.processing.session.api.persistence.ModelEnvironmentDrivenGmSession;
import com.sencha.gxt.core.shared.FastMap;

public class WorkbenchMetaDataEnhancer {
	
	public void enhanceWorkbenchModel(ModelEnvironmentDrivenGmSession gmSession) {
		GmMetaModel dataModel = gmSession.getModelEnvironment().getDataModel();
		if (dataModel == null)
			return;
		
		Set<GmEntityType> set = gmSession.getModelAccessory().getOracle().getTypes().onlyEntities().<GmEntityType>asGmTypes().collect(Collectors.toSet());
		for (GmEntityType entityType : set) {
			if (!entityType.getTypeSignature().equals("com.braintribe.model.folder.Folder"))
				continue;
			
			Set<MetaData> metaDataSet = entityType.getMetaData();
			if (metaDataSet == null || metaDataSet.isEmpty()) {
				if (metaDataSet == null) {
					metaDataSet = new HashSet<>();
					entityType.setMetaData(metaDataSet);
				}
				metaDataSet.add(prepareSelectiveInformation());
			} else {
				boolean selectiveInformationFound = false;
				for (MetaData metaData : metaDataSet) {
					if (metaData instanceof SelectiveInformation) {
						selectiveInformationFound = true;
						break;
					}
				}
				
				if (!selectiveInformationFound)
					metaDataSet.add(prepareSelectiveInformation());
			}
			
			break;
		}
	}
	
	protected SelectiveInformation prepareSelectiveInformation() {
		SelectiveInformation selectiveInformation = SelectiveInformation.T.create();
		LocalizedString template = LocalizedString.T.create();
		Map<String, String> templateLocalizations = new FastMap<>();
		templateLocalizations.put("default", "${displayName}");
		template.setLocalizedValues(templateLocalizations);
		selectiveInformation.setTemplate(template);
		
		return selectiveInformation;
	}

}
