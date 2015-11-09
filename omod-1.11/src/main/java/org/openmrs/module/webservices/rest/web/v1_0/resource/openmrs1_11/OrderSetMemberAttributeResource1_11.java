package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_11;


import org.openmrs.OrderSetMemberAttribute;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + "/ordersetmemberattribute" , supportedClass = OrderSetMemberAttribute.class, supportedOpenmrsVersions = { "1.11.*" })
public class OrderSetMemberAttributeResource1_11 extends DataDelegatingCrudResource<OrderSetMemberAttribute> {


    @Override
    public OrderSetMemberAttribute getByUniqueId(String uniqueId) {
        return null;
    }

    @Override
    protected void delete(OrderSetMemberAttribute delegate, String reason, RequestContext context) throws ResponseException {

    }

    @Override
    public OrderSetMemberAttribute newDelegate() {
        return new OrderSetMemberAttribute();
    }

    @Override
    public OrderSetMemberAttribute save(OrderSetMemberAttribute delegate) {
        return null;
    }

    @Override
    public void purge(OrderSetMemberAttribute delegate, RequestContext context) throws ResponseException {

    }

    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        if (rep instanceof DefaultRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("orderSetMemberAttributeId");
            description.addProperty("uuid");
            description.addProperty("value");
            description.addProperty("orderSetMemberAttributeType", Representation.FULL);

            description.addSelfLink();
            description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
            return description;
        } else if (rep instanceof FullRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("orderSetMemberAttributeId");
            description.addProperty("uuid");
            description.addProperty("value");
            description.addProperty("orderSetMemberAttributeType", Representation.FULL);

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
        d.addProperty("orderSetMemberAttributeId");
        d.addProperty("uuid");
        d.addProperty("value");
        d.addProperty("orderSetMemberAttributeType");
        return d;
    }
}
