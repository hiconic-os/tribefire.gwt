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
package com.braintribe.gwt.gxt.gxtresources.orangemenuitem.client;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.theme.blue.client.menu.BlueMenuItemAppearance;

public class OrangeMenuItemAppearance extends BlueMenuItemAppearance {
	
	public interface OrangeMenuItemStyle extends BlueMenuItemStyle {
		//NOP
	}
	
	public interface OrangeMenuItemResources extends BlueMenuItemResources {
		
		@Override
		@Source({"com/sencha/gxt/theme/base/client/menu/Item.gss", "com/sencha/gxt/theme/blue/client/menu/BlueItem.gss", "com/sencha/gxt/theme/base/client/menu/MenuItem.gss",
				"com/sencha/gxt/theme/blue/client/menu/BlueMenuItem.gss", "OrangeMenuItem.gss"})
		OrangeMenuItemStyle style();
	}
	
	public OrangeMenuItemAppearance() {
		super(GWT.<OrangeMenuItemResources>create(OrangeMenuItemResources.class), GWT.<MenuItemTemplate> create(ExtendedMenuItemTemplate.class));
	}
	
	@Override
	public void onActivate(XElement parent) {
		super.onActivate(parent);
		parent.addClassName("x-menu-item-active");
	}
	
	@Override
	public void onDeactivate(XElement parent) {
		super.onDeactivate(parent);
		parent.removeClassName("x-menu-item-active");
	}

}
