package sample;

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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayWorldStats implements Initializable {
    public Button prevbtn1;
    driver obj=new driver();
    @FXML
    TableView<World> table;
    @FXML
    TableColumn<World, Integer> sno;
    @FXML
    TableColumn<World, String> coun;
    @FXML
    TableColumn<World, Long> con;
    @FXML
    TableColumn<World, Long> act;
    @FXML
    TableColumn<World, Long> rec;
    @FXML
    TableColumn<World, Long> crit;
    @FXML
    TableColumn<World, Long> death;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sno.setCellValueFactory(new PropertyValueFactory<World, Integer>("sno"));
        coun.setCellValueFactory(new PropertyValueFactory<World, String>("country"));
        con.setCellValueFactory(new PropertyValueFactory<World, Long>("cases"));
        act.setCellValueFactory(new PropertyValueFactory<World, Long>("active"));
        rec.setCellValueFactory(new PropertyValueFactory<World, Long>("recovered"));
        crit.setCellValueFactory(new PropertyValueFactory<World, Long>("critical"));
        death.setCellValueFactory(new PropertyValueFactory<World, Long>("deaths"));
        try {
            table.setItems(createlist());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public ObservableList<World> createlist() throws FileNotFoundException, ParseException {

        ObservableList<World> list= FXCollections.observableArrayList();
        String inLine = obj.JsonToString(obj.path + "\\worldStats.txt");
        //System.out.println(inLine);
        JSONParser parse = new JSONParser();

        JSONArray arr1 = (JSONArray) parse.parse(inLine);
         int i;
        for (i = 1; i < arr1.size(); i++) {


            JSONObject jsonobj = (JSONObject) arr1.get(i);
            World w=new World(i,(String)jsonobj.get("country"),(long)jsonobj.get("cases"),(long)jsonobj.get("active"),(long)jsonobj.get("recovered"),(long)jsonobj.get("critical"),(long)jsonobj.get("deaths"));
          // System.out.println(jsonobj.get("country"));
            list.add(w);
        }
        return list;
    }

    public void goprev1(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)prevbtn1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("firststatspage.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
