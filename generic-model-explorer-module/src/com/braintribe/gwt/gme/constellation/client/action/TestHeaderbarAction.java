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
package com.braintribe.gwt.gme.constellation.client.action;


import com.braintribe.gwt.action.client.TriggerInfo;
import com.braintribe.gwt.gme.headerbar.client.DefaultHeaderBar;
import com.braintribe.gwt.gmview.client.ModelAction;

/**
 * Test action possible to show at HeaderBar - perform code can be updated on demand to test some functionality... e.g. Commands
 * Need enable code also on {@link DefaultHeaderBar} - search for //RVE testHeaderbarAction
 *
 */
public class TestHeaderbarAction extends ModelAction {

	//private Supplier<? extends PreviewOpenerActionHandler> previewOpenerActionHandlerSupplier;
	
	@Override
	protected void updateVisibility() {
		setHidden(false, true);		
	}

	/*
	@Required
	public void setPreviewOpenerActionHandlerSupplier(Supplier<? extends PreviewOpenerActionHandler> previewOpenerActionHandlerSupplier) {
		this.previewOpenerActionHandlerSupplier = previewOpenerActionHandlerSupplier;
	}
	*/	
	
	@Override
	public void perform(TriggerInfo triggerInfo) {
		/*
        PreviewOpenerById preview = PreviewOpenerById.T.create();
        preview.setDocumentId("79a5eefe-ef1e-403b-af38-bb1cd6a16387");
        preview.setName("Barcode Name");
        //preview.setTitle("Title");
        
        PreviewOpenerByIdCommandExpert expert = new PreviewOpenerByIdCommandExpert();
        expert.setPreviewOpenerActionHandlerSupplier(previewOpenerActionHandlerSupplier);
        expert.handleCommand(preview);
        */
        
        /*
        CommandNotification notification = CommandNotification.T.create();
        notification.setCommand(preview);        
		Notify notify = Notify.T.create();
		notify.getNotifications().add(notification);
		*/      		
		
	}
}
