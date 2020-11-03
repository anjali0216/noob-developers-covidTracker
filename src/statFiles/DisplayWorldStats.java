package statFiles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


//class to display the country-wise stats for world in a table
public class DisplayWorldStats implements Initializable {
    public Button prevbtn1;
    @FXML
    TableView<World> table;
    @FXML
    TableColumn<World, Integer> serialno;
    @FXML
    TableColumn<World, String> country;
    @FXML
    TableColumn<World, String> confirmed;
    @FXML
    TableColumn<World, String> active;
    @FXML
    TableColumn<World, String> recovered;
    @FXML
    TableColumn<World, String> critical;
    @FXML
    TableColumn<World, String> death;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        serialno.setCellValueFactory(new PropertyValueFactory<World, Integer>("sno"));
        country.setCellValueFactory(new PropertyValueFactory<World, String>("country"));
        confirmed.setCellValueFactory(new PropertyValueFactory<World, String>("cases"));
        active.setCellValueFactory(new PropertyValueFactory<World, String>("active"));
        recovered.setCellValueFactory(new PropertyValueFactory<World, String>("recovered"));
        critical.setCellValueFactory(new PropertyValueFactory<World, String>("critical"));
        death.setCellValueFactory(new PropertyValueFactory<World, String>("deaths"));
        try {
            table.setItems(createlist());
        } catch (Exception e) {
            driver.getInstance().displayDialog("Something went wrong. Refresh, and try again!");
        }


    }

    private ObservableList<World> createlist() throws FileNotFoundException, ParseException {

        ObservableList<World> list= FXCollections.observableArrayList();
        String inLine = driver.getInstance().JsonToString(driver.getInstance().path + "\\worldStats.txt");

        JSONParser parse = new JSONParser();

        JSONArray arr1 = (JSONArray) parse.parse(inLine);
         int i;
        for (i = 1; i < arr1.size(); i++) {
            String totalcases;
            String activecases;
            String recoveredcases;
            String criticalcases;
            String deathcases;

            JSONObject jsonobj = (JSONObject) arr1.get(i);
            if(jsonobj.get("cases")==null)
                totalcases="Data Not Available";
            else
                totalcases=jsonobj.get("cases").toString();

            if(jsonobj.get("active")==null)
                activecases="Data Not Available";
            else
                activecases=jsonobj.get("active").toString();

            if(jsonobj.get("recovered")==null)
                recoveredcases="Data Not Available";
            else
                recoveredcases=jsonobj.get("recovered").toString();

            if(jsonobj.get("critical")==null)
                criticalcases="Data Not Available";
            else
                criticalcases=jsonobj.get("critical").toString();

            if(jsonobj.get("deaths")==null)
                deathcases="Data Not Available";
            else
                deathcases=jsonobj.get("deaths").toString();

            World w=new World(i,(String)jsonobj.get("country"),totalcases,activecases,recoveredcases,criticalcases,deathcases);

            list.add(w);
        }
        return list;
    }

    public void goPrevious(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)prevbtn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stats.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
