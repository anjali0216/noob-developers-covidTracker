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
import javafx.scene.control.Label;
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

//class to display the district-wise stats of a particular state
public class displayDistrictStats implements Initializable {
    public static String state;
    driver obj=new driver();
    public Button prev;
    public Label statel;
    boolean found;
    static String inLine = null;
    static JSONArray jsonarr2;

    @FXML
    TableView<District> table;
    @FXML
    TableColumn<District, Integer> sno;
    @FXML
    TableColumn<District, String> district;
    @FXML
    TableColumn<District, String> confirmed;
    @FXML
    TableColumn<District, String> active;
    @FXML
    TableColumn<District, String> recovered;
    @FXML
    TableColumn<District, String> deceased;

    //the overriden method which will initialize the fxml items for this class
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sno.setCellValueFactory(new PropertyValueFactory<District, Integer>("sno"));
        district.setCellValueFactory(new PropertyValueFactory<District, String>("district"));
        confirmed.setCellValueFactory(new PropertyValueFactory<District, String>("confirmed"));
        active.setCellValueFactory(new PropertyValueFactory<District, String>("active"));
        recovered.setCellValueFactory(new PropertyValueFactory<District, String>("recovered"));
        deceased.setCellValueFactory(new PropertyValueFactory<District, String>("deceased"));
        table.setItems(createList());
        statel.setText(state);
    }


    //a function that creates a list of District class type and return it
    public ObservableList<District> createList(){
        ObservableList<District> list= FXCollections.observableArrayList();
                        int i = 1;
                        for (Object value : jsonarr2) {
                            JSONObject jobj2 = (JSONObject) value;
                            District dt = new District(i++, jobj2.get("district").toString(), jobj2.get("confirmed").toString(), jobj2.get("active").toString(),jobj2.get("recovered").toString(), jobj2.get("deceased").toString());
                            list.add(dt);
                        }
                        return list;
                    }


        public boolean Search(){
            try {
                inLine = obj.JsonToString(obj.path + "\\districtStats.txt");
                JSONParser parse = new JSONParser();
                JSONArray jsonarr1 = (JSONArray) parse.parse(inLine);
                for (Object o : jsonarr1) {
                    JSONObject jobj1 = (JSONObject) o;
                    if (((String) jobj1.get("state")).equalsIgnoreCase(state)) {
                        found = true;
                        jsonarr2 = (JSONArray) jobj1.get("districtData");
                        break;
                    }
                }
            }catch (FileNotFoundException | ParseException e) {
                obj.displayDialog("Something went wrong. Refresh, and try again!");
                return found;
            }
            if(found==false){
                obj.displayDialog("No record found!");
                return found;
            }
            return found;
        }

    public void prevPg(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)prev.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("districtwise.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }


}
