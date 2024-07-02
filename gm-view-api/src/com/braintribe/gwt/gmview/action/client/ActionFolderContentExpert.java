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
package com.braintribe.gwt.gmview.action.client;

import java.util.function.Supplier;

import com.braintribe.gm.model.uiaction.ActionFolderContent;
import com.braintribe.gm.model.uiaction.InstantiateEntityActionFolderContent;
import com.braintribe.gwt.gmview.client.ModelAction;
import com.braintribe.gwt.gmview.codec.client.KeyConfigurationRendererCodec;

public class ActionFolderContentExpert {
	
	private Supplier<InstantiateEntityAction> instantiateEntityActionProvider;
	
	public void setInstantiateEntityActionProvider(Supplier<InstantiateEntityAction> instantiateEntityActionProvider) {
		this.instantiateEntityActionProvider = instantiateEntityActionProvider;
	}
	
	//can be already created ModelAction (just configure it), if not create new ModelAction
    public ModelAction getConfiguredAction(ActionFolderContent actionFolderContent) {
    	return getConfiguredAction(actionFolderContent, null);
    }

	public ModelAction getConfiguredAction(ActionFolderContent actionFolderContent, ModelAction action) {
		//InstantiateEntityActionFolderContent
    	if (actionFolderContent instanceof InstantiateEntityActionFolderContent) {
    		InstantiateEntityActionFolderContent folderContent = (InstantiateEntityActionFolderContent) actionFolderContent;
    		
    		if (action == null || !(action instanceof InstantiateEntityAction))
    			action = instantiateEntityActionProvider.get();
    	    ((InstantiateEntityAction) action).setShowAtMenuMaxLimit(folderContent.getShowAtMenuMaxLimit());
    	    ((InstantiateEntityAction) action).setShowInstancesAtMenu(folderContent.getShowInstancesAtMenu());
    	    ((InstantiateEntityAction) action).setShowAllInstance(folderContent.getShowAll());
    	    ((InstantiateEntityAction) action).setShowTransientInstance(folderContent.getShowTransient());
    	    ((InstantiateEntityAction) action).setDisableAllInstances(folderContent.getDisableAllInstances());    	    
    		((InstantiateEntityAction) action).setConfiguredByActionFolderContent(true);
    	}    	
    	    	
    	//configure Action Shortcut
    	if (actionFolderContent != null && actionFolderContent.getKeyConfiguration() != null) {
    		if (action != null) {
   				String stringKeyConfiguration = KeyConfigurationRendererCodec.encodeKeyConfiguration(actionFolderContent.getKeyConfiguration());
   				action.put("keyConfiguration", stringKeyConfiguration);
    		}    			
    	}
        return action;	
    }
}
