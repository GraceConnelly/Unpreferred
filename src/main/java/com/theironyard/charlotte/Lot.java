package com.theironyard.charlotte;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by graceconnelly on 12/19/16.
 */
public class Lot {
    private String id;
    private int capacity;
    private int rate;
    private List<Vehicle> vehicles;
    private boolean full;

    public Lot(String id, int capacity, int rate, List<Vehicle> vehicles, boolean full) {
        this.id = id;
        this.capacity = capacity;
        this.rate = rate;
        this.vehicles = vehicles;
        this.full = full;
    }

    public Lot() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public void addVehicle (VehicleToLot newVehicle){
        getVehicles().add(new Vehicle(newVehicle.getName(),newVehicle.getSize(),newVehicle.getMoney()));
    }
}
