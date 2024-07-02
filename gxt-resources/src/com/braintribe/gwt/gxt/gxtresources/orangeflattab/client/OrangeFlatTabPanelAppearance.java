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
package com.braintribe.gwt.gxt.gxtresources.orangeflattab.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.theme.blue.client.tabs.BluePlainTabPanelAppearance;

public class OrangeFlatTabPanelAppearance extends BluePlainTabPanelAppearance {
	
	public interface OrangeFlatTabPanelStyle extends BluePlainTabPanelStyle {
		//NOP
	}
	
	public interface OrangeFlatTabPanelResources extends BluePlainTabPanelResources {

		@Override
		@Source({"com/sencha/gxt/theme/base/client/tabs/TabPanel.gss", "com/sencha/gxt/theme/blue/client/tabs/BlueTabPanel.gss",
				"com/sencha/gxt/theme/base/client/tabs/PlainTabPanel.gss", "com/sencha/gxt/theme/blue/client/tabs/BluePlainTabPanel.gss",
				"OrangeFlatTabPanel.gss"})
		OrangeFlatTabPanelStyle style();
		
	}
	
	private final PlainTabPanelTemplates template;
	private final OrangeFlatTabPanelStyle style;
	private static final String ACTIVE_CLASS_NAME = "x-tab-strip-active";
	
	public OrangeFlatTabPanelAppearance() {
		this(GWT.<OrangeFlatTabPanelResources> create(OrangeFlatTabPanelResources.class), GWT.<PlainTabPanelTemplates> create(PlainTabPanelTemplates.class));
	}
	
	public OrangeFlatTabPanelAppearance(OrangeFlatTabPanelResources resources, PlainTabPanelTemplates template) {
		super(resources, template, GWT.<ItemTemplate> create(ItemTemplate.class));
	    this.style = resources.style();
	    this.template = template;
	}
	
	@Override
	public void render(SafeHtmlBuilder builder) {
		builder.append(template.renderPlain(style));
	}
	
	@Override
	public void onSelect(Element item) {
		super.onSelect(item);
		item.addClassName(ACTIVE_CLASS_NAME);
	}
	
	@Override
	public void onDeselect(Element item) {
		super.onDeselect(item);
		item.removeClassName(ACTIVE_CLASS_NAME);
	}

}
