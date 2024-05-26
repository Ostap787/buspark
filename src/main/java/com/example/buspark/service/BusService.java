package com.example.buspark.service;

import com.example.buspark.model.Bus;
import com.example.buspark.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public List<Bus> getBusesInPark() {
        return busRepository.findAll().stream()
                .filter(Bus::isInPark)
                .collect(Collectors.toList());
    }

    public List<Bus> getBusesOnRoute() {
        return busRepository.findAll().stream()
                .filter(bus -> !bus.isInPark())
                .collect(Collectors.toList());
    }

    public void moveToRoute(Long id) {
        Bus bus = busRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bus ID"));
        bus.setInPark(false);
        busRepository.save(bus);
    }

    public void moveToPark(Long id) {
        Bus bus = busRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bus ID"));
        bus.setInPark(true);
        busRepository.save(bus);
    }
}
