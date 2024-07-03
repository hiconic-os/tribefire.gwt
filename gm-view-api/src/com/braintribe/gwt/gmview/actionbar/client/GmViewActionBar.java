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
package com.braintribe.gwt.gmview.actionbar.client;

import java.util.List;
import java.util.function.Supplier;

import com.braintribe.gwt.action.client.Action;
import com.braintribe.gwt.async.client.Loader;
import com.braintribe.gwt.gmview.action.client.ActionTypeAndName;
import com.braintribe.gwt.utils.client.RootKeyNavExpert.RootKeyNavListener;
import com.braintribe.model.processing.session.api.persistence.PersistenceGmSession;
import com.braintribe.model.workbench.TemplateBasedAction;
import com.google.gwt.user.client.ui.Widget;

/**
 * Interface defining the operations for the ActionBar.
 * @author michel.docouto
 *
 */
public interface GmViewActionBar extends Loader<Void>, Supplier<List<TemplateBasedAction>>, RootKeyNavListener {
	
	Widget getView();
	void prepareActionsForView(GmViewActionProvider view);
	void setWorkbenchSession(PersistenceGmSession workbenchSession);
	void navigateToAction(ActionTypeAndName actionTyeAndName);
	void navigateToAction(Action action);
    void setToolBarVisible(boolean toolBarVisible);
}
