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
package com.braintribe.gwt.simplepropertypanel.client.resources;

import org.vectomatic.dom.svg.ui.SVGResource;
import org.vectomatic.dom.svg.ui.SVGResource.Validated;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface SimplePropertyPanelResources extends ClientBundle{
	
	public static final SimplePropertyPanelResources INSTANCE = (SimplePropertyPanelResources) GWT.create(SimplePropertyPanelResources.class);
	
	@Source("arrowBold.svg") @Validated(validated = false)
	public SVGResource arrow();
	@Source("circleBold.svg") @Validated(validated = false)
	public SVGResource circle();
	@Source("doubleCircleBold.svg") @Validated(validated = false)
	public SVGResource doubleCircle();
	@Source("doubleCircleArrowBold.svg") @Validated(validated = false)
	public SVGResource doubleCircleArrow();
	@Source("keyCircle.svg") @Validated(validated = false)
	public SVGResource keyCircle();
	@Source("valueCircle.svg") @Validated(validated = false)
	public SVGResource valueCircle();

}
