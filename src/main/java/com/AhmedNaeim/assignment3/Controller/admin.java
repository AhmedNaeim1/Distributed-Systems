package com.AhmedNaeim.assignment3.Controller;

import com.AhmedNaeim.assignment3.Server.hotelService;
import com.AhmedNaeim.assignment3.model.users;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class admin {
    private final hotelService hotelService;

    public admin(
            hotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/getEmployee")
    public List<users> getAllEmployees() {
        return hotelService.getAllEmployees();
    }


    @PostMapping("/addEmployee")
    public users addEmployee(@RequestBody users e) {
        return hotelService.addEmployee(e.getName(), e.getPassword(), e.getRole());
    }


    @GetMapping("/getEmployee/{id}")
    public users getEmployee(@PathVariable int id) {
        return hotelService.getEmployee(id);
    }


    @DeleteMapping("/employee/{id}")
    public Boolean deleteEmployee(@PathVariable int id) {
        return hotelService.deleteEmployee(id);
    }

//    @GetMapping("/users")
//    public List<hotelEmployeesModel> getAllUsers() {
//        return hotelService.getAllUsers();
//    }
}