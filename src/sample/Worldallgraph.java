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

public class Worldallgraph implements Initializable {



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

 BorderPane bp2=new BorderPane();
        CategoryAxis xAxis=new CategoryAxis();
        xAxis.setLabel("Countries");
        NumberAxis yAxis=new NumberAxis();
        yAxis.setLabel("Covid-19 Cases");
        BarChart bc=new BarChart(xAxis,yAxis);
        XYChart.Series dataseries1=new XYChart.Series();
        dataseries1.setName("Total confirmed cases");
        XYChart.Series dataseries2=new XYChart.Series();
        dataseries2.setName("Active Cases");
        XYChart.Series dataseries3=new XYChart.Series();
        dataseries3.setName("Total Recovered");

        XYChart.Series dataseries4=new XYChart.Series();
        dataseries4.setName("Serious Critical");
        XYChart.Series dataseries5=new XYChart.Series();
        dataseries5.setName("Deaths");
        // ObservableList<BarChart.Data> ol = FXCollections.observableArrayList();
        driver obje = new driver();
        String inLine="";

        {
            try {
                inLine = obje.JsonToString(obje.path + "\\worldStats.txt");
               // System.out.println(inLine);
                var gson = new Gson();
                worldRoot root1 = gson.fromJson(inLine, worldRoot.class);
                for (int i = 0; i < root1.data.countries_stat.size(); i++) {

                    dataseries1.getData().add(new XYChart.Data(root1.data.countries_stat.get(i).country_name, root1.data.countries_stat.get(i).cases));
                    dataseries2.getData().add(new XYChart.Data(root1.data.countries_stat.get(i).country_name, root1.data.countries_stat.get(i).active_cases));
                    dataseries3.getData().add(new XYChart.Data(root1.data.countries_stat.get(i).country_name, root1.data.countries_stat.get(i).total_recovered));
                    dataseries4.getData().add(new XYChart.Data(root1.data.countries_stat.get(i).country_name, root1.data.countries_stat.get(i).serious_critical));
                    dataseries5.getData().add(new XYChart.Data(root1.data.countries_stat.get(i).country_name, root1.data.countries_stat.get(i).deaths));
                }
                bc.getData().add(dataseries1);
                bc.getData().add(dataseries2);
                bc.getData().add(dataseries3);
               bc.getData().add(dataseries4);
                bc.getData().add(dataseries5);

                bc.setBarGap(0);
                bc.setCategoryGap(3);
                bp2.setCenter(bc);

                FadeTransition f = new FadeTransition(Duration.seconds(4), bc);
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
