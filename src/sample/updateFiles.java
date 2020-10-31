package sample;

import com.google.gson.Gson;
import javafx.application.Platform;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class updateFiles extends Controller implements Runnable {
    driver ob=new driver();
    static int check=0;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now;
    String time;

    @Override
    public void run() {
        try {
            while (true) {
                updateStatestats();
                updateDistrictstats();
                updateTotalStats();
                updateWorldstats();
                updateHelpline();
                updateAdvisory();
                now = LocalDateTime.now();
                time=dtf.format(now);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        s_label.setText("Last Updated At: "+time);
                    }
                });

                check=0;
                Thread.sleep(60*60*1000);
            }
        } catch (Exception e) {
            if(check==1){
                ob.displayDialog("You are not connected to the internet! Reconnect and try again.");
            }
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
            String path=ob.path+"\\totalStats.txt";
            FileWriter pw = new FileWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }
    public void updateHelpline() throws IOException {
        String data="";
        int code=ob.checkURL("https://api.rootnet.in/covid19-in/contacts");
        if(code!=200){
            throw new RuntimeException();
        }
        else{
            Scanner sc=new Scanner(new URL("https://api.rootnet.in/covid19-in/contacts").openStream());
            StringBuilder inLine=new StringBuilder();
            while(sc.hasNext()){
                inLine.append(sc.nextLine());
            }
            data=inLine.toString();
            String path=ob.path+"\\Helpline.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }


    public void updateAdvisory() throws IOException {
        String data="";
        int code=ob.checkURL("https://api.rootnet.in/covid19-in/notifications");
        if(code!=200){
            throw new RuntimeException();
        }
        else{
            Scanner sc=new Scanner(new URL("https://api.rootnet.in/covid19-in/notifications").openStream());
            StringBuilder inLine=new StringBuilder();
            while(sc.hasNext()){
                inLine.append(sc.nextLine());
            }
            data=inLine.toString();
            String path=ob.path+"\\advisory.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }







    public void updateWorldstats() throws IOException {
        String data="";
        int code=ob.checkURL("https://coronavirus-19-api.herokuapp.com/countries");
        if(code!=200){
            throw new RuntimeException("HttpResponseCode:" + code);
        }
        else{
            Scanner sc=new Scanner(new URL("https://coronavirus-19-api.herokuapp.com/countries").openStream());
            StringBuilder inLine=new StringBuilder();
            while(sc.hasNext()){
                inLine.append(sc.nextLine());
            }
            data=inLine.toString();
            String path=ob.path+"\\worldStats.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }




}
