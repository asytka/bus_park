package com.asytka.bus_park.controller;

import com.asytka.bus_park.model.Bus;
import com.asytka.bus_park.service.BusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BusRestController {
    private final BusService busService;

    public BusRestController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("stationBuses", busService.getStationBuses());
        model.addAttribute("routeBuses", busService.getRouteBuses());
        return "index";
    }

    @PostMapping("/add")
    public String addBus(@RequestParam String number,
                         @RequestParam String driver,
                         @RequestParam String route) {
        busService.addToStation(new Bus(number, driver, route));
        return "redirect:/";
    }

    @PostMapping("/move")
    public String moveBus(@RequestParam String number) {
        busService.moveToRoute(number);
        return "redirect:/";
    }
}
