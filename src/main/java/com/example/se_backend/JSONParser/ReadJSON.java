package com.example.se_backend.JSONParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJSON {
    public static void main(String[] args) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("Turismo.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray locatieList = (JSONArray) obj;
            System.out.println(locatieList);

            //Iterate over location array
            locatieList.forEach(loc -> parseLocationObject((JSONObject) loc));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void parseLocationObject(JSONObject locatie) {
        //Get location object within list
        JSONObject locatieObject = (JSONObject) locatie.get("locatie");

        String numeDestinatie = (String) locatieObject.get("numeDestinatie");
        System.out.println(numeDestinatie);
    }
}