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
package edu.ycp.cs.dh.acegwt.client.ace;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a cursor position.
 */
public class AceEditorCursorPosition {
	private final int row, column;
	
	/**
	 * Constructor.
	 * 
	 * @param row     row (0 for first row)
	 * @param column  column (0 for first column)
	 */
	public AceEditorCursorPosition(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	/**
	 * @return the row (0 for first row)
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * @return the column (0 for first column)
	 */
	public int getColumn() {
		return column;
	}
	
	@Override
	public String toString() {
		return row + ":" + column;
	}
	
	/**
	 * Static creation method.
	 * This is handy for calling from JSNI code.
	 * 
	 * @param row     the row
	 * @param column  the column
	 * @return the {@link AceEditorCursorPosition}
	 */
	public static AceEditorCursorPosition create(int row, int column) {
		return new AceEditorCursorPosition(row, column);
	}
	
	/**
	 * Convert to a native Ace JavaScript position object
	 * (with integer-valued <code>row</code> and <code>column</code> fields.)
	 * 
	 * @return native Ace JavaScript position object
	 */
	public native JavaScriptObject toJsObject() /*-{
		return {
			row: this.@edu.ycp.cs.dh.acegwt.client.ace.AceEditorCursorPosition::row,
			column: this.@edu.ycp.cs.dh.acegwt.client.ace.AceEditorCursorPosition::column
		};
	}-*/;
}
