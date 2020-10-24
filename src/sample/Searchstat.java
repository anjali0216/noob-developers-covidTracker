package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Searchstat {
    driver ob=new driver();
    public String searchst(String state){
        String stats="";
        boolean found=false;
        File file=new File(ob.path+"\\stateStats.txt");
        try {
            Scanner sc=new Scanner(file);
            String inLine;
            StringBuilder data=new StringBuilder();
            while(sc.hasNext()){
                data.append(sc.nextLine());
            }
            inLine= data.toString();

            var gson = new Gson();

            stateRoot root = gson.fromJson(inLine, stateRoot.class);
            for (int i = 0; i < root.data.regional.size(); i++) {
                if (root.data.regional.get(i).loc.equalsIgnoreCase(state)) {
                    found=true;
                    int confTotal = root.data.regional.get(i).totalConfirmed;
                    int confIndian = root.data.regional.get(i).confirmedCasesIndian;
                    int confForeign = root.data.regional.get(i).confirmedCasesForeign;
                    int recovered = root.data.regional.get(i).discharged;
                    int deaths = root.data.regional.get(i).deaths;
                    stats="Location: "+state+"\nConfirmed Cases(Indian): "+confIndian+"\nnConfirmed Cases(Foreign): "+confForeign+"\n" +
                            "Total Confirmed: "+confTotal+"\nRecovered: "+recovered+"\nDeaths: "+deaths;
                    break;
                }
            }
            if(found==false){
                stats="No such record found!";
            }

        } catch (FileNotFoundException e) {
            ob.displayDialog("Something went wrong. Refresh, and try again!");
        }
        return stats;
    }

    public String searchdt(String state,String district){
        String stats="";
        boolean found=false;
        File file=new File(ob.path+"\\districtStats.txt");
        try{
            Scanner sc=new Scanner(file);
            String inLine;
            StringBuilder data=new StringBuilder();
            while(sc.hasNext()){
                data.append(sc.nextLine());
            }
            inLine= data.toString();
            JSONParser parse = new JSONParser();
            JSONArray jsonarr1 = (JSONArray) parse.parse(inLine);
            for (Object o : jsonarr1) {
                JSONObject jobj1 = (JSONObject) o;
                JSONArray jsonarr2 = (JSONArray) jobj1.get("districtData");
                for (Object value : jsonarr2) {

                    if (((String) jobj1.get("state")).equalsIgnoreCase(state)) {
                        JSONObject jobj2 = (JSONObject) value;
                        if (((String) jobj2.get("district")).equalsIgnoreCase(district)) {
                            found=true;
                            stats="Confirmed: " + jobj2.get("confirmed") + "\nActive: " + jobj2.get("active") + "\ndeceased: " + jobj2.get("deceased") + "\nrecovered: " + jobj2.get("recovered");
                        }
                    }

                }
                if(found==false) {
                    stats="No such record found!";
                }
            }

        }catch(Exception e){
            stats=null;
            ob.displayDialog("Something went wrong. Refresh, and try again!");
        }
        return stats;
    }
}
