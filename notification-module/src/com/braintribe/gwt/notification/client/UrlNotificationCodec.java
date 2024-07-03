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
package com.braintribe.gwt.notification.client;

import com.braintribe.codec.Codec;
import com.braintribe.codec.CodecException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class UrlNotificationCodec extends AbstractNotificationCodec<String> {
	public UrlNotificationCodec() {
		setJsonCodec(new Codec<JSONObject, String>() {
			@Override
			public JSONObject decode(String encodedValue) throws CodecException {
				JSONValue jsonValue = JSONParser.parseLenient(encodedValue);
				JSONObject jsonObject = jsonValue.isObject();
				if (jsonObject == null)
					throw new CodecException("error casting " + jsonValue + " to JSONObject");
				
				return jsonObject;
			}
			@Override
			public String encode(JSONObject value) throws CodecException {
				throw new UnsupportedOperationException();
			}
			@Override
			public Class<JSONObject> getValueClass() {
				return JSONObject.class;
			}
		});
	}
}
