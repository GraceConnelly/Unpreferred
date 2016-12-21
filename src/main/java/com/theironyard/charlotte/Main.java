package com.theironyard.charlotte;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import spark.Spark;

import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static JsonParser parser = new JsonParser();
    private static JsonSerializer serializer = new JsonSerializer();

    public static void main(String[] args) {
        //initallizes arrays for vehicles and lots
        List<Vehicle> cloverStVehicles = new ArrayList<>();
        List<Vehicle> roundAbtAveVehicles = new ArrayList<>();
        List<Vehicle> squareCirVehicles =new ArrayList<>();
        List<Vehicle> antAveVehicles = new ArrayList<>();

        List<Lot> lots = new ArrayList<>();

        String port = System.getenv("PORT");
        if (port != null) {
            Spark.port(Integer.valueOf(port));
        }

        Spark.before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });
        cloverStVehicles.add(new Vehicle("Volkswagen Vanagon",2,60));
        //cloverStVehicles.add(new Vehicle("Volkswagen","Vanagon",2,60));

        lots.add(new Lot("Clover St.", 25,25, cloverStVehicles,false));
        lots.add(new Lot("Round-A-Bout Ave.", 25, 65, roundAbtAveVehicles, false));
        lots.add(new Lot("Square Cir.", 25, 28, squareCirVehicles, false));
        lots.add(new Lot("Ant Ave.", 25, 13, antAveVehicles, false));

        Spark.get("/lots",(request, response)->{
            System.out.println("Someone asked for all of the lot info");
            return serializer.deep(true).serialize(lots);
                });
        Spark.post("/requestParking", (request, response)-> {
            System.out.println("someone wants to park in a lot somewhere, Oh Man!");
            //get the requested vehicle that the person would like to park and return whether or not they are allowed to park there
            VehicleToLot reqstVehicle = parser.parse(request.body(), VehicleToLot.class);
            for (Lot lot : lots) {
                if (lot.getId() == reqstVehicle.getId()) {
                    if (reqstVehicle.getSize() * lot.getRate() <= reqstVehicle.getMoney()
                            && reqstVehicle.getSize() < lot.getCapacity() - lot.getVehicles().size()){
                        lot.getVehicles().add(new Vehicle(reqstVehicle.getName(),reqstVehicle.getSize(),reqstVehicle.getMoney()));
                    }
                }
            }
            return "";
        });
    }
}