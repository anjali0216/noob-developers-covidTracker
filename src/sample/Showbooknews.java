package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Showbooknews implements Initializable {
    public TextArea textnews;
    public Button gohome;
    driver ob=new driver();

    /*retieving data from Bookmarks.txt file*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringBuilder s=new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ob.path+"\\bookmarks.txt"));

            String contentLine=br.readLine();
            while (contentLine!=null)
            {

                s.append(contentLine+"\n");
                contentLine=br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textnews.setText(s.toString());
    }


    /*Function for returning back to home screen*/
    public  void goHome(ActionEvent e) throws IOException {
        Stage stage=(Stage)gohome.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
