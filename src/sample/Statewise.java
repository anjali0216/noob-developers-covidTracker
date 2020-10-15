package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Statewise {
    public Button btn6;
    public Button btn7;

    public void statewise(ActionEvent actionEvent){

    }
    public void searchstate(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn6.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("searchstat.fxml"));
        stage.setTitle("Searchstate");
        stage.setScene(new Scene(root, 300, 275));
        stage.show(); }

}
