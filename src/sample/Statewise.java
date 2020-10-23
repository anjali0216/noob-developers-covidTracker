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

    public void searchstate() {
        Searchstat obj=new Searchstat();
        String state=stname.getText();
        Regional obj2=obj.searchSt(state);
        if(obj2==null) {
            recordDisplay.setText("No such record found!");
        }
        else if(obj2.loc!=""){
            recordDisplay.setText("Location: "+obj2.loc+"\nConfirmed Cases(Indian): "+obj2.confirmedCasesIndian+"\nConfirmed Cases(Foreign): "+
                    obj2.confirmedCasesForeign+"\nTotal Confirmed: "+obj2.totalConfirmed+"\nRecovered: "+obj2.discharged+"\nDeaths: "+obj2.deaths);
        }
    }

    public void goPrevpg() throws IOException {
        Stage stage=(Stage)prevpg.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setScene(new Scene(root, 500, 300));
        stage.show();
    }
}
