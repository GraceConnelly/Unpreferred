package com.theironyard.charlotte;

/**
 * Created by graceconnelly on 12/19/16.
 */
public class Vehicle {
    private String make;
    private String model;
    private int size;
    private int money;

    public Vehicle(String make, String model, int spots, int ownerFunds) {
        this.make = make;
        this.model = model;
        this.size = spots;
        this.money = ownerFunds;
    }
    public Vehicle(){

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {this.make = make;}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

