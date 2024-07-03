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
package com.braintribe.model.processing.modellergraph.filter.experts;

import com.braintribe.model.meta.GmMetaModel;
import com.braintribe.model.meta.GmType;
import com.braintribe.model.modellerfilter.ModelFilter;
import com.braintribe.model.processing.modellergraph.filter.CondensedRelationshipContext;
import com.braintribe.model.processing.modellergraph.filter.RelationshipFilterer;
import com.braintribe.model.processing.modellergraph.filter.relationship.Relationship;

public class ModelFilterer implements RelationshipFilterer<ModelFilter> {
	@Override
	public boolean matches(CondensedRelationshipContext relationshipContext,
			RelationshipFiltererContext filtererContext,
			ModelFilter relationshipFilter) {
		
		try{
			GmMetaModel model = relationshipFilter.getModel();
			GmType fromType = relationshipContext.getRelationship().getFromType().getGmType();
			GmType toType =  relationshipContext.getRelationship().getToType().getGmType();
			
			return fromType.getDeclaringModel() == model || toType.getDeclaringModel() == model;
		}catch(Exception ex){
			return true;
		}
		
	}
	
	@Override
	public boolean matches(Relationship relationship, RelationshipFiltererContext filtererContext, ModelFilter relationshipFilter) {
		
		try{
			GmMetaModel model = relationshipFilter.getModel();
			GmType fromType = relationship.getFromType();
			GmType toType = relationship.getToType();
			
			return fromType.getDeclaringModel() == model || toType.getDeclaringModel() == model;
		}catch(Exception ex){
			return true;
		}
		
	}
}
