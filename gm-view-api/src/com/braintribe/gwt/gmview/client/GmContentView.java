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
package com.braintribe.gwt.gmview.client;

import com.braintribe.gwt.async.client.Future;
import com.braintribe.model.generic.path.ModelPath;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

import jsinterop.annotations.JsMethod;

@SuppressWarnings("unusable-by-js")
public interface GmContentView extends GmSelectionSupport, GmSessionHandler, UseCaseHandler {
	
	@JsMethod
    public ModelPath getContentPath();

	@JsMethod
    public void setContent(ModelPath modelPath);
    
    /**
     * Sets the optional Write/ReadOnly mode at View. Default is Write mode.
     * @param readOnly - true for setting the view as readonly.
     */
	@JsMethod
    public default void setReadOnly(boolean readOnly) {
    	//NOP    	
    }
    
	@JsMethod
    public default boolean isReadOnly() {
    	return false;
    }
    
    /**
     * Returns the element of an external component. This should actually be an {@link Element}.
     */
	@JsMethod
    public default Object getUxElement() {
    	return null;
    }
    
    /**
     * Returns a possible Widget of an external component. This should actually be an {@link Widget}.
     */
	@JsMethod
    public default Object getUxWidget() {
    	return (this instanceof Widget) ? ((Widget) this).asWidget() : null;
    }
    
	@JsMethod
    public default void detachUxElement() {
    	//NOP
    }
    
    /**
     * Returns true if the view is ready.
     */
	@JsMethod
    public default boolean isViewReady() {
    	return true;
    }
	
	/**
	 * Sends a message to the view.
	 * @param messageType - the message type
	 * @param message - the message itself
	 * @param messageContext - the message context
	 */
	@JsMethod
	public default void sendUxMessage(String messageType, String message, Object messageContext) {
		//NOP
	}
	
	/**
	 * This method puts the view on hold while waiting for some reply.
	 * It may be used, for example, for asking for a save before closing a view.
	 */
	@JsMethod
	public default Future<Boolean> waitReply() {
		return null;
	}
    
}
