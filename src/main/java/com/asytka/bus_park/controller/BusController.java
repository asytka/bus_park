package com.asytka.bus_park.controller;

import com.asytka.bus_park.model.Bus;
import com.asytka.bus_park.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BusController {
    @Autowired
    BusRepository repo;

    @GetMapping("/index")
    public String dashboard(Model model) {
        List<Bus> parkingBuses = repo.findByOnRoute(false);
        List<Bus> routeBuses = repo.findByOnRoute(true);

        model.addAttribute("parkingBuses", parkingBuses);
        model.addAttribute("routeBuses", routeBuses);

        return "index";
    }

    @PostMapping("/index/buses/add")
    public Bus addBus(@RequestBody Bus bus) {
        repo.save(bus); // this saves the bus and returns the saved instance
        return bus;
    }

    @PutMapping("/index/buses/sendToRoute/{id}")
    public ResponseEntity<Bus> sendToRoute(@PathVariable Long id) {
        Optional<Bus> optionalBus = repo.findById(id);
        if (optionalBus.isPresent()) {
            Bus bus = optionalBus.get();
            bus.setOnRoute(true);
            repo.save(bus);
            return ResponseEntity.ok(bus);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/index/buses/sendToParking/{id}")
    public ResponseEntity<Bus> sendToParking(@PathVariable Long id) {
        Optional<Bus> optionalBus = repo.findById(id);
        if (optionalBus.isPresent()) {
            Bus bus = optionalBus.get();
            bus.setOnRoute(false);
            repo.save(bus);
            return ResponseEntity.ok(bus);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}