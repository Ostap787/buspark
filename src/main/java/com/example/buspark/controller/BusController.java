package com.example.buspark.controller;

import com.example.buspark.model.Bus;
import com.example.buspark.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping("/inPark")
    public List<Bus> getBusesInPark() {
        return busService.getBusesInPark();
    }

    @GetMapping("/onRoute")
    public List<Bus> getBusesOnRoute() {
        return busService.getBusesOnRoute();
    }

    @PostMapping("/moveToRoute/{id}")
    public void moveToRoute(@PathVariable Long id) {
        busService.moveToRoute(id);
    }

    @PostMapping("/moveToPark/{id}")
    public void moveToPark(@PathVariable Long id) {
        busService.moveToPark(id);
    }
}
