package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.advisoryapi;
import models.helplineapi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Helplinepage implements Initializable {
    public Button homebtn2;
  public TextArea helplinearea;

    helplineapi ad=new helplineapi();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            helplinearea.setText(ad.gethelpline());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public void backhome(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)homebtn2.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

}
