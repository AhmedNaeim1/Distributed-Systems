package com.AhmedNaeim.assignment3.Controller;

import com.AhmedNaeim.assignment3.Server.hotelService;
import com.AhmedNaeim.assignment3.model.bookings;
import com.AhmedNaeim.assignment3.model.rooms;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class managers {
    private final hotelService hotelService;

    public managers(
            hotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/getBookings")
    public ResponseEntity<List<List>> getRoomsOccupancy() {
        try {
            List<List> result = hotelService.getRoomsOccupancy();
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
}
