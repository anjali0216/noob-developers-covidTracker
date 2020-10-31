package models;

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
        URL url = new URL("https://api.rootnet.in/covid19-in/notifications");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {
            con.setRequestMethod("GET");
            con.connect();
            int responsecode = con.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode:" + responsecode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    line += sc.nextLine();
                }
                sc.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONParser parse = new JSONParser();
        try {
            JSONObject jobj = (JSONObject) parse.parse(line);

            JSONObject jobj1 = (JSONObject) jobj.get("data");
            JSONArray arr1 = (JSONArray) jobj1.get("notifications");
            for (int i = 0; i < arr1.size(); i++) {
                JSONObject jsonobj = (JSONObject) arr1.get(i);
                advisory +="\ntitle: " + jsonobj.get("title") +"\n"+"link: " + jsonobj.get("link")+"\n";

                con.disconnect();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return advisory;
    }
    }

