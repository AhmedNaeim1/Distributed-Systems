package com.ahmednaeim.demo3.beans;

import com.ahmednaeim.demo3.model.bookings;
import com.ahmednaeim.demo3.model.users;
import jakarta.ejb.Local;

import java.util.Date;
import java.util.List;


public interface Hello {
    List<users> getAllEmployees();

    List<bookings> getBookings();

    List<bookings> getRoomBookings(long id);

    List<Object> getRoomsOccupancy();

    boolean getRoomAvailability(int id);

    users addEmployee(String username, String password, String role);

    users loginCustomer(String username, String password);

    bookings viewBooking(int id);

    String registerCustomer(String username, String password);

    String addBooking(long roomID, long customerID, Date checkInDate, Date checkOutDate);

    users getEmployee(int id);

    List<bookings> getCustomerBookings(int id);

    boolean deleteEmployee(int id);
}
