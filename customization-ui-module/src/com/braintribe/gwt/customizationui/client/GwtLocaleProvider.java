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

import com.braintribe.gwt.browserfeatures.client.UrlParameters;
import com.braintribe.gwt.gmview.client.ModelEnvironmentSetListener;
import com.braintribe.gwt.ioc.client.Configurable;
import com.braintribe.gwt.ioc.client.Required;
import com.braintribe.model.processing.session.api.persistence.ModelEnvironmentDrivenGmSession;
import com.braintribe.model.workbench.WorkbenchConfiguration;
import com.google.gwt.i18n.client.LocaleInfo;

public class GwtLocaleProvider implements Supplier<String>, ModelEnvironmentSetListener {
	
	private String localeWhenDefault = "en";
	private WorkbenchConfiguration workbenchConfiguration;
	private Supplier<? extends ModelEnvironmentDrivenGmSession> gmSessionSupplier;
	
	/**
	 * Configures the supplier for the session for getting the {@link WorkbenchConfiguration}.
	 */
	@Required
	public void setGmSession(Supplier<? extends ModelEnvironmentDrivenGmSession> gmSessionSupplier) {
		this.gmSessionSupplier = gmSessionSupplier;
	}
	
	/**
	 * Configures the locale name when default is the system locale.
	 * Defaults to "en".
	 */
	@Configurable
	public void setLocaleWhenDefault(String localeWhenDefault) {
		this.localeWhenDefault = localeWhenDefault;
	}
	
	@Override
	public String get() throws RuntimeException {
		String locale = UrlParameters.getInstance().getParameter("locale");
		if (locale == null) {
			if (workbenchConfiguration != null)
				locale = workbenchConfiguration.getLocale();
			
			if (locale == null)
				locale = LocaleInfo.getCurrentLocale().getLocaleName();
		}
		
		if ("default".equals(locale))
			locale = localeWhenDefault;
		
		return locale;
	}
	
	@Override
	public void onModelEnvironmentSet() {
		// TODO: please notice that once we receive the locale here, the GWT permutation choice was already made. Thus,
		// GWT localization will not be changed by this. Only our own LocalizedString stuff will be affected.
		workbenchConfiguration = gmSessionSupplier.get().getModelEnvironment().getWorkbenchConfiguration();
	}
}
