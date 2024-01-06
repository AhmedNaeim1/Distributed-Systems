package com.AhmedNaeim.assignment3.Controller;

import com.AhmedNaeim.assignment3.Server.hotelService;
import com.AhmedNaeim.assignment3.model.bookings;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receptionists")
public class receptionists {
    private final hotelService hotelService;

    public receptionists(
            hotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/getRoom/{id}")
    public boolean getRoomAvailability(@PathVariable int id) {
        return hotelService.getRoomAvailability(id);
    }

    @PostMapping("/bookRoom")
    public String Booking(@RequestBody bookings e) {
        return hotelService.addBooking( e.getRoom(), e.getCustomer(), e.getCheckInDate(), e.getCheckOutDate());
    }

    @GetMapping("/getBookings/{roomId}")
    public List<bookings> getRoomBookings(@PathVariable int roomId) {
        return hotelService.getRoomBookings(roomId);
    }

    @GetMapping("/getBookings")
    public List<bookings> getBookings() {
        return hotelService.getBookings();
    }
}
