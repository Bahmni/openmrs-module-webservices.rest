/**
 * The contents of this file are subject to the OpenMRS Public License Version
 * 1.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * Copyright (C) OpenMRS, LLC. All Rights Reserved.
 */
package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_11;

import org.junit.Before;
import org.openmrs.OrderSet;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RestTestConstants1_11;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest;

/**
 * Contains tests for the {@link OrderSetResource1_11}
 */
public class OrderSetResource1_11Test extends BaseDelegatingResourceTest<OrderSetResource1_11, OrderSet> {
    //
    @Before
    public void before() throws Exception {
        executeDataSet(RestTestConstants1_11.TEST_DATASET);
    }

    @Override
    public OrderSet newObject() {
        return Context.getOrderSetService().getOrderSetByUniqueUuid(getUuidProperty());
    }

    @Override
    public void validateDefaultRepresentation() throws Exception {
        super.validateDefaultRepresentation();
        assertPropEquals("name", getObject().getName());
        assertPropEquals("description", getObject().getDescription());
    }

    @Override
    public void validateFullRepresentation() throws Exception {
        super.validateFullRepresentation();
        assertPropEquals("name", getObject().getName());
        assertPropEquals("description", getObject().getDescription());
        assertPropPresent("auditInfo");
    }

    @Override
    public String getDisplayProperty() {

        return "test";
    }

    @Override
    public String getUuidProperty() {
        return RestTestConstants1_11.ORDER_SET_UUID;
    }
}