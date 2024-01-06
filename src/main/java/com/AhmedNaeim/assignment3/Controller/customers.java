package com.AhmedNaeim.assignment3.Controller;

import com.AhmedNaeim.assignment3.Server.hotelService;
import com.AhmedNaeim.assignment3.model.bookings;
import com.AhmedNaeim.assignment3.model.users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class customers {

    private final hotelService hotelService;

    public customers(
            hotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody users e) {
        try {
            String result = hotelService.registerCustomer(e.getName(), e.getPassword());
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during registration.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody users e) {
        try {
            users result = hotelService.loginCustomer(e.getName(), e.getPassword());
            return ResponseEntity.ok(result == null ? "Wrong credentials" : "Logged in successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login.");
        }
    }

    @GetMapping("/getCustomerBookings/{id}")
    public ResponseEntity<List<bookings>> getCustomerBookings(@PathVariable int id) {
        try {
            List<bookings> result = hotelService.getCustomerBookings(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @PostMapping("/bookRoom")
    public ResponseEntity<String> bookRoom(@RequestBody bookings e) {
        try {
            String result = hotelService.addBooking(e.getRoom(), e.getCustomer(), e.getCheckInDate(), e.getCheckOutDate());
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during booking.");
        }
    }

    @GetMapping("/viewBooking/{id}")
    public ResponseEntity<bookings> viewBooking(@PathVariable int id) {
        try {
            bookings result = hotelService.viewBooking(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
