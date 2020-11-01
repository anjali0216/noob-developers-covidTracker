package sample;

import adHelp.Helplinepage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button refbtn;
    public Button shownews;
    public Button advisoriesbutton;
    public Button graphbtn;
    public Button showbookmarks;
    public Label updated;
    Thread t;
    static int count=0;

    public static Label s_label;


    public void stats(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btn2.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();


    }

    public void symptom(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("symptom.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();


    }

    public void showsites(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("showsites.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();

    }

    public void Refresh(ActionEvent actionEvent) {
        updated.setText("Updating");
        updateFiles.check=1;
        t= new Thread(new updateFiles());
        t.start();
    }


    public void viewadvisories(ActionEvent actionEvent) throws IOException {


        Stage stage = (Stage) advisoriesbutton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("advisoriespage.fxml"));
        stage.setTitle("Advisories and Guidelines");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();


    }

    public void viewhelpline() {
        try {
            Helplinepage.inLine=driver.getInstance().JsonToString(driver.getInstance().path + "\\Helpline.txt");
            Helplinepage.createList();
            Stage stage = (Stage) advisoriesbutton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("helplinepage.fxml"));
            stage.setScene(new Scene(root, 500, 500));
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showNews(ActionEvent event) throws IOException, InterruptedException {
        Stage stage = (Stage) btn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("shownews.fxml"));
        stage.setScene(new Scene(root, 500, 500));

        stage.show();

    }



    public void showgraph(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) graphbtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("allgraph.fxml"));
        stage.setTitle("GRAPHICAL ANALYSIS");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public void showBookmarks(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) graphbtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("showbooknews.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(count==0){
            count++;
            updated.setText("Updating");
            t= new Thread(new updateFiles());
            t.start();
        }
        else{
            if(updateFiles.time!=null)
                updated.setText("Last Updated At: "+updateFiles.time);
            else
                updated.setText("You are not connected to the internet.");
        }

        s_label=updated;
    }
}
