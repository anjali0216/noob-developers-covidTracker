package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Stats {
    public Button btn4;
    public Button btn5;
    public Button homebtn;
    public Button dnldbtn;

    public void showstate(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("statewise.fxml"));
        stage.setTitle("STATE DATA");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();

    }

    public void showdistrict(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("districtwise.fxml"));
        stage.setTitle("Districtdata");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }

    public void goBackHome(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)homebtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }

    public void downloadStats(ActionEvent actionEvent) {
        Thread t=new Thread(new downloadFiles());
        t.start();
    }
}
