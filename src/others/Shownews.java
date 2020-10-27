package others;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.driver;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Shownews implements Initializable {
    driver obj = new driver();
    public TextArea textnews;
    public static String inLine;
    public Button prev;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            textnews.setText(inLine);
    }

    public String getnews() throws IOException{
        String data = "";
        int code = obj.checkURL("https://newsapi.org/v2/everything?q=covid19&apiKey=24402ddd2ca644e8b12ef256927ad15c");
        if (code != 200) {
            throw new RuntimeException();
        } else {
            Scanner sc = new Scanner(new URL("https://newsapi.org/v2/everything?q=covid19&apiKey=24402ddd2ca644e8b12ef256927ad15c").openStream());
            StringBuilder s = new StringBuilder();
            while (sc.hasNext()) {
                s.append(sc.nextLine());
            }
            Gson gson = new Gson();
            News covidnews = gson.fromJson(String.valueOf(s), News.class);
            StringBuilder s1 = new StringBuilder();

            for (int i = 0; i < covidnews.getArticles().size(); i++) {
                s1.append("TITLE : \n" + covidnews.getArticles().get(i).getTitle() + "\n");
                s1.append("Description :  \n" + covidnews.getArticles().get(i).getDescription() + "\n");
                s1.append("----------------------------------------------------------------------------------------------\n\n");
            }
            data = s1.toString();
        }
        return data;
    }

    public void prevPg(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)prev.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
