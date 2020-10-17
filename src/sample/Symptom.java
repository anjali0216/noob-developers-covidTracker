package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class Symptom {
    public TextArea textArea2;
    public Button btn8;

    public void quiz(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn8.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
        stage.setTitle("QUIZ");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();

    }
}
