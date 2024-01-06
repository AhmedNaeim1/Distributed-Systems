package com.AhmedNaeim.assignment3.Controller;

import com.AhmedNaeim.assignment3.Server.hotelService;
import com.AhmedNaeim.assignment3.model.bookings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/receptionists")
public class receptionists {

    private final hotelService hotelService;

    public receptionists(hotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/getRoom/{id}")
    public ResponseEntity<Boolean> getRoomAvailability(@PathVariable int id) {
        try {
            boolean result = hotelService.getRoomAvailability(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PostMapping("/bookRoom")
    public ResponseEntity<String> booking(@RequestBody bookings e) {
        try {
            String result = hotelService.addBooking(e.getRoom(), e.getCustomer(), e.getCheckInDate(), e.getCheckOutDate());
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during booking.");
        }
    }

    @GetMapping("/getBookings/{roomId}")
    public ResponseEntity<List<bookings>> getRoomBookings(@PathVariable int roomId) {
        try {
            List<bookings> result = hotelService.getRoomBookings(roomId);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @GetMapping("/getBookings")
    public ResponseEntity<List<bookings>> getBookings() {
        try {
            List<bookings> result = hotelService.getBookings();
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
}
