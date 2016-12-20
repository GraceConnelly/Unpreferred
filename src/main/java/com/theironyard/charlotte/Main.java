package com.theironyard.charlotte;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import spark.Spark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static JsonParser parser = new JsonParser();
    private static JsonSerializer serializer = new JsonSerializer();

    public static void main(String[] args) {
        List<Lot> lots = Collections.synchronizedList(new ArrayList<>());

        String port = System.getenv("PORT");
        if (port != null) {
            Spark.port(Integer.valueOf(port));
        }

        Spark.before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });

        lots.add(new Lot("Clover St.", 25, 5, 4, false));
        lots.add(new Lot("Round-A-Bout Ave.", 25, 5, 4, false));
        lots.add(new Lot("Square Cir.", 25, 5, 4, false));
        lots.add(new Lot("Ant Ave.", 25, 5, 4, false));

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