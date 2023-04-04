package com.example.se_backend.Controller;

import com.example.se_backend.model.Locatie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/locatie")
public class LocatieController {
    @PostMapping("/add")
    public ResponseEntity<String> addLocatie(@RequestBody Locatie locatie) {
        try {
            JSONObject locUserData = new JSONObject();
            locUserData.put("scop", locatie.getScop());
            locUserData.put("perioada", locatie.getPerioada());
            locUserData.put("climat", locatie.getClimat());
            locUserData.put("zona", locatie.getZona());
            locUserData.put("nrPersoane", locatie.getNrPersoane());
            locUserData.put("activitati", locatie.getActivitati());
            locUserData.put("obiectiveTuristice", locatie.getobiectiveTuristice());
            locUserData.put("cazare", locatie.getCazare());
            locUserData.put("buget", locatie.getBuget());
            locUserData.put("numeDestinatie", locatie.getNumeDestinatie());

            try (FileWriter file = new FileWriter("locatie.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(locUserData.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }

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
            return new ResponseEntity<>((String) locatieObj.get("numeDestinatie"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/postNumeDestinatie")
    public ResponseEntity<String> postNumeDestinatie() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        Locatie locatieUser = null;

        //Generating the Locatie object from the user
        try (FileReader reader = new FileReader("locatie.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject locatieObj = (JSONObject) obj;

            locatieUser = new Locatie(
                    (String) locatieObj.get("scop"),
                    (long) locatieObj.get("perioada"),
                    (String) locatieObj.get("climat"),
                    (String) locatieObj.get("zona"),
                    (String) locatieObj.get("nrPersoane"),
                    (String) locatieObj.get("activitati"),
                    (long) locatieObj.get("obiectiveTuristice"),
                    (String) locatieObj.get("cazare"),
                    (long) locatieObj.get("buget"),
                    (String) locatieObj.get("numeDestinatie")
            );
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("Turismo.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray locatieList = (JSONArray) obj;

            //Iterate over location array
            Locatie finalLocatieUser = locatieUser;
            locatieList.forEach(loc -> parseLocationObject((JSONObject) loc, Objects.requireNonNull(finalLocatieUser)));

            JSONObject locUserData = new JSONObject();
            locUserData.put("scop", locatieUser.getScop());
            locUserData.put("perioada", locatieUser.getPerioada());
            locUserData.put("climat", locatieUser.getClimat());
            locUserData.put("zona", locatieUser.getZona());
            locUserData.put("nrPersoane", locatieUser.getNrPersoane());
            locUserData.put("activitati", locatieUser.getActivitati());
            locUserData.put("obiectiveTuristice", locatieUser.getobiectiveTuristice());
            locUserData.put("cazare", locatieUser.getCazare());
            locUserData.put("buget", locatieUser.getBuget());
            locUserData.put("numeDestinatie", locatieUser.getNumeDestinatie());

            try (FileWriter file = new FileWriter("locatie.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(locUserData.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new ResponseEntity<>(Objects.requireNonNull(locatieUser).getNumeDestinatie(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static void parseLocationObject(JSONObject locatie, Locatie locatieUser) {
        //Get location object within list
        JSONObject locatieObject = (JSONObject) locatie.get("locatie");

        String scop = (String) locatieObject.get("scop");
        long perioada = (long) locatieObject.get("perioada");
        String climat = (String) locatieObject.get("climat");
        String zona = (String) locatieObject.get("zona");
        String nrPersoane = (String) locatieObject.get("nrPersoane");
        String activitati = (String) locatieObject.get("activitati");
        long obiectiveTuristice = (long) locatieObject.get("obiectiveTuristice");
        String cazare = (String) locatieObject.get("cazare");
        long buget = (long) locatieObject.get("buget");
        String numeDestinatie = (String) locatieObject.get("numeDestinatie");

        if(Objects.equals(locatieUser.getScop(), scop)){
            if(locatieUser.getPerioada() == perioada){
                if(Objects.equals(locatieUser.getClimat(), climat)){
                    if(Objects.equals(locatieUser.getZona(), zona)){
                        if(Objects.equals(locatieUser.getNrPersoane(), nrPersoane)){
                            if(Objects.equals(locatieUser.getActivitati(), activitati)){
                                if(locatieUser.getobiectiveTuristice() == obiectiveTuristice){
                                    if(Objects.equals(locatieUser.getCazare(), cazare)){
                                        if(locatieUser.getBuget() <= buget){
                                            locatieUser.setNumeDestinatie(numeDestinatie);
                                        }
                                        else {
                                            System.out.println("Nu exista acest buget printre variante!!!");
                                        }
                                    }
                                    else {
                                        System.out.println("Nu exista aceasta optiune de cazare printre variante!!!");
                                    }
                                }
                                else {
                                    System.out.println("Nu exista acest numar de obiective turistice printre variante!!!");
                                }
                            }
                            else {
                                System.out.println("Nu exista aceste activitati printre variante!!!");
                            }
                        }
                        else {
                            System.out.println("Nu exista acest numar de persoane printre variante!!!");
                        }
                    }
                    else {
                        System.out.println("Nu exista aceasta zona printre variante!!!");
                    }
                }
                else {
                    System.out.println("Nu exista acest climat printre variante!!!");
                }
            }
            else {
                System.out.println("Nu exista aceasta perioada printre variante!!!");
            }
        }
        else {
            System.out.println("Nu exista acest scop printre variante!!!");
        }
    }
}
