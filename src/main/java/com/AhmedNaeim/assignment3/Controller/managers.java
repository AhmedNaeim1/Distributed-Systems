package com.AhmedNaeim.assignment3.Controller;

import com.AhmedNaeim.assignment3.Server.hotelService;
import com.AhmedNaeim.assignment3.model.bookings;
import com.AhmedNaeim.assignment3.model.rooms;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Boolean> getRoomsOccupancy() {
        return hotelService.getRoomsOccupancy();
    }
}
