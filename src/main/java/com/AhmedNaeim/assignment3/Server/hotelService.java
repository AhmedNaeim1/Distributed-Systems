package com.AhmedNaeim.assignment3.Server;

import com.AhmedNaeim.assignment3.model.bookings;
import com.AhmedNaeim.assignment3.model.users;
import com.AhmedNaeim.assignment3.model.rooms;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class hotelService {
//    @Autowired
//    private Hello hello;
    private static final Object lock = new Object();
    private static final List<users> staff = new ArrayList<>();
    private static final List<users> customers = new ArrayList<>();
    private static final List<bookings> booking = new ArrayList<>();
    private static final List<rooms> room = new ArrayList<>();

    static {
        {
            staff.add(new users(0, "khaled", "ahmed", "admins"));
            customers.add(new users(1, "khaled", "ahmed", "customer"));
            room.add(new rooms(1, "Double", 200, true));
            room.add(new rooms(2, "Single", 200, true));
            room.add(new rooms(3, "Double", 200, true));
            room.add(new rooms(4, "Single", 200, true));
            room.add(new rooms(5, "Double", 200, true));
            room.add(new rooms(6, "Single", 200, true));
        }
    }

    public List<users> getAllEmployees() {
        return staff;
    }

    public List<bookings> getBookings() {
        return booking;
    }

    public List<bookings> getRoomBookings(long id) {
        final List<bookings> bookingsList = new ArrayList<>();

        for (int i = 0; i < booking.size(); i++) {
            if (Objects.equals(booking.get(i).getRoom().getRoomID(), id)) {
                bookingsList.add(booking.get(i));
            }
        }
        return bookingsList;

    }


    public List<Object> getRoomsOccupancy() {
        final List<Object> roomsList = new ArrayList<>();

        for (int i = 0; i < room.size(); i++) {
            List<Object> x = Arrays.asList(room.get(i).getRoomID(), room.get(i).getAvailability());
            roomsList.add(x);
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

    public String addBooking(@NotNull long roomID, long customerID, Date checkInDate, Date checkOutDate) {
        rooms x = room.stream()
                .filter(e -> Objects.equals(e.getRoomID(), roomID))
                .findFirst()
                .orElse(null);

        users z = customers.stream()
                .filter(e -> Objects.equals(e.getId(), customerID))
                .findFirst()
                .orElse(null);
        if (x != null && x.getAvailability()) {
            if (z != null) {
                synchronized (lock) {
                    bookings y = new bookings(5, checkInDate, x, checkOutDate, z);
                    x.setAvailability(false);
                    booking.add(y);
                    return "Booked Successful";

                }
            } else {
                return "User not registered";
            }
        } else {
            return "Roon not available";
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
