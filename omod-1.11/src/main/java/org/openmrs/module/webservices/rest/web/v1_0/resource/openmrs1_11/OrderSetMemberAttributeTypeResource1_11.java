package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_11;


import org.openmrs.OrderSetMemberAttributeType;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.MetadataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.ArrayList;
import java.util.List;

@Resource(name = RestConstants.VERSION_1 + "/ordersetmemberattributetype" , supportedClass = OrderSetMemberAttributeType.class, supportedOpenmrsVersions = { "1.11.*" })
public class OrderSetMemberAttributeTypeResource1_11 extends MetadataDelegatingCrudResource<OrderSetMemberAttributeType>{

    @Override
    public OrderSetMemberAttributeType getByUniqueId(String uniqueId) {
        return null;
    }


    public OrderSetMemberAttributeType getByName(String name) {
        return Context.getOrderSetMemberAttributeTypeService().getByName(name);
}

    @Override
    public OrderSetMemberAttributeType newDelegate() {
        return new OrderSetMemberAttributeType();
    }

    @Override
    public OrderSetMemberAttributeType save(OrderSetMemberAttributeType delegate) {
        return null;
    }

    @Override
    public void purge(OrderSetMemberAttributeType delegate, RequestContext context) throws ResponseException {

    }

    /**
     * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource#doGetAll(org.openmrs.module.webservices.rest.web.RequestContext)
     */
    @Override
    protected NeedsPaging<OrderSetMemberAttributeType> doGetAll(RequestContext context) {
        return new NeedsPaging<OrderSetMemberAttributeType>(Context.getOrderSetMemberAttributeTypeService().getAllOrderSetMemberAttributeTypes(), context);
    }

    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        if (rep instanceof DefaultRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("orderSetMemberAttributeTypeId");
            description.addProperty("name");
            description.addProperty("description");
            description.addProperty("retired");
            description.addProperty("uuid");

            description.addSelfLink();
            description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
            return description;
        } else if (rep instanceof RefRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("orderSetMemberAttributeTypeId");
            description.addProperty("name");
            description.addProperty("description");
            description.addProperty("uuid");
            description.addSelfLink();
            return description;
        }
        else if (rep instanceof FullRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("orderSetMemberAttributeTypeId");
            description.addProperty("name");
            description.addProperty("description");
            description.addProperty("uuid");
            description.addProperty("retired");
            description.addProperty("retireReason");
            description.addProperty("retiredBy");
            description.addProperty("auditInfo", findMethod("getAuditInfo"));
            description.addSelfLink();
            return description;
        } else {
            return null;
        }
    }

    @Override
    public DelegatingResourceDescription getCreatableProperties() {
        DelegatingResourceDescription d = new DelegatingResourceDescription();
        d.addProperty("orderSetMemberAttributeTypeId");
        d.addProperty("name");
        d.addProperty("uuid");
        d.addProperty("retired");
        d.addProperty("retireReason");
        return d;
    }


    /**
     * @see DelegatingCrudResource#doSearch(RequestContext)
     */
    @Override
    protected NeedsPaging<OrderSetMemberAttributeType> doSearch(RequestContext context) {
        String name = context.getRequest().getParameter("name");
        OrderSetMemberAttributeType orderSetMemberAttributeType = Context.getOrderSetMemberAttributeTypeService().getByName(name);
        List<OrderSetMemberAttributeType> orderSetMemberAttributeTypes = new ArrayList<OrderSetMemberAttributeType>();
        orderSetMemberAttributeTypes.add(orderSetMemberAttributeType);
        return new NeedsPaging<OrderSetMemberAttributeType>(orderSetMemberAttributeTypes, context);
    }

}
