package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Questions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Result implements Initializable  {
    public TextArea textresult;
    public TextArea textpercent;
    public Button home;
    Questions ques=new Questions();
    BackgroundFill red=new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
    BackgroundFill green=new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY);
    Background bgred=new Background(red);
    Background bggreen=new Background(green);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Quiz.index=0;

        String s=String.format("%.2g",ques.getpercentage());
        textpercent.setText("Your score is "+s+"%\n");
       textresult.setText(ques.getscore());
       textresult.setEditable(false);
    }

    public void gohome(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)home.getScene().getWindow();
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("COVID19 TRACKER");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

}
