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

import java.util.List;

import com.braintribe.common.lcd.Pair;
import com.braintribe.model.generic.GenericEntity;

public class EntitiesProviderResult {
	
	private List<GenericEntity> entities;
	private List<Pair<GenericEntity, String>> entityAndDisplayList;
	private int offset;
	private boolean hasMore;
	
	public EntitiesProviderResult(List<GenericEntity> entities, int offset, boolean hasMore) {
		this.entities = entities;
		this.offset = offset;
		this.hasMore = hasMore;
	}
	
	public EntitiesProviderResult(int offset, boolean hasMore, List<Pair<GenericEntity, String>> entityAndDisplayList) {
		this.offset = offset;
		this.hasMore = hasMore;
		this.entityAndDisplayList = entityAndDisplayList;
	}
	
	public List<GenericEntity> getEntities() {
		return entities;
	}
	
	public List<Pair<GenericEntity, String>> getEntityAndDisplayList() {
		return entityAndDisplayList;
	}
	
	public void setEntities(List<GenericEntity> entities) {
		this.entities = entities;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public boolean isHasMore() {
		return hasMore;
	}
	
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	

}
