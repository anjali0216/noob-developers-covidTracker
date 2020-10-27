package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.sql.Driver;
import java.time.LocalDate;
import java.util.Scanner;

public class Calendar {
    driver ob=new driver();
    public Label date;
    public DatePicker picker;
    public Button showdate;

    public void displaydate(ActionEvent actionEvent)
    {

        LocalDate localDate=picker.getValue();
        String str1=localDate.toString();
        String res="covid was not there";
        String stats="";
        boolean found=false;
        File file=new File(ob.path+"\\totalStats.txt");
        try{
            Scanner sc=new Scanner(file);
            String inLine;
            StringBuilder data=new StringBuilder();
            while(sc.hasNext()){
                data.append(sc.nextLine());
            }
            inLine= data.toString();
            JSONParser parse = new JSONParser();
            JSONObject jobj = (JSONObject) parse.parse(inLine);
            JSONArray jsonarr1=(JSONArray) jobj.get("cases_time_series");
            for (Object o : jsonarr1) {
                JSONObject jobj1 = (JSONObject) o;
                String str2=(String)jobj1.get("dateymd");
                if(str2.equals(str1))
                {
                    res=("Daily Confirmed : "+(String)jobj1.get("dailyconfirmed")+"\n"+"Daily Deceased : "+(String)jobj1.get("dailydeceased")+"\n"+"Daily Recovered : "+(String)jobj1.get("dailyrecovered")+"\n"+"Total Confirmed : "+(String)jobj1.get("totalconfirmed")+"\n"+"Total Deceased : "+(String)jobj1.get("totaldeceased")+"\n"+"Total Recovered : "+(String)jobj1.get("totalrecovered")+"\n");
                }

            }
            date.setText(res);

        }catch(Exception e){
            stats=null;
            ob.displayDialog("Something went wrong. Refresh, and try again!");
        }
    }
}
