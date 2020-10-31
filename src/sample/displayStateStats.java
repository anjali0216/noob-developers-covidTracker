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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


//class to display the state-wise stats for india in a table
public class displayStateStats implements Initializable {
    driver obj=new driver();
    public Button prev;

    @FXML
     TableView<State> table;
    @FXML
     TableColumn<State, Integer> sno;
    @FXML
    TableColumn<State, String> loc;
    @FXML
    TableColumn<State, String> totalConfirmed;
    @FXML
   TableColumn<State, String> discharged;
    @FXML
     TableColumn<State, String> deaths;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sno.setCellValueFactory(new PropertyValueFactory<State, Integer>("sno"));
        loc.setCellValueFactory(new PropertyValueFactory<State, String>("loc"));
        totalConfirmed.setCellValueFactory(new PropertyValueFactory<State, String>("totalConfirmed"));
        discharged.setCellValueFactory(new PropertyValueFactory<State, String>("discharged"));
        deaths.setCellValueFactory(new PropertyValueFactory<State, String>("deaths"));
        table.setItems(createList());
    }

    public ObservableList<State> createList(){
        ObservableList<State> list= FXCollections.observableArrayList();
        try {
            String inLine=obj.JsonToString(obj.path+"\\stateStats.txt");

            var gson = new Gson();
            stateRoot root = gson.fromJson(inLine, stateRoot.class);
            for (int i = 0; i < root.data.regional.size(); i++){
                State st=new State(i+1,root.data.regional.get(i).loc,Integer.toString(root.data.regional.get(i).totalConfirmed),Integer.toString(root.data.regional.get(i).discharged),Integer.toString(root.data.regional.get(i).deaths));
                list.add(st);
            }
        }catch (FileNotFoundException e) {
            obj.displayDialog("Something went wrong. Refresh, and try again!");
        }
        return list;
    }


    public void prevPg(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)prev.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("statewise.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
