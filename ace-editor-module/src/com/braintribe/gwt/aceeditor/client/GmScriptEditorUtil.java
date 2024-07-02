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
package com.braintribe.gwt.aceeditor.client;

import com.braintribe.gwt.async.client.AsyncCallbacks;
import com.braintribe.gwt.async.client.Future;
import com.braintribe.gwt.gmview.util.client.TextResourceManager;
import com.braintribe.model.resource.Resource;

import edu.ycp.cs.dh.acegwt.client.ace.AceEditor;
import edu.ycp.cs.dh.acegwt.client.ace.AceEditorMode;
import edu.ycp.cs.dh.acegwt.client.ace.AceEditorTheme;
import tribefire.extension.scripting.model.deployment.Script;

public class GmScriptEditorUtil {

	public static AceEditor prepareAceEditor() {
		AceEditor aceEditor = new AceEditor();
		AceEditor.addCompletionProvider(new GmScriptCompletionProvider());
		
		aceEditor.startEditor(); 
		aceEditor.setTheme(AceEditorTheme.ECLIPSE);
		aceEditor.setAutocompleteEnabled(true);
		aceEditor.setMode(AceEditorMode.GROOVY);
		
		return aceEditor;
	}
		
	public static Future<String> setScriptValue(Script script, AceEditor aceEditor) {
		Future<String> future = new Future<>();
		if (script == null || script.getSource() == null) {
			aceEditor.setText(null);
			future.onSuccess(null);
			return future;
		}
		
		//TODO: this must be updated to handle the other script types, when they are available
		//aceEditor.setMode(AceEditorMode.JAVASCRIPT);
		//aceEditor.setMode(AceEditorMode.JAVA);
		//aceEditor.setMode(AceEditorMode.GROOVY);
		
		Resource resource = script.getSource();
		TextResourceManager.retrieveResourceContent(resource).get(AsyncCallbacks.of(content -> {
			//RVE need have check in GmScriptEditorView to have correct cursor position if same value like before
			if ((content == null && aceEditor.getText() != null) || (content != null && aceEditor.getText() == null) || !aceEditor.getText().equals(content)) 
				aceEditor.setText(content);
			future.onSuccess(content);
		}, future::onFailure));
		
		return future;
	}
	
}
