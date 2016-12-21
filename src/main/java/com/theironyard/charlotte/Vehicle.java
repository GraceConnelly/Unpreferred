package com.theironyard.charlotte;

/**
 * Created by graceconnelly on 12/19/16.
 */
public class Vehicle {
    private String name;
    private int size;
    private int money;

    public Vehicle(String name, int size, int money) {
        this.name = name;
        this.size = size;
        this.money = money;
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