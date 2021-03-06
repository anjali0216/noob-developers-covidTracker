package statFiles;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sample.driver;

import java.io.FileNotFoundException;


public class Searchstat {
    //creating a function to search for a particular state
     String searchst(String state){
        String stats="";
        boolean found=false;
        try {
            String inLine=driver.getInstance().JsonToString(driver.getInstance().path+"\\stateStats.txt");
            var gson = new Gson();//object of gson class to convert json data to java object form

            stateRoot root = gson.fromJson(inLine, stateRoot.class);

            for (int i = 0; i < root.data.regional.size(); i++) {
                if (root.data.regional.get(i).loc.equalsIgnoreCase(state)) {
                    found=true;
                    int confTotal = root.data.regional.get(i).totalConfirmed;
                    int confIndian = root.data.regional.get(i).confirmedCasesIndian;
                    int confForeign = root.data.regional.get(i).confirmedCasesForeign;
                    int recovered = root.data.regional.get(i).discharged;
                    int deaths = root.data.regional.get(i).deaths;
                    stats="Location: "+state+"\nConfirmed Cases(Indian): "+confIndian+"\nConfirmed Cases(Foreign): "+confForeign+"\n" +
                            "Total Confirmed: "+confTotal+"\nRecovered: "+recovered+"\nDeaths: "+deaths;
                    break;
                }
            }
            if(found==false){
                stats="No such record found!";
            }

        } catch (FileNotFoundException e) {
            driver.getInstance().displayDialog("Something went wrong. Refresh, and try again!");
        }
        return stats;
    }

    //function to search for a particular district in a particular state
     String searchdt(String state,String district){
        String stats="";
        boolean found=false;
        try{
            String inLine=driver.getInstance().JsonToString(driver.getInstance().path+"\\districtStats.txt");
            JSONParser parse = new JSONParser();//parsing the json data
            JSONArray jsonarr1 = (JSONArray) parse.parse(inLine);
            for (Object o : jsonarr1) {
                JSONObject jobj1 = (JSONObject) o;
                if (((String) jobj1.get("state")).equalsIgnoreCase(state)) {
                JSONArray jsonarr2 = (JSONArray) jobj1.get("districtData");
                for (Object value : jsonarr2) {
                    JSONObject jobj2 = (JSONObject) value;//checking if record found
                        if (((String) jobj2.get("district")).equalsIgnoreCase(district)) {
                            found=true;
                            stats="Confirmed: " + jobj2.get("confirmed") + "\nActive: " + jobj2.get("active") + "\ndeceased: " + jobj2.get("deceased") + "\nrecovered: " + jobj2.get("recovered");
                            break;
                        }
                    }
                    if(found==true)
                        break;
                }
                if(found==false) {
                    stats="No such record found!";
                }
            }

        }catch(Exception e){//exception handling
            stats=null;
            driver.getInstance().displayDialog("Something went wrong. Refresh, and try again!");
        }
        return stats;
    }
}
