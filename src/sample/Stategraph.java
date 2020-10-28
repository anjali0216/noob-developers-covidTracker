package sample;

import com.google.gson.Gson;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Stategraph implements Initializable {

    public BorderPane bp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        CategoryAxis xAxis=new CategoryAxis();
        xAxis.setLabel("States");
        NumberAxis yAxis=new NumberAxis();
        yAxis.setLabel("Total Confirmed Cases");
        BarChart pcstate=new BarChart(xAxis,yAxis);
        XYChart.Series dataseries1=new XYChart.Series();
        dataseries1.setName("Total confirmed cases");
        XYChart.Series dataseries2=new XYChart.Series();
        dataseries2.setName("Confirmed Cases Indian");
        XYChart.Series dataseries3=new XYChart.Series();
        dataseries3.setName("Confirmed Cases Foreign");
        XYChart.Series dataseries4=new XYChart.Series();
        dataseries4.setName("Discharged");
        XYChart.Series dataseries5=new XYChart.Series();
        dataseries5.setName("Deaths");
       // ObservableList<BarChart.Data> ol = FXCollections.observableArrayList();
        driver obje = new driver();
        String inLine="";

        {
            try {
                inLine = obje.JsonToString(obje.path + "\\stateStats.txt");
                var gson = new Gson();
                stateRoot root = gson.fromJson(inLine, stateRoot.class);
                for (int i = 0; i < root.data.regional.size(); i++) {

                    dataseries1.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).totalConfirmed));
                    dataseries2.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).confirmedCasesIndian));
                    dataseries3.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).confirmedCasesForeign));
                    dataseries4.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).discharged));
                    dataseries5.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).deaths));
                }
                pcstate.getData().add(dataseries1);
                pcstate.getData().add(dataseries2);
                pcstate.getData().add(dataseries3);
                pcstate.getData().add(dataseries4);
                pcstate.getData().add(dataseries5);
                bp.setCenter(pcstate);
                pcstate.setBarGap(0);
                pcstate.setCategoryGap(3);

                FadeTransition f = new FadeTransition(Duration.seconds(4), pcstate);
                f.setFromValue(0);
                f.setToValue(1);
                f.play();

               /* for (BarChart.Data data : pcstate.getData()) {

                    data.nameProperty().set(data.getName() + " : " + data.getPieValue() + " cases");
                    data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    JOptionPane.showMessageDialog(null, "State --> " + data.getName() + "\nTotal confirmed Cases -->" +  data.getPieValue());

                                }
                            }
                    );
                }*/


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }







    }


}
