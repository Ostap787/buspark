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

    @Column(name = "driver_name", nullable = false)
    private String driverName;

    @Column(name = "in_park", nullable = false)
    private boolean inPark;

    // Constructors
    public Bus(String busNumber) {
        this.busNumber = busNumber;
    }

    public Bus(String busNumber, String routeNumber, String driverName, boolean inPark) {
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.driverName = driverName;
        this.inPark = inPark;
    }

    public Bus() {

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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public boolean isInPark() {
        return inPark;
    }

    public void setInPark(boolean inPark) {
        this.inPark = inPark;
    }
}
