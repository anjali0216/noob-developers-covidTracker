package statFiles;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//a controller class to display the stats of covid-19

public class Stats implements Initializable {
    public TextArea worldtextarea;
    public Button countrybtn;
    public Button indiabtn;
    public Button hmbtn5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        totalcase objc=new totalcase();
        try {
            worldtextarea.setText(objc.displayworldtotal());
        } catch (FileNotFoundException e) {
            System.out.println("HELLO");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("yello");
            e.printStackTrace();
        }

    }

    //function to display country-wise stats
    public void showcountrytable(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)countrybtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("displayWorldStats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    //function to display stats for india
    public void showindianstats(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)indiabtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("indiastats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public void takehome5(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)hmbtn5.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }


}
