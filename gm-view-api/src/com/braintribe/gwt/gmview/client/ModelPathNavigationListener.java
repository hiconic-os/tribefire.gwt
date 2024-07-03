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
package com.braintribe.gwt.gmview.client;

import com.braintribe.model.generic.path.ModelPath;
import com.google.gwt.resources.client.ImageResource;

public interface ModelPathNavigationListener {
	
	void onOpenModelPath(ModelPath modelPath);
	
	void onOpenModelPath(ModelPath modelPath, TabInformation tabInformation);
	
	/**
	 * Adds a modelPath.
	 * @param modelPath - the modelPath to be added
	 */
	default void onAddModelPath(ModelPath modelPath) {
		onOpenModelPath(modelPath);
	}
	
	public interface TabInformation {
		public String getTabName();
		public String getTabDescription();
		public ImageResource getTabIcon();
	}

}
