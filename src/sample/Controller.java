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
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button refbtn;
    public Button shownews;
    public Button advisoriesbutton;
    public Button graphbtn;

    public void stats(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    public void symptom(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("symptom.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();


    }

    public void showsites(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("showsites.fxml"));
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


    public void viewadvisories(ActionEvent actionEvent) throws IOException {


        Stage stage = (Stage) advisoriesbutton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("advisoriespage.fxml"));
        stage.setTitle("Advisories and Guidelines");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();


    }

    public void viewhelpline(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) advisoriesbutton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("helplinepage.fxml"));
        stage.setTitle("Advisories and Guidelines");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public void showNews(ActionEvent event) throws IOException, InterruptedException {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("shownews.fxml"));
        stage.setTitle("NEWS");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    public void showgraph(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) graphbtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("allgraph.fxml"));
        stage.setTitle("GRAPHICAL ANALYSIS");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
