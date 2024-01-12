package com.ahmednaeim.demo3.Controller;

import com.ahmednaeim.demo3.beans.serverImplementationClass;
import com.ahmednaeim.demo3.model.users;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collections;
import java.util.List;

@Stateless
@Path("/api/admin")
public class AdminEJB {

    @EJB
    private serverImplementationClass service;

    @GET
    @Path("/getEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        try {
            List<users> result = service.getAllEmployees();
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Collections.emptyList())
                    .build();
        }
    }

    @POST
    @Path("/addEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(users e) {
        try {
            users result = service.addEmployee(e.getName(), e.getPassword(), e.getRole());
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getEmployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") int id) {
        try {
            users result = service.getEmployee(id);
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmployee(@PathParam("id") int id) {
        try {
            Boolean result = service.deleteEmployee(id);
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}