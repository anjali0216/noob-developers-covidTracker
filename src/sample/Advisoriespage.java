package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;

import models.advisoryapi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;



public class Advisoriespage implements Initializable {
    driver obj=new driver();
    public Button homebtn;


    advisoryapi ad=new advisoryapi();
    @FXML
    TableView<Advisory> table;
    @FXML
    TableColumn<Advisory,Integer> sno;
    @FXML
    TableColumn<Advisory,String> title;
    @FXML
    TableColumn<Advisory,Hyperlink> link;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       sno.setCellValueFactory(new PropertyValueFactory<Advisory, Integer>("sno"));
        title.setCellValueFactory(new PropertyValueFactory<Advisory, String>("title"));
        link.setCellValueFactory(new PropertyValueFactory<Advisory, Hyperlink>("link"));
        table.setItems(addlist());
        
    }

    public ObservableList<Advisory> addlist() {
        ObservableList<Advisory> list= FXCollections.observableArrayList();
        String inLine = null;
        try {
            inLine = obj.JsonToString(obj.path + "\\advisory.txt");


        JSONParser parse = new JSONParser();

        JSONObject jobj = (JSONObject) parse.parse(inLine);

        JSONObject jobj1 = (JSONObject) jobj.get("data");
        JSONArray arr1 = (JSONArray) jobj1.get("notifications");
        int i;

        for (i = 0; i < arr1.size(); i++) {
            Hyperlink add=new Hyperlink();
            JSONObject jsonobj = (JSONObject) arr1.get(i);
            add.setText(jsonobj.get("link").toString());
            add.setOnAction(obj.open(add));
            Advisory ad=new Advisory(i+1,(String)jsonobj.get("title"),add);

            list.add(ad);
        }
        } catch (FileNotFoundException | ParseException e) {
            obj.displayDialog("Something went wrong. Refresh, and try again!");
        }
        return list;
    }


    public void takemehome(ActionEvent actionEvent) throws IOException {

        Stage stage=(Stage)homebtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
















}
