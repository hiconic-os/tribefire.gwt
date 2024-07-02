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
package com.braintribe.gwt.customizationui.client;

import java.util.function.Supplier;

import com.braintribe.gwt.action.client.Action;
import com.braintribe.gwt.action.client.TriggerInfo;
import com.braintribe.gwt.ioc.client.Required;
import com.sencha.gxt.widget.core.client.Window;

public class ShowWindowAction extends Action {
	
	private Supplier<? extends Window> windowProvider;
	private Window window;
	
	@Required
	public void setWindowProvider(Supplier<? extends Window> windowProvider) {
		this.windowProvider = windowProvider;
	}

	@Override
	public void perform(TriggerInfo triggerInfo) {
		Window window = getWindow();
		if (window != null)
			window.show();
	}
	
	private Window getWindow() {
		if (window == null)
			window = windowProvider.get();
		
		return window;
	}

}
