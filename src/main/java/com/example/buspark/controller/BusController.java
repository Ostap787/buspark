package com.example.buspark.controller;

import com.example.buspark.model.Bus;
import com.example.buspark.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Bus> addBus(@RequestBody Bus newBus) {
        try {
            Bus addedBus = busService.addBus(newBus);
            return ResponseEntity.status(201).body(addedBus);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping("/moveToRoute/{id}")
    public ResponseEntity<Void> moveToRoute(@PathVariable Long id) {
        busService.moveToRoute(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/moveToPark/{id}")
    public ResponseEntity<Void> moveToPark(@PathVariable Long id) {
        busService.moveToPark(id);
        return ResponseEntity.ok().build();
    }
}
