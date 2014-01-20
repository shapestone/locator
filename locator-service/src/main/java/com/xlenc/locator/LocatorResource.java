package com.xlenc.locator;

import com.xlenc.locator.api.LocatorState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

/**
 * User: Michael Williams
 * Date: 12/15/12
 * Time: 9:37 AM
 */
@Path("/locators")
public class LocatorResource {

    private Logger log = LoggerFactory.getLogger(LocatorResource.class.getName());
    private LocatorService locatorService;

    public LocatorResource(LocatorService locatorService) {
        this.locatorService = locatorService;
    }

    @POST
    @Path("/site-locators")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSite(PostalStateImpl postalLocatorState) {
        final LocatorState locatorState = locatorService.add(postalLocatorState);
        final Map<String, Object> map = singletonMap("id", (Object) locatorState.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/site-locators/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSite(@PathParam("id") String id) {
        final LocatorState readLocatorState = locatorService.read(new LocatorStateImpl(id));
        final Response response;
        if (readLocatorState == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(readLocatorState).build();
        }
        return response;
    }

    @DELETE
    @Path("/site-locators/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSite(@PathParam("id") String id) {
        final int deleted = locatorService.delete(new LocatorStateImpl(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();

    }

    @POST
    @Path("/phone-locators")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPhone(PhoneStateImpl phoneLocatorState) {
        final LocatorState locatorState = locatorService.add(phoneLocatorState);
        final Map<String, Object> map = singletonMap("id", (Object) locatorState.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/phone-locators/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPhone(@PathParam("id") String id) {
        final LocatorState readLocatorState = locatorService.read(new LocatorStateImpl(id));
        final Response response;
        if (readLocatorState == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(readLocatorState).build();
        }
        return response;
    }

    @DELETE
    @Path("/phone-locators/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePhone(@PathParam("id") String id) {
        final int deleted = locatorService.delete(new LocatorStateImpl(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();

    }

    @POST
    @Path("/web-site-locators")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addWebSite(WebSiteStateImpl webSiteState) {
        final LocatorState locatorState = locatorService.add(webSiteState);
        final Map<String, Object> map = singletonMap("id", (Object) locatorState.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/web-site-locators/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readWebSite(@PathParam("id") String id) {
        final LocatorState readLocatorState = locatorService.read(new LocatorStateImpl(id));
        final Response response;
        if (readLocatorState == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(readLocatorState).build();
        }
        return response;
    }

    @DELETE
    @Path("/web-site-locators/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteWebSite(@PathParam("id") String id) {
        final int deleted = locatorService.delete(new LocatorStateImpl(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();
    }

    @POST
    @Path("/email-locators")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmail(EmailStateImpl emailState) {
        log.debug(emailState.toString());
        final LocatorState locatorState = locatorService.add(emailState);
        final Map<String, Object> map = singletonMap("id", (Object) locatorState.getId());
        return Response.ok().status(CREATED).entity(map).build();
    }

    @GET
    @Path("/email-locators/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readEmail(@PathParam("id") String id) {
        final LocatorState readLocatorState = locatorService.read(new LocatorStateImpl(id));
        final Response response;
        if (readLocatorState == null) {
            response = Response.status(NOT_FOUND).build();
        } else {
            response = Response.status(OK).entity(readLocatorState).build();
        }
        return response;
    }

    @DELETE
    @Path("/email-locators/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmail(@PathParam("id") String id) {
        final int deleted = locatorService.delete(new LocatorStateImpl(id));
        final Map<String, Object> responseEntity = new HashMap<String, Object>();
        responseEntity.put("deleted", (deleted > 0));
        responseEntity.put("affected", deleted);
        return Response.ok(responseEntity).build();
    }

}
