package com.example.se_backend.Controller;

import com.example.se_backend.model.Locatie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@RestController
@RequestMapping("/locatie")
public class LocatieController {
    @PostMapping("/add")
    public ResponseEntity<String> addLocatie(@RequestBody Locatie locatie) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("D:\\SE\\se_backend\\locatie.json"), locatie);
            return new ResponseEntity<>("Locatie added successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error writing to file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getNumeDestinatie")
    public ResponseEntity<String> getLocatie() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("locatie.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject locatieObj = (JSONObject) obj;
            String numeDestinatie = (String) locatieObj.get("numeDestinatie");
            return new ResponseEntity<>(numeDestinatie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error writing to file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
