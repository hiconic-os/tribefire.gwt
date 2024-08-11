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
package com.braintribe.gwt.gmview.util.client;

import java.util.Map;

import com.braintribe.gwt.logging.client.Logger;
import com.braintribe.model.generic.pr.criteria.TraversingCriterion;
import com.braintribe.model.generic.processing.pr.fluent.TC;
import com.braintribe.model.meta.data.prompt.AutoExpand;
import com.braintribe.model.processing.query.tools.PreparedTcs;
import com.braintribe.model.processing.session.api.persistence.PersistenceGmSession;
import com.braintribe.model.template.Template;
import com.sencha.gxt.core.shared.FastMap;

/**
 * Util class for handling some {@link TraversingCriterion} related operations.
 * @author michel.docouto
 *
 */
@SuppressWarnings("deprecation")
public class GMETraversingCriterionUtil {
	private static final Logger logger = new Logger(GMETraversingCriterionUtil.class);
	
	private static Map<String, TraversingCriterion> depthMap;
	
	static {
		prepareMap();
	}
	
	/**
	 * Checks for the {@link AutoExpand} metadata, and prepares a TC accordingly.
	 */
	public static TraversingCriterion prepareForDepthTC(TraversingCriterion currentTC, Object queryOrTemplate, String entityTypeSignature, PersistenceGmSession gmSession, String useCase) {
		AutoExpand autoExpand = null;
		if (queryOrTemplate instanceof Template) {
			Template template = (Template) queryOrTemplate;
			autoExpand = GMEMetadataUtil.getTemplateMetaData(template, AutoExpand.T, null);
		}
		
		if (autoExpand == null && entityTypeSignature != null) {
			autoExpand = gmSession.getModelAccessory().getMetaData().entityTypeSignature(entityTypeSignature).lenient(true).useCase(useCase).meta(AutoExpand.T)
					.exclusive();
		}
		
		if (autoExpand == null)
			return currentTC;
		
		TraversingCriterion depthTC = getDepthTC(autoExpand.getDepth());
		if (depthTC == null)
			return currentTC;
		
		if (currentTC == null)
			return depthTC;
		
		return join(currentTC, depthTC);
	}
	
	/**
	 * Joins two TC via a conjunction.
	 */
	public static TraversingCriterion join(TraversingCriterion currentTC, TraversingCriterion newTC) {
		if (currentTC == null)
			return newTC;
		
		return TC.create().conjunction().criterion(currentTC).criterion(newTC).close().done();
	}

	/**
	 * Gets a TC according to the given depth
	 * @param depth - For now it can be either "shallow", "reachable" or a number for the level.
	 */
	public static TraversingCriterion getDepthTC(String depth) {
		if (depth == null)
			return null;
		
		TraversingCriterion traversingCriterion = depthMap.get(depth);
		return traversingCriterion != null ? traversingCriterion : getLevelTC(depth);
	}
	
	private static TraversingCriterion getLevelTC(String depth) {
		try {
			int level = Integer.parseInt(depth);
			return getLevelTC(level);
		} catch (NumberFormatException ex) {
			logger.error("There is no known TC expert for the given depth: " + depth);
		}
		
		return null;
	}

	private static TraversingCriterion getLevelTC(int level) {
		TraversingCriterion shallow = getShallowTC();
		// @formatter:off
		return TC.create()
				.pattern() // pattern 1
					.recursion(level, level)
						.pattern() // pattern 2
							.entity()
							.disjunction() // disjunction 1
								.property()
								.pattern() // pattern 3
									.property()
									.disjunction() // disjunction 2
										.listElement()
										.setElement()
										.pattern().map().mapKey().close()
										.pattern().map().mapValue().close()
									.close() // disjunction 2
								.close() // pattern 3
							.close() // disjunction 1
						.close() // pattern 2
					.criterion(shallow)
				.close() // pattern 1
			.done();
		// @formatter:on
	}

	private static void prepareMap() {
		depthMap = new FastMap<>();
		
		depthMap.put("shallow", getShallowTC());
		depthMap.put("reachable", getReachableTC());
	}

	private static TraversingCriterion getReachableTC() {
		return PreparedTcs.everythingTc;
	}

	private static TraversingCriterion getShallowTC() {
		return PreparedTcs.scalarOnlyTc;
	}
	
}
