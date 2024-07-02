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
package com.braintribe.model.generic.validation;

import java.util.ArrayList;
import java.util.List;

import com.braintribe.model.generic.manipulation.Manipulation;
import com.braintribe.model.generic.validation.expert.ValidatorMessageType;

public class ValidatorResult {

	private String resultMessage;
	private boolean result = true;
	private String propertyName;
	private ValidatorMessageType messageType = ValidatorMessageType.none;
	private String messageParameter;
	private List<Manipulation> listManipulation = new ArrayList<>();

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean getResult() {
		return this.result;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public ValidatorMessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(ValidatorMessageType messageType) {
		this.messageType = messageType;
	}

	public String getMessageParameter() {
		return messageParameter;
	}

	public void setMessageParameter(String messageParameter) {
		this.messageParameter = messageParameter;
	}

	public List<Manipulation> getListManipulation() {
		return listManipulation;
	}

	public void setListManipulation(List<Manipulation> listManipulation) {
		this.listManipulation = listManipulation;
	}
}
