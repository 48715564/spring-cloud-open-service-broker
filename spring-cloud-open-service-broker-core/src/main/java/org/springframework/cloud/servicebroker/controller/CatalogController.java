/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.servicebroker.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.servicebroker.model.catalog.Catalog;
import org.springframework.cloud.servicebroker.service.CatalogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Provide endpoints for the catalog API.
 *
 * @see <a href="https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md#catalog-management">Open Service Broker API specification</a>
 *
 * @author sgreenberg@pivotal.io
 * @author Scott Frederick
 */
@RestController
public class CatalogController extends BaseController {
	private static final Logger LOGGER = getLogger(CatalogController.class);

	@Autowired
	public CatalogController(CatalogService service) {
		super(service);
	}

	@RequestMapping(value = {"/v2/catalog", "{platformInstanceId}/v2/catalog"}, method = RequestMethod.GET)
	public Catalog getCatalog() {
		LOGGER.debug("Retrieving catalog");
		return catalogService.getCatalog();
	}
}
