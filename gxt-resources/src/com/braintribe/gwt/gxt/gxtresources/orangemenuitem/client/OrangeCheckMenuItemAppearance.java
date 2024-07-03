// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
//
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
package com.braintribe.gwt.gxt.gxtresources.orangemenuitem.client;

import com.braintribe.gwt.gxt.gxtresources.orangemenuitem.client.OrangeMenuItemAppearance.OrangeMenuItemStyle;
import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.theme.blue.client.menu.BlueCheckMenuItemAppearance;

public class OrangeCheckMenuItemAppearance extends BlueCheckMenuItemAppearance {
	
	public interface OrangeCheckMenuItemStyle extends BlueCheckMenuItemStyle {
		//NOP
	}
	
	public interface OrangeCheckMenuItemResources extends BlueCheckMenuItemResources {
		
		@Override
		@Source({"com/sencha/gxt/theme/base/client/menu/Item.gss", "com/sencha/gxt/theme/blue/client/menu/BlueItem.gss", "com/sencha/gxt/theme/base/client/menu/MenuItem.gss",
				"com/sencha/gxt/theme/blue/client/menu/BlueMenuItem.gss", "OrangeMenuItem.gss"})
		OrangeMenuItemStyle style();
		
		@Override
		@Source({"com/sencha/gxt/theme/base/client/menu/CheckMenuItem.gss", "com/sencha/gxt/theme/blue/client/menu/BlueCheckMenuItem.gss", "OrangeCheckMenuItem.gss"})
		OrangeCheckMenuItemStyle checkStyle();
	}
	
	public OrangeCheckMenuItemAppearance() {
		super(GWT.<OrangeCheckMenuItemResources>create(OrangeCheckMenuItemResources.class), GWT.<MenuItemTemplate> create(MenuItemTemplate.class));
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
