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

public class totalcase{
    driver obj=new driver();

    public String displaytotal(){
        String stats="";
        boolean found=false;
        File file=new File(obj.path+"\\stateStats.txt");
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
           /* for (int i = 0; i < root.data.regional.size(); i++) {
                if (root.data.regional.get(i).loc.equalsIgnoreCase(state)) {
                    found=true;*/
                    int confTotal1 = root.data.summary.total;
                    int confIndian1 = root.data.summary.confirmedCasesIndian;
                    int confForeign1 = root.data.summary.confirmedCasesForeign;
                    int recovered1 = root.data.summary.discharged;
                    int deaths1 = root.data.summary.deaths;
                 int confUnidentified1 = root.data.summary.confirmedButLocationunidentified;
                    stats="\nTotal Confirmed: "+confTotal1+"\n"+"Confirmed Cases(Indian): "+confIndian1+"\n"+"Confirmed Cases(Foreign): "+confForeign1+"\n" +
                            "Recovered: "+recovered1+"\nDeaths: "+deaths1+"\nConfirmedButLocationUnidentified: "+confUnidentified1 ;





        } catch (FileNotFoundException e) {
            obj.displayDialog("Something went wrong. Refresh, and try again!");
        }
        return stats;
    }


}
