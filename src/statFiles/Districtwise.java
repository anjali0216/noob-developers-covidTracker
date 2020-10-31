package statFiles;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

//a controller-class that contains function to display the district-wise stats for a particular state or
// search for a particular district in a particular state
public class  Districtwise {

    public TextField stateds;
    public TextField district;
    public Button search;
    public Label recDisplay;
    public Button prev;
    public TextField statedw;
    public Button display;

    public void searchdistrict() {
        Searchstat obj=new Searchstat();
        String state=stateds.getText();
        String ds=district.getText();
        String stats=obj.searchdt(state,ds);
        recDisplay.setText(stats);
    }

    public void prevPg() throws IOException {
        Stage stage=(Stage)prev.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indiastats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public void displayList() throws IOException {
        displayDistrictStats.state=statedw.getText();
        displayDistrictStats ob=new displayDistrictStats();
        if(ob.Search()){
            Stage stage = (Stage) display.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("DisplayDistrictStats.fxml"));
            stage.setScene(new Scene(root, 500, 500));
            stage.show();
        }
    }
}
