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
import models.Newsgson;
import models.advisoryapi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


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
        try {
            table.setItems(addlist());
        } catch (FileNotFoundException e) {
            //System.out.println("welcome");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*try {
            displayarea.setText(ad.getadvisory());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    public ObservableList<Advisory> addlist() throws FileNotFoundException, ParseException {
        ObservableList<Advisory> list= FXCollections.observableArrayList();
        String inLine = obj.JsonToString(obj.path + "\\advisory.txt");

        JSONParser parse = new JSONParser();

        JSONObject jobj = (JSONObject) parse.parse(inLine);

        JSONObject jobj1 = (JSONObject) jobj.get("data");
        JSONArray arr1 = (JSONArray) jobj1.get("notifications");
        int i;
        for (i = 0; i < arr1.size(); i++) {


            JSONObject jsonobj = (JSONObject) arr1.get(i);

            Advisory ad=new Advisory(i+1,(String)jsonobj.get("title"),(Hyperlink)jsonobj.get("link"));

            list.add(ad);
        }
        return list;
    }


    public void takemehome(ActionEvent actionEvent) throws IOException {

        Stage stage=(Stage)homebtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }














    /*
    String line="";

    URL url;

    {
        try {
            url = new URL("https://api.rootnet.in/covid19-in/notifications");
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
    }

    

    {
        HttpURLConnection  con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try {
            con.setRequestMethod("GET");
        } catch (ProtocolException protocolException) {
            protocolException.printStackTrace();
        }
        try {
            con.connect();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        int responsecode = 0;
        try {
            responsecode = con.getResponseCode();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode:" + responsecode);
        } else {
            Scanner sc = null;
            try {
                sc = new Scanner(url.openStream());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            while (sc.hasNext()) {
                line += sc.nextLine();
            }
            sc.close();
        }
        JSONParser parse = new JSONParser();

        JSONObject jobj = null;
        try {
            jobj = (JSONObject) parse.parse(line);
        } catch (ParseException parseException) {
            parseException.printStackTrace();

        }
        //System.out.println("success: " +jobj.get("success"));
        //System.out.println("data: " +jobj.get("data"));
        JSONObject jobj1 = (JSONObject) jobj.get("data");
        JSONArray arr1 = (JSONArray) jobj1.get("notifications");
        for (int i = 0; i < arr1.size(); i++) {
            JSONObject jsonobj = (JSONObject) arr1.get(i);
            displayarea.appendText("\n" + "title:" + jsonobj.get("title") + "\n" + "link:" + jsonobj.get("link") + "\n");
            // System.out.println("title:" +jsonobj.get("title"));
            //System.out.println("link:" +jsonobj.get("link"));
            //System.out.println("\n");

        }

        con.disconnect();

    }
*/

}
