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
package edu.ycp.cs.dh.acegwt.client.ace;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Callback interface for events generated by {@link AceEditor}.
 * Note that the argument the callback receives is a
 * JavaScriptObject, so you will probably need to use JSNI to
 * make use of it.
 */
public interface AceEditorCallback {
	/**
	 * Callback method.
	 * 
	 * @param obj the event object: for example, an onChange event
	 *            if this callback is receiving onChange events
	 */
	public void invokeAceCallback(JavaScriptObject obj);
}