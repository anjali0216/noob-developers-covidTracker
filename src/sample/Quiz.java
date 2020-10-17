package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Questions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Quiz implements Initializable {

   public TextField textfield1;
    public RadioButton rad1;
    public RadioButton rad2;
    public RadioButton rad3;
    public RadioButton rad4;
//    public Button res;
    public Button next;
    static int index=0;
    static int score=0;

    Questions ques=new Questions();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//
//
        textfield1.setText(ques.question[index]);
        rad1.setText(ques.options[index][0]);
        rad2.setText(ques.options[index][1]);
        rad3.setText(ques.options[index][2]);
        rad4.setText(ques.options[index][3]);
        if(index==2)
            next.setText("SUBMIT AND SHOW RESULT");


    }

//    public void res(ActionEvent actionEvent) throws IOException {
//        Stage stage=(Stage)rad1.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("result.fxml"));
//        stage.setTitle("RESULT");
//        stage.setScene(new Scene(root, 300, 275));
//        stage.show();
//    }

    public void nextfun(ActionEvent actionEvent) throws IOException {

        if(rad1.isSelected()==true){
            score=1;
        }
        if(rad2.isSelected()==true){
            score=2;
        }
        if(rad3.isSelected()==true){
            score=3;
        }
        if(rad4.isSelected()==true){
            score++;
        }
        index++;
        System.out.println(score);


        Stage stage=(Stage)rad1.getScene().getWindow();
        if(index==3) {
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("result.fxml"));
            stage.setTitle("QUIZ");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();
        }
        else {
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
            stage.setTitle("QUIZ");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();
        }
    }

}
