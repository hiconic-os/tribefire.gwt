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

import java.util.ArrayList;
import java.util.List;

import com.braintribe.gwt.async.client.AsyncCallbacks;
import com.braintribe.gwt.async.client.Loader;
import com.braintribe.gwt.gme.constellation.client.expert.GlobalActionsHandler;
import com.braintribe.gwt.gme.verticaltabpanel.client.VerticalTabPanel;
import com.braintribe.gwt.ioc.client.Required;
import com.braintribe.gwt.logging.client.Profiling;
import com.braintribe.gwt.logging.client.ProfilingHandle;
import com.braintribe.model.folder.Folder;
import com.braintribe.model.processing.session.api.persistence.ModelEnvironmentDrivenGmSession;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class GlobalActionsToolBarManager implements Loader<Void> {

	private ModelEnvironmentDrivenGmSession gmSession;
	private ModelEnvironmentDrivenGmSession workbenchSession;
	//private GlobalActionsToolBar globalActionToolBar;
	private Loader<Folder> folderLoader;
	private Folder rootFolder = null;
	private List<GlobalActionsHandler> listToolBarHandler =  new ArrayList<>();
	
	
	public GlobalActionsToolBarManager() {
	}
	
	/**
	 * Configures the required {@link ModelEnvironmentDrivenGmSession} used within the actions.
	 */
	@Required
	public void setPersistenceSession(ModelEnvironmentDrivenGmSession gmSession) {
		this.gmSession = gmSession;
	}
	
	public ModelEnvironmentDrivenGmSession getPersistenceSession() {
		return this.gmSession;
	}
	
	/**
	 * Configures the workbench session used for preparing the {@link VerticalTabPanel}.
	 */
	@Required
	public void setWorkbenchSession(ModelEnvironmentDrivenGmSession workbenchSession) {
		this.workbenchSession = workbenchSession;
	}
		
	public ModelEnvironmentDrivenGmSession getWorkbenchSession() {
		return this.workbenchSession;
	}
		
	/**
	 * Configures the required loader for the tool bar folder.
	 */
	@Required
	public void setFolderLoader(Loader<Folder> folderLoader) {
		this.folderLoader = folderLoader;
	}
	
	public Folder getRootFolder() {
		return this.rootFolder;
	}
	
	public void addToolBar(GlobalActionsHandler toolBar) {
		this.listToolBarHandler.add(toolBar);
	}
	
	@Override
	public void load(final AsyncCallback<Void> asyncCallback) {
		final ProfilingHandle ph = Profiling.start(GlobalActionsToolBarManager.class, "Loading global action folders", true);
		for (GlobalActionsHandler toolBarHandler : this.listToolBarHandler) {
			toolBarHandler.setGmSession(gmSession);
			toolBarHandler.setWorkbenchSession(workbenchSession);
		}
		folderLoader.load(AsyncCallbacks.of( //
				result -> {
					rootFolder = result;
					for (GlobalActionsHandler toolBarHandler : listToolBarHandler)
						toolBarHandler.apply(result);
					ph.stop();
					asyncCallback.onSuccess(null);
				}, e -> {
					e.printStackTrace();
					for (GlobalActionsHandler toolBarHandler : listToolBarHandler)
						toolBarHandler.apply(null);
					ph.stop();
					asyncCallback.onSuccess(null);
				}));
	}
}
