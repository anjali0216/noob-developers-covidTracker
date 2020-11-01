package adHelp;


//importing required packages
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.driver;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;


//class implements initializble interface to immediately set value to table columns for advisory display
public class Advisoriespage implements Initializable {

    public Button homebtn;


    //table view
    @FXML
    TableView<Advisory> table;
    @FXML
    TableColumn<Advisory, Integer> sno;
    @FXML
    TableColumn<Advisory, String> title;
    @FXML
    TableColumn<Advisory, Hyperlink> link;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setting values for  different columns
        sno.setCellValueFactory(new PropertyValueFactory<Advisory, Integer>("sno"));
        title.setCellValueFactory(new PropertyValueFactory<Advisory, String>("title"));
        link.setCellValueFactory(new PropertyValueFactory<Advisory, Hyperlink>("link"));
        table.setItems(addlist());

        title.setCellFactory(new Callback<TableColumn<Advisory, String>, TableCell<Advisory, String>>() {
            @Override
            public TableCell<Advisory, String> call(TableColumn<Advisory, String> param) {
                final TableCell<Advisory, String> cell = new TableCell<Advisory, String>() {
                    private Text text;

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            text = new Text(item.toString());
                            text.setWrappingWidth(300); // Setting the wrapping width to the Text
                            setGraphic(text);
                        }
                    }
                };
                return cell;
            }
        });
    }

    public ObservableList<Advisory> addlist() {//function to display advisories in table form
        //list of items in the table
        ObservableList<Advisory> list = FXCollections.observableArrayList();
        String inLine = null;
        try {
            inLine = driver.getInstance().JsonToString(driver.getInstance().path + "\\advisory.txt");

//creating object of json parser to parse data from the json string
            JSONParser parse = new JSONParser();

            JSONObject jobj = (JSONObject) parse.parse(inLine);

            JSONObject jobj1 = (JSONObject) jobj.get("data");
            JSONArray arr1 = (JSONArray) jobj1.get("notifications");
            int i;

            for (i = 0; i < arr1.size(); i++) {
                //creating hyperlinks for advisory urls
                Hyperlink add = new Hyperlink();
                //parsing json data
                JSONObject jsonobj = (JSONObject) arr1.get(i);
                add.setText(jsonobj.get("link").toString());
                //onclicking the link..redirect us to browser
                add.setOnAction(driver.getInstance().open(add));
                //adding serial no, title and links of advisory to the table
                Advisory ad = new Advisory(i + 1, (String) jsonobj.get("title"), add);

                list.add(ad);
            }
        } catch (FileNotFoundException | ParseException e) {//exception handling
            driver.getInstance().displayDialog("Something went wrong. Refresh, and try again!");
        }
        return list;
    }

    //button to take back to home page
    public void takemehome(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) homebtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}









