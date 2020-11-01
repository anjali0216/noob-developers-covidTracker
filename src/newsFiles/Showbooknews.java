package newsFiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.driver;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Showbooknews implements Initializable {
    public TextArea textnews;
    public Button gohome;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        textnews.setText(getBookmarks());
    }

    /*retieving data from Bookmarks.txt file*/
    private String getBookmarks(){
        StringBuilder s=new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(driver.getInstance().path+"\\bookmarks.txt"));

            String contentLine=br.readLine();
            while (contentLine!=null)
            {

                s.append(contentLine+"\n");
                contentLine=br.readLine();
            }
        } catch (Exception e) {
            driver.getInstance().displayDialog("You don't have any bookmarks yet!");
        }
        return s.toString();
    }


    /*Function for returning back to home screen*/
    public  void goHome(ActionEvent e) throws IOException {
        Stage stage=(Stage)gohome.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}