package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class  Districtwise {
    public TextField stateds;
    public TextField district;
    public Button search;
    public Label recDisplay;
    public Button prev;
    public void searchdistrict(ActionEvent actionEvent) {
        Searchstat obj=new Searchstat();
        String state=stateds.getText();
        String ds=district.getText();
        String stats=obj.searchdt(state,ds);
        recDisplay.setText(stats);
    }

    public void prevPg(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)prev.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
