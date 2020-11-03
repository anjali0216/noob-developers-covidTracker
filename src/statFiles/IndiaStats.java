package statFiles;

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

//a controller class to display the covid-19 stats for india
//class implements the Initializable interface
public class IndiaStats implements Initializable{
    public Button btn4;
    public Button btn5;
    public Button calendar;
    public Button homebtn;
    public TextArea totalcaselabel;

    totalcase objj=new totalcase();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        totalcaselabel.setText(objj.displaytotal());

    }


    //function for state-wise stats
    public void showState(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("statewise.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }


    //function for distric-wise stats
    public void showDistrict(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("districtwise.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    //function to show the daily stats of India
    public void showCalendar(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)btn4.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("calendar.fxml"));
        stage.setTitle("CALENDAR");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

//function corresponding to onclick of go Back to home button
    public void goBackHome(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)homebtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }


}
