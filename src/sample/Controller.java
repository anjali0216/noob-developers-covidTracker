package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Controller {
    driver object = new driver();
    public Label label1;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button refbtn;
    public Button shownews;
    public Button advisoriesbutton;

    public void stats(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setTitle("COVID19 STATS");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    public void symptom(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("symptom.fxml"));
        stage.setTitle("SYMPTOMS");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();


    }

    public void showsites(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("showsites.fxml"));
        stage.setTitle("COVID19 SITES");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    public void Refresh(ActionEvent actionEvent) {
        updateFiles ob = new updateFiles();
        try {
            ob.updateStatestats();
            ob.updateDistrictstats();
        } catch (Exception e) {
            object.displayDialog("You are not connected to the internet! Reconnect and try again.");
        }
    }

    //view advisories is the on action for the view advisories button in sample.fxml
    public void viewadvisories(ActionEvent actionEvent) throws IOException {


        Stage stage = (Stage) advisoriesbutton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("advisoriespage.fxml"));
        stage.setTitle("Advisories and Guidelines");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

       /* String line = "";
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
            //System.out.println("success: " +jobj.get("success"));
            //System.out.println("data: " +jobj.get("data"));
            JSONObject jobj1 = (JSONObject) jobj.get("data");
            JSONArray arr1 = (JSONArray) jobj1.get("notifications");
            for (int i = 0; i < arr1.size(); i++) { //is line pe keh ra h ki arr1 could be null but yaha exception handle krne ka msg hi nhi aa rha
                JSONObject jsonobj = (JSONObject) arr1.get(i);
                advisory +="title: " + jsonobj.get("title") +"\n"+"link: " + jsonobj.get("link")+"\n";
                //System.out.println("title:" + jsonobj.get("title"));
                //System.out.println("link:" + jsonobj.get("link"));
                //System.out.println("\n");
                con.disconnect();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

 return advisory;*/
    }

    public void viewhelpline(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) advisoriesbutton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("helplinepage.fxml"));
        stage.setTitle("Advisories and Guidelines");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

        String line = "";
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
            //System.out.println("success: " +jobj.get("success"));
            //System.out.println("data: " +jobj.get("data"));
            JSONObject jobj1 = (JSONObject) jobj.get("data");
            JSONObject jobj2 = (JSONObject) jobj1.get("contacts");
            JSONObject jobj3 = (JSONObject) jobj2.get("primary");
            System.out.println("number:" + jobj3.get("number"));
            System.out.println("number-tollfree:" + jobj3.get("number-tollfree"));
            System.out.println("email:" + jobj3.get("email"));
            System.out.println("twitter:" + jobj3.get("twitter"));
            System.out.println("facebook:" + jobj3.get("facebook"));
            System.out.println("\n");
            // JSONArray arr0 = (JSONArray) jobj3.get("media");
            //for (int i = 0; i < arr0.size(); i++) {
            // JSONObject jsonobj = (JSONObject) arr0.get(i);
            // System.out.println("media:" + jsonobj.get("media"));
            // }
            JSONArray arr1 = (JSONArray) jobj2.get("regional");
            System.out.println("The Statewise helpline numbers are: ");

            for (int i = 0; i < arr1.size(); i++) {
                JSONObject jsonobj1 = (JSONObject) arr1.get(i);
                System.out.println("loc:" + jsonobj1.get("loc"));
                System.out.println("number:" + jsonobj1.get("number"));
                System.out.println("\n");

            }
            con.disconnect();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public void showNews(ActionEvent event) throws IOException, InterruptedException {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("shownews.fxml"));
        stage.setTitle("NEWS");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }
}
