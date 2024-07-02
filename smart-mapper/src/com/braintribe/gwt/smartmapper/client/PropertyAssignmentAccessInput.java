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
package com.braintribe.gwt.smartmapper.client;

import java.util.List;
import java.util.function.Function;

import com.braintribe.gwt.async.client.Future;
import com.braintribe.gwt.gmview.action.client.EntitiesProviderResult;
import com.braintribe.gwt.gmview.action.client.ParserResult;
import com.braintribe.gwt.gmview.client.parse.ParserArgument;
import com.braintribe.model.accessdeployment.IncrementalAccess;
import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.Property;
import com.google.gwt.dom.client.Style.TextAlign;

public class PropertyAssignmentAccessInput extends PropertyAssignmentInput{
	
	public PropertyAssignmentAccessInput() {
		super();
		getElement().setAttribute("placeholder", "IncrementalAccess");
		getElement().getStyle().setTextAlign(TextAlign.CENTER);
		internalPropertyName = "incrementalAccess";
	}
	
	@Override
	public void render(){
		if(pac.parentEntity != null){
			Property property = pac.parentEntity.entityType().getProperty(propertyNameOfAssignment);
			Object currentValue = property.get(pac.parentEntity);
			if(currentValue != null){
				if(currentValue instanceof IncrementalAccess){
					setText(((IncrementalAccess)currentValue).getExternalId());
				}
			}else
				setText("");	
		}
		else
			setText("");
	}
	
	@Override
	public EntityType<? extends GenericEntity> getType() {
		return accessType;
	}
	
	@Override
	public boolean loadExisitingValues() {
		return false;
	}
	
	@Override
	public boolean loadTypes() {
		return false;
	}

	@Override
	public Function<ParserArgument, List<ParserResult>> simpleTypesValuesProvider() {
		return null;
	}

	@Override
	public Function<ParserArgument, Future<EntitiesProviderResult>> entitiesFutureProvider() {
		return null;
	}

}
