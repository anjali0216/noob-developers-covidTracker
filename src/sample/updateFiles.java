package sample;

import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class updateFiles implements Runnable {
    driver ob=new driver();

    @Override
    public void run() {
        try {
            while (true) {
                updateStatestats();
                updateDistrictstats();
                updateTotalStats();
                updateWorldstats();
            }
        } catch (Exception e) {

        }
    }

    public void updateStatestats() throws IOException {
        String data="";
        int code=ob.checkURL("https://api.rootnet.in/covid19-in/stats/latest");
        if(code!=200){
            throw new RuntimeException();
        }
        else{
            Scanner sc=new Scanner(new URL("https://api.rootnet.in/covid19-in/stats/latest").openStream());
            StringBuilder inLine=new StringBuilder();
            while(sc.hasNext()){
                inLine.append(sc.nextLine());
            }
            data=inLine.toString();
            String path=ob.path+"\\stateStats.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }
    public void updateDistrictstats() throws IOException {
        String data="";
        int code=ob.checkURL("https://api.covid19india.org/v2/state_district_wise.json");
        if(code!=200){
            throw new RuntimeException();
        }
        else{
            Scanner sc=new Scanner(new URL("https://api.covid19india.org/v2/state_district_wise.json").openStream());
            StringBuilder inLine=new StringBuilder();
            while(sc.hasNext()){
                inLine.append(sc.nextLine());
            }
            data=inLine.toString();
            String path=ob.path+"\\districtStats.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }
    public void updateTotalStats() throws IOException {
        String data="";
        int code=ob.checkURL("https://api.covid19india.org/data.json");
        if(code!=200){
            throw new RuntimeException();
        }
        else{
            Scanner sc=new Scanner(new URL("https://api.covid19india.org/data.json").openStream());
            StringBuilder inLine=new StringBuilder();
            while(sc.hasNext()){
                inLine.append(sc.nextLine());
            }
            data=inLine.toString();
         //System.out.println(data);
            String path=ob.path+"\\totalStats.txt";
            FileWriter pw = new FileWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }



    public void updateWorldstats() throws IOException {
        String data="";
        int code=ob.checkURL("https://akashraj.tech/corona/api");
        if(code!=200){
           // System.out.println("boo");
            throw new RuntimeException("HttpResponseCode:" + code);
        }
        else{
            Scanner sc=new Scanner(new URL("https://akashraj.tech/corona/api").openStream());
            StringBuilder inLine=new StringBuilder();
            while(sc.hasNext()){
                inLine.append(sc.nextLine());
            }
            data=inLine.toString();
            //System.out.println(data);
            String path=ob.path+"\\worldStats.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }




}
