package com.theironyard.charlotte;

import java.util.List;

/**
 * Created by graceconnelly on 12/19/16.
 */
public class Lot {
    private String id;
    private int capacity;
    private int rate;
    private List<Vehicle> vehicles;
    private int count;

    public Lot(String id, int capacity, int rate, List<Vehicle> vehicles, int count) {
        this.id = id;
        this.capacity = capacity;
        this.rate = rate;
        this.vehicles = vehicles;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //method to actually add a vehicle to a lot
    public void addVehicle (VehicleToLot newVehicle){
        getVehicles().add(new Vehicle(newVehicle.getName(),newVehicle.getSize(),newVehicle.getMoney()));
    }

}
