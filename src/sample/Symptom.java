package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Symptom implements Initializable {
    public TextArea textArea2;
    public Button btn8;



    public void quiz(ActionEvent actionEvent) throws IOException {       //loading quiz screen
        Stage stage=(Stage)btn8.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
        stage.setTitle("QUIZ");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea2.setEditable(false);
    }
}
