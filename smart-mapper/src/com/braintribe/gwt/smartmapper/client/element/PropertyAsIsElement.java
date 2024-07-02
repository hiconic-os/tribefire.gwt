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
package com.braintribe.gwt.smartmapper.client.element;

import java.util.Collections;
import java.util.Set;

import com.braintribe.gwt.smartmapper.client.PropertyAssignmentInput;
import com.braintribe.gwt.smartmapper.client.experts.AbstractMappingElementsProvider;
import com.braintribe.gwt.smartmapper.client.util.TypeAndPropertyInfo;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class PropertyAsIsElement extends PropertyAssignmentElement{

	private Label placeHolder;

	@Override
	public void handleAdaption() {
		//NOP
	}
	
	@Override
	public void handleRender() {
		getPlaceHolder().setText(propertyAssignmentContext.parentProperty != null ? TypeAndPropertyInfo.getPropertyName(propertyAssignmentContext.parentProperty) : propertyAssignmentContext.propertyName);
	}

	@Override
	public Widget getWidget() {
		return getPlaceHolder();
	}

	@Override
	public void handleDisposal() {
		//NOP
	}

	@Override
	public void handleInitialisation() {
		//NOP
	}
	
	@Override
	public void handleNoticeManipulation() {
		//NOP
	}
	
	@Override
	public void validate() {
		//NOP
	}
	
	@Override
	public Set<PropertyAssignmentInput> getInputElements() {
		return Collections.emptySet();
	}
	
	@Override
	public Set<AbstractMappingElementsProvider> getTypesOrPropertiesProviders() {
		return Collections.emptySet();
	}
	
	public Label getPlaceHolder() {
		if(placeHolder == null){
			placeHolder = new Label("?");
		}
		return placeHolder;
	}
}
