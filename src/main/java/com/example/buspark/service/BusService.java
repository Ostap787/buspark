package com.example.buspark.service;

import com.example.buspark.model.Bus;
import com.example.buspark.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public List<Bus> getBusesInPark() {
        return busRepository.findByInPark(true);
    }

    public List<Bus> getBusesOnRoute() {
        return busRepository.findByInPark(false);
    }

    public Bus addBus(Bus newBus) {
        newBus.setInPark(true); // By default, new buses are in park
        return busRepository.save(newBus);
    }

    public void moveToRoute(Long id) {
        Optional<Bus> busOptional = busRepository.findById(id);
        if (busOptional.isPresent()) {
            Bus bus = busOptional.get();
            bus.setInPark(false);
            busRepository.save(bus);
        }
    }

    public void moveToPark(Long id) {
        Optional<Bus> busOptional = busRepository.findById(id);
        if (busOptional.isPresent()) {
            Bus bus = busOptional.get();
            bus.setInPark(true);
            busRepository.save(bus);
        }
    }
}
