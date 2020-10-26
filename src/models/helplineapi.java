package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class helplineapi {
    public String gethelpline() throws IOException {
        String line = "";
        String finalhelpline="";
        URL url = new URL("https://api.rootnet.in/covid19-in/contacts");
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
            JSONObject jobj2 = (JSONObject) jobj1.get("contacts");
            JSONObject jobj3 = (JSONObject) jobj2.get("primary");
            finalhelpline+="COVID-19 NATIONAL HELPLINES: \n\n"+"number:" + jobj3.get("number")+"\nnumber-tollfree:" + jobj3.get("number-tollfree")+"\nemail:" + jobj3.get("email")+"\n";

            JSONArray arr1 = (JSONArray) jobj2.get("regional");
            finalhelpline+="\nThe Statewise helpline numbers are: \n";

            for (int i = 0; i < arr1.size(); i++) {
                JSONObject jsonobj1 = (JSONObject) arr1.get(i);
                finalhelpline+="\nloc:" + jsonobj1.get("loc") +"\nnumber:" + jsonobj1.get("number")+"\n";


            }
            con.disconnect();
        } catch (ParseException e) {
            e.printStackTrace();
        }
 return  finalhelpline;

    }
}
