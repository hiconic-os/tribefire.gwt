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
package com.braintribe.gwt.gxt.gxtresources.whitecolumnheader.client;

import com.sencha.gxt.widget.core.client.grid.ColumnHeader;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class WhiteColumnHeader<M> extends ColumnHeader<M>{

	public WhiteColumnHeader(Grid<M> container, ColumnModel<M> cm) {
		super(container, cm);
	}

	/**
	* Returns the head at the current index.
	*
	* @param column the column index
	* @return the column or null if no match
	*/
	@Override
	public Head getHead(int column) {
      //RVE - need override this function, because head contains only visible columns, than index can be higher as header.size
	  //return (column > -1 && column < heads.size()) ? heads.get(column) : null;
		
	  for (Head head : heads) {
		  if (getHeadColumn(head) == column)
			  return head;
	  }
		
	  return null;
	}
	
	// @formatter:off
	private native int getHeadColumn(Head head) /*-{
		return head.@com.sencha.gxt.widget.core.client.grid.ColumnHeader.Head::column;
	}-*/;
	// @formatter:on	
}
