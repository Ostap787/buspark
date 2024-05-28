package com.example.buspark.repository;

import com.example.buspark.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {
    List<Bus> findByInPark(boolean inPark);
}
