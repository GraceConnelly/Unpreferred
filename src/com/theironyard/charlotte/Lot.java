package com.theironyard.charlotte;

import java.util.ArrayList;

/**
 * Created by graceconnelly on 12/19/16.
 */
public class Lot {
    private String id;
    private int capacity;
    private int rate;
    private ArrayList<String> vehicles;
    private boolean full;

    public Lot(String id, int capacity, int rate, ArrayList<String> vehicles, boolean full) {
        this.id = id;
        this.capacity = capacity;
        this.rate = rate;
        this.vehicles = vehicles;
        this.full = full;
    }
    public Lot(){

    }

}