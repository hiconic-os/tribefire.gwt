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
package com.braintribe.gwt.logging.ui.gxt.client.experts;

import com.braintribe.gwt.action.client.Action;
import com.braintribe.gwt.action.client.TriggerInfo;
import com.braintribe.gwt.logging.client.ErrorDialog;
import com.braintribe.gwt.logging.ui.gxt.client.LocalizedText;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.MessageBox;

/**
 * This action is to be performed when the server is not running.
 * A message will be displayed.
 * @author michel.docouto
 *
 */
public class ServerNotRunningAction extends Action {

	@Override
	public void perform(TriggerInfo triggerInfo) {
		Throwable exception = triggerInfo.get(ErrorDialog.EXCEPTION_PROPERTY);
		
		String serverInfoMessage = "Error creating SMI connection to {";
		
		String message = exception.getMessage();
		int startIndex = message.indexOf(serverInfoMessage) + serverInfoMessage.length();
		String serverInfo = message.substring(startIndex, message.indexOf("}", startIndex));
		
		MessageBox alert = new AlertMessageBox(LocalizedText.INSTANCE.serverNotReachable(), LocalizedText.INSTANCE.serverNotReachableDescription(serverInfo));
		alert.show();
	}

}
