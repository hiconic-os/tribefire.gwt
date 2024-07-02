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
package com.braintribe.gwt.gme.assemblypanel.client.model.factory;

import java.util.function.Consumer;
import java.util.function.Function;

import com.braintribe.gwt.gme.assemblypanel.client.model.AbstractGenericTreeModel;
import com.braintribe.gwt.gme.assemblypanel.client.model.ListTreeModel;
import com.braintribe.gwt.gme.assemblypanel.client.model.MapAsListTreeModel;
import com.braintribe.gwt.gme.assemblypanel.client.model.MapTreeModel;
import com.braintribe.gwt.gme.assemblypanel.client.model.ObjectAndType;
import com.braintribe.gwt.gme.assemblypanel.client.model.SetTreeModel;
import com.braintribe.model.generic.reflection.CollectionType;

public class CollectionTreeModelFactory implements Function<ObjectAndType, AbstractGenericTreeModel>, Consumer<ModelFactory> {
	
	private ModelFactory modelFactory;
	
	public CollectionTreeModelFactory() {
	}
	
	@Override
	public void accept(ModelFactory modelFactory) {
		this.modelFactory = modelFactory;
	}

	@Override
	public AbstractGenericTreeModel apply(ObjectAndType objectAndType) {
		CollectionType collectionType = objectAndType.getType();
		switch (collectionType.getCollectionKind()) {
			case map:
				if (objectAndType.isMapAsList())
					return new MapAsListTreeModel(objectAndType, modelFactory);
				else
					return new MapTreeModel(objectAndType, modelFactory);
			case list:
				return new ListTreeModel(objectAndType, modelFactory);
			case set:
				return new SetTreeModel(objectAndType, modelFactory);
			default:
				return null;
		}
	}

}
