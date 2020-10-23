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

public class Statewise {
    public Button btn6;
    public Button prevpg;
    public TextField stname;
    public Label recordDisplay;

    public void searchstate() throws IOException {
        Searchstat obj=new Searchstat();
        String state=stname.getText();
        String stats=obj.searchst(state);
        recordDisplay.setText(stats);
}

    public void goPrevpg(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)prevpg.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
    }
/* */