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
package com.braintribe.gwt.gme.constellation.client.expert;

import com.braintribe.gwt.action.client.Action;
import com.braintribe.gwt.action.client.ActionOrGroup;
import com.braintribe.gwt.action.client.TriggerInfo;
import com.braintribe.gwt.ioc.client.DisposableBean;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.widget.core.client.button.CellButtonBase;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

/**
 * This class is an adapter from Action to GXT Button. Priority for Button text is used Action.getToolTip() instead of Action.getName()
 *
 */


public class GlobalToolBarButtonAdapter implements DisposableBean {
	private Action action;
	private CellButtonBase<?> button;
	private ImageResource lastIcon;
	private boolean noText = false;
	private boolean ignoreIcon = false;
	private PropertyListenerImpl actionListener = new PropertyListenerImpl();
	private SelectHandler selectionHandler;
	HandlerRegistration handlerRegistration;
	private class PropertyListenerImpl implements Action.PropertyListener {
		@Override
		public void propertyChanged(ActionOrGroup source, String property) {
			updateButton();
		}
	}
	
	private class SelectionHandlerImpl implements SelectHandler {
		@Override
		public void onSelect(SelectEvent event) {
			TriggerInfo triggerInfo = new TriggerInfo();
			triggerInfo.put(TriggerInfo.PROPERTY_COMPONENTEVENT, event);
			triggerInfo.setWidget(button);
			action.perform(triggerInfo);
		}
	}

	protected GlobalToolBarButtonAdapter(boolean ignoreIcon, Action action, CellButtonBase<?> button) {
		this.button = button;
		this.action = action;
		this.ignoreIcon = ignoreIcon;

		action.addPropertyListener(actionListener);
		handlerRegistration = button.addSelectHandler(getSelectionHandler());
		updateButton();
	}
	
	protected GlobalToolBarButtonAdapter(Action action, CellButtonBase<?> button, boolean noText) {
		this.button = button;
		this.action = action;
		this.noText = noText;

		action.addPropertyListener(actionListener);
		handlerRegistration = button.addSelectHandler(getSelectionHandler());
		updateButton();
	}
	
	protected GlobalToolBarButtonAdapter(Action action, CellButtonBase<?> button) {
		this(action, button, false);
	}
	
	protected SelectHandler getSelectionHandler() {
		if (selectionHandler == null)
			selectionHandler = new SelectionHandlerImpl();
		return selectionHandler;
	}
	
	public CellButtonBase<?> getButton() {
		return button;
	}

	public void updateButton() {
		String id = action.getId();
		
		if (id != null)
			button.setId(id);
		
		String name = action.getTooltip();
		if (name == null)
			name = "";
		
		if (!noText && !name.equals(button.getText()))
			button.setText(name);
		
		button.setEnabled(action.getEnabled());
		
		if (!ignoreIcon) {
			ImageResource icon = action.getIcon();
			if (icon != null && icon != lastIcon) {
				button.setIcon(icon);
				lastIcon = icon;
			}
		} else{
			ImageResource icon = action.getHoverIcon();
			if (icon != null && icon != lastIcon) {
				button.setIcon(icon);
				lastIcon = icon;
			}
		}
				
		if (button instanceof ToggleButton) {
			ToggleButton toggleButton = (ToggleButton)button;
			toggleButton.setValue(action.getToggled());
		}
		
		button.setVisible(!action.getHidden());
	}
	
	@Override
	public void disposeBean() throws Exception {
		action.removePropertyListener(actionListener);
		if (handlerRegistration != null)
			handlerRegistration.removeHandler();
	}
	
	/**
	 * Links an {@link Action} to a {@link CellButtonBase}.
	 */
	@SuppressWarnings("unused")
	public static void linkActionToButton(Action action, CellButtonBase<?> button) {
		new GlobalToolBarButtonAdapter(action, button);
	}
	
	/**
	 * Links an {@link Action} to a {@link CellButtonBase}.
	 * @param noText - If true, use no text in the button (only use toolTip). Defaults to false.
	 */
	@SuppressWarnings("unused")
	public static void linkActionToButton(Action action, CellButtonBase<?> button, boolean noText) {
		new GlobalToolBarButtonAdapter(action, button, noText);
	}
	
	/**
	 * Links an {@link Action} to a {@link CellButtonBase}.
	 */
	@SuppressWarnings("unused")
	public static void linkActionToButton(boolean ignoreIcon, Action action, CellButtonBase<?> button) {
		new GlobalToolBarButtonAdapter(ignoreIcon, action, button);
	}
}
