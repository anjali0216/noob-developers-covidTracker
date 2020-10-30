package sample;

import com.google.gson.Gson;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.advisoryapi;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Stats implements Initializable{
    public Button btn4;
    public Button btn5;
    public Button calendar;


    public Button homebtn;
    public TextArea totalcaselabel;

    totalcase objj=new totalcase();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        totalcaselabel.setText(objj.displaytotal());
    }


    public void showstate(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("statewise.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }


    public void showdistrict(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("districtwise.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    public void showCalendar(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("calendar.fxml"));
        stage.setTitle("CALENDAR");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }


    public void goBackHome(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)homebtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }


}
