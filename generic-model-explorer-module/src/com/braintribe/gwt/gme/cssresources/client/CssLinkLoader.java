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
package com.braintribe.gwt.gme.cssresources.client;

import com.braintribe.gwt.gmview.client.js.CssLoader;
import com.google.gwt.dom.client.Document;

public class CssLinkLoader extends CssLoader {

	@FunctionalInterface
	public static interface OnLoad {
		void loaded();
	}

	/*
	 * All screen related CSS files are kept in one folder on the server. This is a convenience method
	 * which knows in which folder the those CSS files are located. When referencing images and other
	 * resources from the CSS use paths relative to this CSS file.
	 */
	
	/*
	public static void loadNewCss(String id, String cssFileName) {
		if (Document.get().getElementById(cssFileName) == null) {
			    //if (isCssLinkLoaded(cssFileName)) {
			    	loadCss(id, cssFileName);
			    //}
		}
	}
	*/
	
	public static void setDocumentTitle(String title) {
		Document.get().setTitle(title);
	}		
	
	public static void loadNewCss(String id, String rel, String type, String cssFileName) {
		if (Document.get().getElementById(cssFileName) == null) {
			//if (isCssLinkLoaded(cssFileName)) {
				loadCss(id, rel, type, cssFileName);
			//}
		}
	}	

	private static native Boolean isCssLinkLoaded(String cssFileName) /*-{
		var link = $doc.getElementById(cssFileName);
		try {
			if (link.sheet && link.sheet.cssRules.length > 0) {
				return true;
			} else if (link.styleSheet && link.styleSheet.cssText.length > 0) {
				return true;
			} else if (link.innerHTML && link.innerHTML.length > 0) {
				return true;
			}
		} catch (ex) {}
		
		return false;
	}-*/;

	private static native void loadCss(String id, String rel, String type, String url) /*-{
		var l = $doc.createElement("link");
		l.setAttribute("id", id);
		l.setAttribute("rel", rel);
		l.setAttribute("type", type);
		l.setAttribute("href", url); // Make sure this request is not cached
		$doc.getElementsByTagName("head")[0].appendChild(l);
	}-*/;

}
