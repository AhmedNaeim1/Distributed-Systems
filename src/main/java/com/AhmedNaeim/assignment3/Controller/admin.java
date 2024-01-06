package com.AhmedNaeim.assignment3.Controller;

import com.AhmedNaeim.assignment3.Server.hotelService;
import com.AhmedNaeim.assignment3.model.users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class admin {
    private final hotelService hotelService;

    public admin(
            hotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<List<users>> getAllEmployees() {
        try {
            List<users> result = hotelService.getAllEmployees();
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<users> addEmployee(@RequestBody users e) {
        try {
            users result = hotelService.addEmployee(e.getName(), e.getPassword(), e.getRole());
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<users> getEmployee(@PathVariable int id) {
        try {
            users result = hotelService.getEmployee(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) {
        try {
            Boolean result = hotelService.deleteEmployee(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

//    @GetMapping("/users")
//    public List<hotelEmployeesModel> getAllUsers() {
//        return hotelService.getAllUsers();
//    }
}