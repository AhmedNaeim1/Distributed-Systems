package com.ahmednaeim.demo3.Controller;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.ahmednaeim.demo3.beans.serverImplementationClass;
import com.ahmednaeim.demo3.model.book;
import com.ahmednaeim.demo3.model.bookings;

import java.util.Collections;
import java.util.List;

@Stateless
@Path("/api/receptionists")
public class ReceptionistsEJB {

    @EJB
    private serverImplementationClass service;

    @GET
    @Path("/getRoom/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoomAvailability(@PathParam("id") int id) {
        try {
            boolean result = service.getRoomAvailability(id);
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(false).build();
        }
    }

    @POST
    @Path("/bookRoom")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response booking(book e) {
        try {
            String result = service.addBooking(e.getRoomID(), e.getCustomerID(), e.getCheckInDate(), e.getCheckOutDate());
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred during booking.").build();
        }
    }

    @GET
    @Path("/getBookings/{roomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoomBookings(@PathParam("roomId") long roomId) {
        try {
            List<bookings> result = service.getRoomBookings(roomId);
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Collections.emptyList()).build();
        }
    }

    @GET
    @Path("/getBookings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookings() {
        try {
            List<bookings> result = service.getBookings();
            return Response.ok(result).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Collections.emptyList()).build();
        }
    }
}
