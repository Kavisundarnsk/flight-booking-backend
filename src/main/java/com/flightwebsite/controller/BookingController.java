package com.flightwebsite.controller;

import com.flightwebsite.entity.Booking;
import com.flightwebsite.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;   // 👈 THIS LINE ADD PANNU

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingRepository repo;

    @PostMapping
    public Booking saveBooking(@RequestBody Booking booking){
        return repo.save(booking);
    }

    @GetMapping
    public List<Booking> getBookings(){
        return repo.findAll();
    }

    @DeleteMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable long id){
        repo.deleteById(id);
        return "Booking Cancelled";
    }
}
