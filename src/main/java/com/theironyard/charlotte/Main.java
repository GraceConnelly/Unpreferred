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
        List<Vehicle> cloverStVehicles = Collections.synchronizedList(new ArrayList<>());
        List<Vehicle> roundAbtAveVehicles = Collections.synchronizedList(new ArrayList<>());
        List<Vehicle> squareCirVehicles =Collections.synchronizedList(new ArrayList<>());
        List<Vehicle> antAveVehicles = Collections.synchronizedList(new ArrayList<>());

        List<Lot> lots = Collections.synchronizedList(new ArrayList<>());

        String port = System.getenv("PORT");
        if (port != null) {
            Spark.port(Integer.valueOf(port));
        }

        Spark.before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });
        cloverStVehicles.add(new Vehicle("Volkswagen","Vanagon",2,60));
        //cloverStVehicles.add(new Vehicle("Volkswagen","Vanagon",2,60));


        lots.add(new Lot("Clover St.", 25,5, cloverStVehicles,false));
        lots.add(new Lot("Round-A-Bout Ave.", 25, 5, roundAbtAveVehicles, false));
        lots.add(new Lot("Square Cir.", 25, 5, squareCirVehicles, false));
        lots.add(new Lot("Ant Ave.", 25, 4, antAveVehicles, false));

        Spark.get("/lots",(request, response)->{
            System.out.println("Someone asked for all of the lot info");
            return serializer.serialize(lots);
                });
        Spark.post("/requestParking", (request, response)-> {
            System.out.println("someone wants to park in a lot somewhere, Oh Man!");

            return "";
        });

    }
}