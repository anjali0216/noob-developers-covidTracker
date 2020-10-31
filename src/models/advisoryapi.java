package models;

//importing required packages
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.Scanner;

public class advisoryapi {

    public String getadvisory() throws IOException {
        String line = "";
        String advisory="";
        //calling the api for advisories
        URL url = new URL("https://api.rootnet.in/covid19-in/notifications");
        //establishing a connection
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {
            //setting the request and request method as GET
            con.setRequestMethod("GET");
            //opening the connection
            con.connect();
            int responsecode = con.getResponseCode();
            if (responsecode != 200) {//if responsecode 200...connection successful
                throw new RuntimeException("HttpResponseCode:" + responsecode);//throw exception
            } else {
                Scanner sc = new Scanner(url.openStream());//reading data from url through Scanner class
                while (sc.hasNext()) {
                    line += sc.nextLine();//adding this data to string line
                }
                sc.close();//closing file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //JSONParser object for parsing data in json form
        JSONParser parse = new JSONParser();
        try {
            JSONObject jobj = (JSONObject) parse.parse(line);
//taking required data from the json form
            JSONObject jobj1 = (JSONObject) jobj.get("data");
            JSONArray arr1 = (JSONArray) jobj1.get("notifications");
            for (int i = 0; i < arr1.size(); i++) {
                JSONObject jsonobj = (JSONObject) arr1.get(i);
                //adding the data (title of advisory and its link) to string advisory that is to be returned
                advisory +="\ntitle: " + jsonobj.get("title") +"\n"+"link: " + jsonobj.get("link")+"\n";

                con.disconnect();//closing connection
            }
        } catch (ParseException e) {//exception handling
            e.printStackTrace();
        }

        return advisory;//return string
    }//method end
}//class end

