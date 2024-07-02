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
package com.braintribe.gwt.gme.assemblypanel.client;

import java.util.List;

import com.braintribe.gwt.gme.assemblypanel.client.model.AbstractGenericTreeModel;
import com.braintribe.gwt.gme.assemblypanel.client.model.TreePropertyModel;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.Property;
import com.braintribe.model.meta.GmProperty;
import com.sencha.gxt.core.client.ValueProvider;

public class CompoundPropertyTreeModelValueProvider implements ValueProvider<AbstractGenericTreeModel, Object> {
	
	private final Property property;
	private final String path;
	
	public CompoundPropertyTreeModelValueProvider(Property property, List<GmProperty> compoundProperties) {
		String propertyPath = property.getName();
		for (GmProperty gmProperty : compoundProperties)
			propertyPath += "." + gmProperty.getName();
		
		this.path = propertyPath;
		this.property = getProperty(property, compoundProperties);
	}

	@Override
	public Object getValue(AbstractGenericTreeModel model) {
		TreePropertyModel treePropertyModel = model.getDelegate().getTreePropertyModel(property);
		return treePropertyModel == null ? null : treePropertyModel.getValue();
	}

	@Override
	public void setValue(AbstractGenericTreeModel model, Object value) {
		TreePropertyModel treePropertyModel = model.getDelegate().getTreePropertyModel(property);
		if (treePropertyModel != null)
			treePropertyModel.setValue(value);
	}

	@Override
	public String getPath() {
		return this.path;
	}
	
	private Property getProperty(Property parentProperty, List<GmProperty> compoundProperties) {
		EntityType<?> parentEntityType = (EntityType<?>) parentProperty.getType();
		for (int i = 0; i < compoundProperties.size() - 1; i++)
			parentEntityType = (EntityType<?>) parentEntityType.getProperty(compoundProperties.get(i).getName()).getType();
		
		return parentEntityType.getProperty(compoundProperties.get(compoundProperties.size() - 1).getName());
	}

}
