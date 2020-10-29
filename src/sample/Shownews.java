package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.Newsgson;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Shownews implements Initializable {
    public TextArea textnews;
    public Button hmbtn4;
    Newsgson news=new Newsgson();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            textnews.setText(news.getnews());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takehome4(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)hmbtn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
