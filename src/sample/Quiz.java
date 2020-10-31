package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    public RadioButton rad5;


    public Button next;
    static int index=0;


    Questions ques=new Questions();
    driver ob=new driver();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        textfield1.setFont(Font.font("Monotype Corsiva",25.0));
        textfield1.setText(ques.question[index]);
        rad1.setText(ques.options[index][0]);
        rad2.setText(ques.options[index][1]);
        rad3.setText(ques.options[index][2]);
        rad4.setText(ques.options[index][3]);
        rad5.setText(ques.options[index][4]);
        if(index==2)
            next.setText("SUBMIT AND SHOW RESULT");
    }


    public void nextfun(ActionEvent actionEvent) throws IOException {
        if(rad1.isSelected()==false&&rad2.isSelected()==false&&rad3.isSelected()==false&&rad4.isSelected()==false&&rad5.isSelected()==false)
            ob.displayDialog("Please choose a valid option");
        else if((rad5.isSelected()==true)&&(rad1.isSelected()==true||rad2.isSelected()==true||rad3.isSelected()==true||rad4.isSelected()==true))
        ob.displayDialog("Please choose a valid option");
        else{
        ques.calculatescore(index, rad1.isSelected(), rad2.isSelected(),rad3.isSelected(),rad4.isSelected());
            index++;
            Stage stage = (Stage) rad1.getScene().getWindow();
            if (index == 3) {
                Parent root = null;
                root = FXMLLoader.load(getClass().getResource("result.fxml"));
                stage.setTitle("QUIZ");
                stage.setScene(new Scene(root, 500, 500));
                stage.show();
            } else {
                Parent root = null;
                root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
                stage.setTitle("QUIZ");
                stage.setScene(new Scene(root, 500, 500));
                stage.show();
            }
        }
    }

    }
