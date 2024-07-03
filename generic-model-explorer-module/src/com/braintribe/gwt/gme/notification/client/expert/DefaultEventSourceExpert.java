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
package com.braintribe.gwt.gme.notification.client.expert;

import com.braintribe.cfg.Configurable;
import com.braintribe.model.notification.NotificationEventSource;
import com.braintribe.model.processing.notification.api.NotificationEventSourceExpert;

public class DefaultEventSourceExpert implements NotificationEventSourceExpert<NotificationEventSource> {

	private String displayName;

	@Configurable
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String render(NotificationEventSource eventSource) {
		return displayName != null ? displayName : eventSource.getId();
	}

}
