package statFiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sample.driver;

import java.io.IOException;
import java.time.LocalDate;


public class Calendar {
    public Label date;
    public DatePicker picker;
    public Button showdate;
    public Button prev;

    /*
    Function for picking the data from Calendar and matching this date
    with date from totalstats.txt and showing corresponding data
    according to it.
     */
    public void displaydate(ActionEvent actionEvent)
    {
        LocalDate localDate=picker.getValue();
        String str1=localDate.toString();
        String res="";
        boolean found=false;
        try{
            String inLine= driver.getInstance().JsonToString(driver.getInstance().path+"\\totalStats.txt");
            JSONParser parse = new JSONParser();                                       //using JSON parsing to get date from json string.
            JSONObject jobj = (JSONObject) parse.parse(inLine);
            JSONArray jsonarr1=(JSONArray) jobj.get("cases_time_series");
            for (Object o : jsonarr1) {
                JSONObject jobj1 = (JSONObject) o;
                String str2=(String)jobj1.get("dateymd");
                if(str2.equals(str1))
                {
                    found=true;
                    res=("Daily Confirmed : "+(String)jobj1.get("dailyconfirmed")+"\n"+"Daily Deceased : "+(String)jobj1.get("dailydeceased")+"\n"+"Daily Recovered : "+(String)jobj1.get("dailyrecovered")+"\n"+"Total Confirmed : "+(String)jobj1.get("totalconfirmed")+"\n"+"Total Deceased : "+(String)jobj1.get("totaldeceased")+"\n"+"Total Recovered : "+(String)jobj1.get("totalrecovered")+"\n");
                }

            }
            if(found==false){
                driver.getInstance().displayDialog("Please, choose an appropriate date!");
                return;
            }
            date.setText(res);
        }catch(Exception e){
            driver.getInstance().displayDialog("Something went wrong. Refresh and try again.");
        }
    }

    public void prevPg(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)prev.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
