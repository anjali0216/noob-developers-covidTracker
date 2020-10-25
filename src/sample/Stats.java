package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Stats {
    public Button btn4;
    public Button btn5;
    public Button homebtn;
    public Label totalcaselabel;
   /* public void displayall() {
        totalcase totall = new totalcase();
        String totally = totall.displaytotal();
        //System.out.println(totally);
        totalcaselabel.setText(totally);
    }*/



    public void showstate(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("statewise.fxml"));
        stage.setTitle("STATE DATA");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    public void showdistrict(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("districtwise.fxml"));
        stage.setTitle("DISTRICT DATA");
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
