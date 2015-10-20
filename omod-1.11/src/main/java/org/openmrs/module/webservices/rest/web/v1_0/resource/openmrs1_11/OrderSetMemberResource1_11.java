/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_11;

import org.openmrs.OrderSetMember;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + "/ordersetmember", supportedClass = OrderSetMember.class, supportedOpenmrsVersions = { "1.11.*" })
public class OrderSetMemberResource1_11 extends DataDelegatingCrudResource<OrderSetMember> {

    @Override
    public OrderSetMember getByUniqueId(String uniqueId) {
        return null;
    }

    @Override
    protected void delete(OrderSetMember delegate, String reason, RequestContext context) throws ResponseException {

    }

    @Override
    public OrderSetMember newDelegate() {
        return new OrderSetMember();
    }

    @Override
    public OrderSetMember save(OrderSetMember delegate) {
        return null;
    }

    @Override
    public void purge(OrderSetMember delegate, RequestContext context) throws ResponseException {

    }

    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        if (rep instanceof DefaultRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("orderSetMemberId");
            description.addProperty("uuid");
            description.addProperty("orderType");
            description.addProperty("orderTemplate");
            description.addProperty("sequence");
            description.addProperty("concept");
            description.addProperty("voided");
            description.addSelfLink();
            description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
            return description;
        } else if (rep instanceof FullRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("orderSetMemberId");
            description.addProperty("uuid");
            description.addProperty("orderType");
            description.addProperty("orderTemplate");
            description.addProperty("sequence");
            description.addProperty("concept");
            description.addProperty("voided");
            description.addProperty("voidedBy");
            description.addProperty("auditInfo", findMethod("getAuditInfo"));
            description.addSelfLink();
            return description;
        } else {
            return null;
        }
    }

    @Override
    public DelegatingResourceDescription getCreatableProperties() {
        DelegatingResourceDescription description = new DelegatingResourceDescription();
        description.addProperty("orderSetMemberId");
        description.addProperty("uuid");
        description.addProperty("orderType");
        description.addProperty("orderTemplate");
        description.addProperty("sequence");
        description.addProperty("concept");
        description.addProperty("voided");
        return description;
    }

}
