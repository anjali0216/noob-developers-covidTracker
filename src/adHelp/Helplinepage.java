package adHelp;

//import required packages
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.driver;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class Helplinepage implements Initializable {//class implements Initializable interface
    driver obj=new driver();
    public static String inLine;
    //list of table data
    static ObservableList<Helpline> list= FXCollections.observableArrayList();
    //fxml file components
    public Button homebtn2;
    public Label cnop;
    public Label tno;
    public Label email;
    public Hyperlink linkT;
    public Hyperlink linkF;
    //json objects
    public static JSONObject jobj,jobj1,jobj2,jobj3;
    //table view
    @FXML
    TableView<Helpline> table;
    //table columns
    @FXML
    TableColumn<Helpline, Integer> sno;
    @FXML
    TableColumn<Helpline, String> loc;
    @FXML
    TableColumn<Helpline, String> cno;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //settings names of table columns
        cnop.setText(jobj3.get("number").toString());
        tno.setText(jobj3.get("number-tollfree").toString());
        email.setText(jobj3.get("email").toString());
        linkT.setText(jobj3.get("twitter").toString());
        linkF.setText(jobj3.get("facebook").toString());
        //setting on action function for links for twitter and facebook(to go to browser)
        linkT.setOnAction(obj.open(linkT));
        linkF.setOnAction(obj.open(linkF));//setting values to be mapped to table columns
        sno.setCellValueFactory(new PropertyValueFactory<Helpline, Integer>("sno"));
        loc.setCellValueFactory(new PropertyValueFactory<Helpline, String>("loc"));
        cno.setCellValueFactory(new PropertyValueFactory<Helpline, String>("cno"));
        //setting these items to table
        table.setItems(list);
    }
    //creates the list of values to be added to table cells
    public static void createList() throws ParseException {
        JSONParser parse = new JSONParser();//parsing json data
        jobj = (JSONObject) parse.parse(inLine);
        jobj1 = (JSONObject) jobj.get("data");
        jobj2 = (JSONObject) jobj1.get("contacts");
        jobj3 = (JSONObject) jobj2.get("primary");
        JSONArray arr1 = (JSONArray) jobj2.get("regional");
        int i=1;
        for (Object o : arr1){//traversing the json array and retrieving the required data
            JSONObject value = (JSONObject) o;
            //setting this data to helpline table
            Helpline hp=new Helpline(i++,value.get("loc").toString(),value.get("number").toString());
            list.add(hp);
        }
    }
    //back button takes us back to home page
    public void backhome() throws IOException {
        Stage stage=(Stage)homebtn2.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

}
