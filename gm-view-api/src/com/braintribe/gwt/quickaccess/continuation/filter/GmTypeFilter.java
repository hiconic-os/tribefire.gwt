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
package com.braintribe.gwt.quickaccess.continuation.filter;

import java.util.function.Predicate;

import com.braintribe.model.generic.typecondition.TypeCondition;
import com.braintribe.model.meta.GmType;

public class GmTypeFilter<T extends GmType> implements Predicate<T> {

	private TypeCondition typeCondition;
	
	public void setTypeCondition(TypeCondition typeCondition) {
		this.typeCondition = typeCondition;
	}

	@Override
	public boolean test(T type) {
		return typeCondition == null || typeCondition.matches(type);
	}

}
