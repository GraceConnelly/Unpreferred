package com.theironyard.charlotte;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
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

        lots.add(new Lot("Clover Street", 25, 5,new ArrayList<String> ()));

        Spark.get("/lots",(request, response)->{
            System.out.println("Someone asked for all of the lot info");
            return serializer.serialize(lots);
                });
        Spark.post("/requestParking", (request, response)->{
            System.out.println("someone wants to park in a lot somewhere, Oh Man!");

                }
        );

    }
}
