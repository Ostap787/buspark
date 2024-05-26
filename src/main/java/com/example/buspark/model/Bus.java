package com.example.buspark.model;

import javax.persistence.*;

@Entity
@Table(name = "buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bus_number", nullable = false)
    private String busNumber;

    @Column(name = "route_number", nullable = false)
    private String routeNumber;

    @Column(name = "in_park", nullable = false)
    private boolean inPark;

    // Constructors
    public Bus() {}

    public Bus(String busNumber, String routeNumber, boolean inPark) {
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.inPark = inPark;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public boolean isInPark() {
        return inPark;
    }

    public void setInPark(boolean inPark) {
        this.inPark = inPark;
    }
}
