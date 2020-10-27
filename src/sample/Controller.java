package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import others.Helplinepage;
import others.Shownews;
import java.io.IOException;

public class Controller {
    driver object = new driver();
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button refbtn;
    public Button shownews;
    public Button advisoriesbutton;

    public void stats() throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    public void symptom() throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("symptom.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();


    }

    public void showsites() throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("showsites.fxml"));
        stage.setScene(new Scene(root, 500, 400));
        stage.show();

    }

    public void Refresh() {
        updateFiles ob = new updateFiles();
        try {
            ob.updateStatestats();
            ob.updateDistrictstats();
        } catch (Exception e) {
            object.displayDialog("You are not connected to the internet! Reconnect and try again.");
        }
    }


    public void viewadvisories() throws IOException {


        Stage stage = (Stage) advisoriesbutton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("advisoriespage.fxml"));
        stage.setTitle("Advisories and Guidelines");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();


    }

    public void viewhelpline() {
        try {
            Helplinepage.inLine=object.JsonToString(object.path + "\\Helpline.txt");
            Helplinepage.createList();
            Stage stage = (Stage) advisoriesbutton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("helplinepage.fxml"));
            stage.setScene(new Scene(root, 500, 500));
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showNews() {
        try {
            Shownews.inLine=new Shownews().getnews();
            Stage stage = (Stage) btn1.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("shownews.fxml"));
            stage.setScene(new Scene(root, 500, 500));
            stage.show();
        }catch(Exception e){
            object.displayDialog("You are not connected to the internet! Reconnect and try again.");
        }

    }
}
