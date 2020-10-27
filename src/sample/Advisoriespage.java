package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.Newsgson;
import models.advisoryapi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Advisoriespage implements Initializable {
    public Button homebtn;
    public TextArea displayarea;

    advisoryapi ad=new advisoryapi();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            displayarea.setText(ad.getadvisory());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
