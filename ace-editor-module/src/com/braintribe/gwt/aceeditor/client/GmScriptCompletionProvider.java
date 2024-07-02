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

import edu.ycp.cs.dh.acegwt.client.ace.AceCompletion;
import edu.ycp.cs.dh.acegwt.client.ace.AceCompletionCallback;
import edu.ycp.cs.dh.acegwt.client.ace.AceCompletionProvider;
import edu.ycp.cs.dh.acegwt.client.ace.AceCompletionSnippet;
import edu.ycp.cs.dh.acegwt.client.ace.AceCompletionSnippetSegment;
import edu.ycp.cs.dh.acegwt.client.ace.AceCompletionSnippetSegmentLiteral;
import edu.ycp.cs.dh.acegwt.client.ace.AceCompletionSnippetSegmentTabstopItem;
import edu.ycp.cs.dh.acegwt.client.ace.AceCompletionValue;
import edu.ycp.cs.dh.acegwt.client.ace.AceEditor;
import edu.ycp.cs.dh.acegwt.client.ace.AceEditorCursorPosition;

public class GmScriptCompletionProvider implements AceCompletionProvider {

	@Override
	public void getProposals(AceEditor editor, AceEditorCursorPosition pos, String prefix, AceCompletionCallback callback) {
		
		callback.invokeWithCompletions(new AceCompletion[]{
				new AceCompletionValue("tools", "$tools", "tribefire-api", 7),
				new AceCompletionValue("context", "$context", "tribefire-api", 6),
				new AceCompletionValue("session", "$session", "tribefire-api", 5),
				new AceCompletionValue("request", "$request", "tribefire-api", 4),
				new AceCompletionValue("systemSession", "$systemSession", "tribefire-api", 3),
				new AceCompletionValue("systemRequest", "$systemRequest", "tribefire-api", 2),
				
				new AceCompletionSnippet("_create",
						new AceCompletionSnippetSegment[]{
						new AceCompletionSnippetSegmentTabstopItem("<type>"),
						new AceCompletionSnippetSegmentLiteral(" "), // putting backslash in here to prove escaping is working
						new AceCompletionSnippetSegmentTabstopItem("<variable>"),
						new AceCompletionSnippetSegmentLiteral(" = "), // putting dollar in here to prove escaping is working
						new AceCompletionSnippetSegmentTabstopItem("<type>"),
						new AceCompletionSnippetSegmentLiteral(".T.create();"),
						new AceCompletionSnippetSegmentTabstopItem("\n") /* Empty tabstop -- tab to end of replacement text */
				},"tribefire-snippet", "Write a new snippet in your editor", 1)
		});
	}

}

