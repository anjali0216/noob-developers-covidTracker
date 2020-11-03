package statFiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

//a controller-class to display the stats of all the stats in a table or to display the stats for a particular state

public class Statewise {
    public Button btn6;
    public Button prevpg;
    public TextField stname;
    public Label recordDisplay;
    public Button display;


    //function to search stats for a particular state
    public void searchstate() {
        Searchstat obj=new Searchstat();
        String state=stname.getText();
        String stats=obj.searchst(state);
        recordDisplay.setText(stats);
    }
//function to go back to previous page corresponds to the back button
    public void goPrevpg(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)prevpg.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indiastats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    //function to display the state-wise list
    public void displayList(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)display.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DisplayStateStats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }


}