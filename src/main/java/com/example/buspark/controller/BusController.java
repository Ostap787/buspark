package com.example.buspark.controller;

import com.example.buspark.model.Bus;
import com.example.buspark.repository.BusRepository;
import com.example.buspark.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private BusRepository busRepository;

    @GetMapping("/inPark")
    public List<Bus> getBusesInPark() {
        return busService.getBusesInPark();
    }

    @GetMapping("/onRoute")
    public List<Bus> getBusesOnRoute() {
        return busService.getBusesOnRoute();
    }


    @PostMapping
    public ResponseEntity<String> addBus(@RequestBody Bus bus) {
        try {
            bus.setInPark(true);  // встановлюємо за замовчуванням, що автобус в парку
            busRepository.save(bus);
            return ResponseEntity.ok("Bus added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add bus");
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
