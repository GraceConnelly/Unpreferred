package com.theironyard.charlotte;

/**
 * Created by graceconnelly on 12/21/16.
 */
public class VehicleToLot {
    private String id;
    private String name;
    private int size;
    private int money;

    public VehicleToLot(String id, String name, int size, int money) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

