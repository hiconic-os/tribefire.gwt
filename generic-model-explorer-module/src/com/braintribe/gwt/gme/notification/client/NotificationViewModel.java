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
package com.braintribe.gwt.gme.notification.client;

import java.util.ArrayList;
import java.util.List;

import com.braintribe.model.notification.ClearNotification;
import com.braintribe.model.notification.Notification;
import com.braintribe.model.notification.NotificationRegistryEntry;

public class NotificationViewModel {

	private NotificationRegistryEntry entry;
	private List<MessageModel> messages;
	private boolean expanded;

	public NotificationViewModel(NotificationRegistryEntry entry) {
		this.entry = entry;
		messages = new ArrayList<>();
		for (Notification n : entry.getNotifications()) {
			if (!(n instanceof ClearNotification)) {
				MessageModel messageModel = new MessageModel(n);
				if (!messageModel.isIgnore())
					messages.add(messageModel);
			}
		}
		this.setExpanded(true);
	}

	public NotificationRegistryEntry getEntry() {
		return entry;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public List<MessageModel> getMessages() {
		return messages;
	}

	public void toogleExpanded() {
		setExpanded(!isExpanded());
	}

}
