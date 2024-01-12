package com.ahmednaeim.demo3.beans;

import com.ahmednaeim.demo3.HotelService;
import com.ahmednaeim.demo3.model.bookings;
import com.ahmednaeim.demo3.model.users;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless (name = "Hello")
@Local
public class serverImplementationClass implements Hello {

    @Inject
    private HotelService hotelService;

    @Override
    public List<users> getAllEmployees() {
        return hotelService.getAllEmployees();
    }

    @Override
    public List<bookings> getBookings() {
        return hotelService.getBookings();
    }

    @Override
    public List<bookings> getRoomBookings(long id) {
        return hotelService.getRoomBookings(id);
    }

    @Override
    public List<Object> getRoomsOccupancy() {
        return hotelService.getRoomsOccupancy();
    }

    @Override
    public boolean getRoomAvailability(int id) {
        return hotelService.getRoomAvailability(id);
    }

    @Override
    public users addEmployee(String username, String password, String role) {
        return hotelService.addEmployee(username, password, role);
    }

    @Override
    public users loginCustomer(String username, String password) {
        return hotelService.loginCustomer(username, password);
    }

    @Override
    public bookings viewBooking(int id) {
        return hotelService.viewBooking(id);
    }

    @Override
    public String registerCustomer(String username, String password) {
        return hotelService.registerCustomer(username, password);
    }

    @Override
    public String addBooking(long roomID, long customerID, Date checkInDate, Date checkOutDate) {
        return hotelService.addBooking(roomID, customerID, checkInDate, checkOutDate);
    }

    @Override
    public users getEmployee(int id) {
        return hotelService.getEmployee(id);
    }

    @Override
    public List<bookings> getCustomerBookings(int id) {
        return hotelService.getCustomerBookings(id);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return hotelService.deleteEmployee(id);
    }
}
