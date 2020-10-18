package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Controller {
    public Label label1;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public void stats(ActionEvent actionEvent)throws Exception{
        Stage stage=(Stage)btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setTitle("COVID19 STATS");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }
    public void symptom(ActionEvent actionEvent)throws Exception{
        Stage stage=(Stage)btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("symptom.fxml"));
        stage.setTitle("SYMPTOMS");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();


    }
    public void showsites(ActionEvent actionEvent)throws Exception{
        Stage stage=(Stage)btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("showsites.fxml"));
        stage.setTitle("COVID19 SITES");
        stage.setScene(new Scene(root, 600, 575));
        stage.show();

    }


}
