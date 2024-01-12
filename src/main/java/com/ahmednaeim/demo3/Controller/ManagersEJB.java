package com.ahmednaeim.demo3.Controller;

import com.ahmednaeim.demo3.beans.serverImplementationClass;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collections;
import java.util.List;

@Stateless
@Path("/api/manager")
public class ManagersEJB {

    @EJB
    private serverImplementationClass service;

    @GET
    @Path("/getBookings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoomsOccupancy() {
        try {
            List<Object> result = service.getRoomsOccupancy();
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Collections.emptyList())
                    .build();
        }
    }
}
