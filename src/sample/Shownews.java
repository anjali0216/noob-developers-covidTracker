package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import models.Newsgson;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Shownews implements Initializable {
    public TextArea textnews;
    Newsgson news=new Newsgson();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            textnews.setText(news.getnews());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
