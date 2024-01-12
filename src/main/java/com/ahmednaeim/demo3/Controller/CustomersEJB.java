package com.ahmednaeim.demo3.Controller;
import com.ahmednaeim.demo3.beans.serverImplementationClass;
import com.ahmednaeim.demo3.model.users;
import com.ahmednaeim.demo3.model.book;
import com.ahmednaeim.demo3.model.bookings;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collections;
import java.util.List;

@Path("/api/customer")
public class CustomersEJB {

    @EJB
    private serverImplementationClass service;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerCustomer(users e) {
        try {
            String result = service.registerCustomer(e.getName(), e.getPassword());
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred during registration.")
                    .build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginCustomer(users e) {
        try {
            users result = service.loginCustomer(e.getName(), e.getPassword());
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getCustomerBookings/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerBookings(@PathParam("id") int id) {
        try {
            List<bookings> result = service.getCustomerBookings(id);
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Collections.emptyList())
                    .build();
        }
    }

    @POST
    @Path("/bookRoom")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookRoom(book e) {
        try {
            String result = service.addBooking(e.getRoomID(), e.getCustomerID(), e.getCheckInDate(), e.getCheckOutDate());
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred during booking.")
                    .build();
        }
    }

    @GET
    @Path("/viewBooking/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewBooking(@PathParam("id") int id) {
        try {
            bookings result = service.viewBooking(id);
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
