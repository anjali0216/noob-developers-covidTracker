package sample;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Getnews;
import models.News;
import models.Newsgson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Shownews implements Initializable {
    driver ob=new driver();
    public Button gohome1;
    public Button addbookmarks;
    Newsgson news=new Newsgson();
    @FXML
    TableView<Getnews> newstable;
    @FXML
    TableColumn<Getnews,String> article;
    @FXML
    TableColumn<Getnews, Button> actionbookmark;
    ObservableList<Getnews> list=FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Stage stage= (Stage) textnews.getScene().getWindow();
//        newstable.resize(stage.getWidth(),stage.getHeight());

        article.setCellValueFactory(new PropertyValueFactory<Getnews, String>("description"));
        actionbookmark.setCellValueFactory(new PropertyValueFactory<Getnews, Button>("button"));

        try {
            list=news.newsList();
            newstable.setItems(list);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        article.setCellFactory(new Callback<TableColumn<Getnews,String>, TableCell<Getnews,String>>() {
            @Override
            public TableCell<Getnews, String> call( TableColumn<Getnews, String> param) {
                final TableCell<Getnews, String> cell = new TableCell<Getnews, String>() {
                    private Text text;
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            text = new Text(item.toString());
                            text.setWrappingWidth(400); // Setting the wrapping width to the Text
                            setGraphic(text);
                        }
                    }
                };
                return  cell;
            }
        });




    }

    public  void addBookmarks(ActionEvent event) throws IOException {

        FileWriter fw=new FileWriter(new File(ob.path+"\\bookmarks.txt"));
        StringBuilder s1=new StringBuilder();
        for(var obj:list)
        {
            if(obj.getButton().isSelected())
            {
            s1.append("TITLE : \n"+obj.getTitle()+"\n");
            s1.append("Description :  \n"+obj.getDescription()+"\n");
            s1.append("----------------------------------------------------------------------------------------------\n");
            }
        }
        fw.write(s1.toString());
        fw.close();
    }

    public  void goHome1(ActionEvent e) throws IOException {
        Stage stage=(Stage)gohome1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }


}
