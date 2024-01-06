package com.AhmedNaeim.assignment3.Server;

import com.AhmedNaeim.assignment3.model.bookings;
import com.AhmedNaeim.assignment3.model.users;
import com.AhmedNaeim.assignment3.model.rooms;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class hotelService {
    private static final Object lock = new Object();
    private static final List<users> staff = new ArrayList<>();
    private static final List<users> customers = new ArrayList<>();
    private static final List<bookings> booking = new ArrayList<>();
    private static final List<rooms> room = new ArrayList<>();

    static {
        {
//            staff.add(new users(1, "ahmed", "sawsan", "manager"));
//            staff.add(new users(5, "khaled", "sawsan", "admins"));
//            staff.add(new users(2, "mohamed", "sawsan", "receptionist"));
//            staff.add(new users(3, "ali", "sawsan", "receptionist"));
//            staff.add(new users(4, "ola", "sawsan", "customer"));

        }
    }

    public List<users> getAllEmployees() {
        return staff;
    }

    public List<bookings> getBookings() {
        return booking;
    }

    public List<bookings> getRoomBookings(int id) {
        final List<bookings> bookingsList = new ArrayList<>();

        for (int i = 0; i < booking.size(); i++) {
            if (Objects.equals(booking.get(i).getRoom().getRoomID(), id)) {
                bookingsList.add(booking.get(i));
            }
        }
        return bookingsList;

    }

    public List<Boolean> getRoomsOccupancy() {
        final List<Boolean> roomsList = new ArrayList<>();

        for (int i = 0; i < room.size(); i++) {

            roomsList.add(room.get(i).getAvailability());

        }
        return roomsList;

    }

    public boolean getRoomAvailability(int id) {
        synchronized (lock) {
            return room.stream()
                    .filter(e -> e.getRoomID() == id)
                    .findFirst()
                    .orElse(null).getAvailability();
        }
    }

    //adding employee
    public users addEmployee(String Username, String Password, String role) {
        synchronized (lock) {
            users x = new users(4, Username, Password, role);

            staff.add(x);
            return x;
        }
    }

    public users loginCustomer(String Username, String Password) {


        return customers.stream()
                .filter(e -> Objects.equals(e.getName(), Username) && Objects.equals(e.getPassword(), Password))
                .findFirst()
                .orElse(null);
    }

    public bookings viewBooking(int id) {


        return booking.stream()
                .filter(e -> Objects.equals(e.getBookingID(), id))
                .findFirst()
                .orElse(null);
    }

    public String registerCustomer(String Username, String Password) {
        synchronized (lock) {
            users x = new users(4, Username, Password, "customer");

            customers.add(x);
            return "User registered successfully";
        }
    }

    public String addBooking(rooms room, users customer, Date checkInDate, Date checkOutDate) {
        if (room.getAvailability()) {
            synchronized (lock) {
                bookings x = new bookings(5, checkInDate, room, checkOutDate, customer);
                room.setAvailability(false);
                booking.add(x);
                return "Booked Successful";
            }
        } else {
            return "Room not available";
        }

    }


    //single employee
    public users getEmployee(int id) {
        return staff.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<bookings> getCustomerBookings(int id) {

        final List<bookings> bookingsList = new ArrayList<>();

        for (int i = 0; i < booking.size(); i++) {
            if (booking.get(i).getCustomer().getId() == id) {
                bookingsList.add(booking.get(i));

            }

        }
        return bookingsList;

    }

    public boolean deleteEmployee(int id) {

        Optional<users> employeeToRemove = staff.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (employeeToRemove.isPresent()) {
            synchronized (lock) {
                staff.remove(employeeToRemove.get());
                return true;
            }
        } else {
            return false; // Employee not found
        }
    }

}
