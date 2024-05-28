package com.example.buspark.controller;

import com.example.buspark.model.Bus;
import com.example.buspark.repository.BusRepository;
import com.example.buspark.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://ostap787.github.io/Cursed/")
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
public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
    try {
        bus.setInPark(true); // By default, new bus is in the park
        Bus savedBus = busRepository.save(bus);
        return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
    } catch (Exception e) {
        e.printStackTrace(); // Додаємо логування помилки
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
