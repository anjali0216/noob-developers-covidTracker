package sample;

import com.google.gson.Gson;

import javax.swing.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Searchstat {
    public Regional searchSt(String state){
        Regional obj=null;
        try {
            var url = "https://api.rootnet.in/covid19-in/stats/latest";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String s = response.body();

            var gson = new Gson();

            stateRoot root = gson.fromJson(s, stateRoot.class);

            for (int i = 0; i < root.data.regional.size(); i++) {
                if (root.data.regional.get(i).loc.equalsIgnoreCase(state)) {
                    int confTotal = root.data.regional.get(i).totalConfirmed;
                    int confIndian = root.data.regional.get(i).confirmedCasesIndian;
                    int confForeign = root.data.regional.get(i).confirmedCasesForeign;
                    int recovered = root.data.regional.get(i).discharged;
                    int deaths = root.data.regional.get(i).deaths;
                    obj=new Regional(state,confForeign,confIndian,recovered,deaths,confTotal);
                }
            }
        } catch (Exception e) {
            obj=new Regional("",0,0,0,0,0);
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,"You are not connected to the internet!");
        }
        return obj;
        }
    }
