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
package com.braintribe.model.processing.modellergraph;

import com.braintribe.model.modellergraph.condensed.CondensedModel;
import com.braintribe.model.modellergraph.condensed.CondensedRelationship;
import com.braintribe.model.modellergraph.condensed.CondensedType;
import com.braintribe.model.processing.modellergraph.filter.CondensedRelationshipContext;


public class BasicCondensedRelationshipFilterContext implements CondensedRelationshipContext {
	private int order;
	private CondensedRelationship relationship;
	private CondensedRelationship originalRelationship;
	
	public BasicCondensedRelationshipFilterContext(int order,
			CondensedRelationship originalRelationship, CondensedRelationship relationship) {
		super();
		this.order = order;
		this.relationship = relationship;
		this.originalRelationship = originalRelationship;
	}

	@Override
	public CondensedModel getModel() {
		return relationship.getToType().getModel();
	}
	
	@Override
	public int getOrder() {
		return order;
	}
	
	@Override
	public CondensedRelationship getRelationship() {
		return relationship;
	}
	
	@Override
	public CondensedType getToType() {
		return relationship.getToType();
	}
	
	@Override
	public CondensedRelationship getOriginalRelationship() {
		return originalRelationship;
	}
}
