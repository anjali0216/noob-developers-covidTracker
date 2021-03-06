package newsFiles;


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
import sample.driver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Shownews extends Newsgson implements  Initializable {

    public Button gohome1;
    public Button addbookmarks;

    @FXML
    TableView<Getnews> newstable;
    @FXML
    TableColumn<Getnews,String> article;
    @FXML
    TableColumn<Getnews, Button> actionbookmark;
    private ObservableList<Getnews> list=FXCollections.observableArrayList();

    /*
    function for creating a list having one column as bookmark radiobutton and other
     having details about the articles related to covid-19.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        article.setCellValueFactory(new PropertyValueFactory<Getnews, String>("description"));  //creating news article column
        actionbookmark.setCellValueFactory(new PropertyValueFactory<Getnews, Button>("button"));  //creating bookmark event column .
        newstable.setItems(createList());

        //enabling wrapping text property for table cells having news about covid 19.
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

    private ObservableList<Getnews> createList(){
        try {
            list=newsList();
            //setting the items into the table
        } catch (Exception e) {
            driver.getInstance().displayDialog("You are not connected to the internet.");
        }
        return list;
    }
    /*
    Function for adding bookmarked news  to a file.
     */
    public  void addBookmarks(ActionEvent event) throws IOException{
        bookmarkTxt();
    }

    private void bookmarkTxt() throws IOException {
        FileWriter fw=new FileWriter(new File(driver.getInstance().path+"\\bookmarks.txt"));
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

    /*function for returning to home screen*/

    public  void goHome1(ActionEvent e) throws IOException {
        Stage stage=(Stage)gohome1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }


}