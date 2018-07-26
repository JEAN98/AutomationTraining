/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import com.google.gson.Gson;
import entities.PersonRegister;
import java.io.BufferedReader;
import java.io.FileReader;
import jdk.nashorn.internal.parser.JSONParser;

/**
 *
 * @author jvega-as
 */
public class JsonHelper {
   Gson gson;
    public JsonHelper(){
        gson = new Gson();
    }
    public PersonRegister[] getData(){
        String jsonData = readFile("test//jsonFiles//" + "PersonRegister" + ".json");
        PersonRegister[] personsArray = gson.fromJson(jsonData, PersonRegister[].class);
        return personsArray;
    }
    
    private String readFile(String filePath){
         String result = "";
    try {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }
        result = sb.toString();
    } catch(Exception e) {
        e.printStackTrace();
    }
    return result;
    }
        
    
}
