package sample;


import javafx.application.Platform;
import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


// class to update all the files
public class updateFiles extends Controller implements Runnable {
    static int check=0;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now;
    static String time;

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
                driver.getInstance().displayDialog("You are not connected to the internet! Reconnect and try again.");

            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if(time!=null)
                    s_label.setText("Last Updated At: "+time);
                    else
                        s_label.setText("You are not connected to the internet.");
                }
            });
        }
    }

    private void updateStatestats() throws IOException {
        String data="";
        int code=driver.getInstance().checkURL("https://api.rootnet.in/covid19-in/stats/latest");
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
            String path=driver.getInstance().path+"\\stateStats.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }
    private void updateDistrictstats() throws IOException {
        String data="";
        int code=driver.getInstance().checkURL("https://api.covid19india.org/v2/state_district_wise.json");
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
            String path=driver.getInstance().path+"\\districtStats.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }
    private void updateTotalStats() throws IOException {
        String data="";
        int code=driver.getInstance().checkURL("https://api.covid19india.org/data.json");
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
            String path=driver.getInstance().path+"\\totalStats.txt";
            FileWriter pw = new FileWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }
    private void updateHelpline() throws IOException {
        String data="";
        int code=driver.getInstance().checkURL("https://api.rootnet.in/covid19-in/contacts");
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
            String path=driver.getInstance().path+"\\Helpline.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }


    private void updateAdvisory() throws IOException {
        String data="";
        int code=driver.getInstance().checkURL("https://api.rootnet.in/covid19-in/notifications");
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
            String path=driver.getInstance().path+"\\advisory.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }

    private void updateWorldstats() throws IOException {
        String data="";
        int code=driver.getInstance().checkURL("https://coronavirus-19-api.herokuapp.com/countries");
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
            String path=driver.getInstance().path+"\\worldStats.txt";
            PrintWriter pw = new PrintWriter(new File(path));
            pw.write(data);
            pw.close();
        }
    }




}
