package sample;

import com.google.gson.Gson;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Totalgraph implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        BorderPane bp1=new BorderPane();
        PieChart pctotal1=new PieChart();
        driver objec = new driver();
        String inline="";

        pctotal1.setTitle("CoronaVirus Statistics for India");


        try {
            inline=objec.JsonToString(objec.path+"\\stateStats.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //

        var gson = new Gson();
            stateRoot root = gson.fromJson(inline, stateRoot.class);
            ObservableList<PieChart.Data> ol = FXCollections.observableArrayList(
                    new PieChart.Data("Total Confirmed",root.data.summary.total),
                    new PieChart.Data("Confirmed Cases Indian",root.data.summary.confirmedCasesIndian),
                    new PieChart.Data("Confirmed Cases Foreign",root.data.summary.confirmedCasesForeign),
                    new PieChart.Data("Discharged",root.data.summary.discharged),
                    new PieChart.Data("Deaths",root.data.summary.deaths),
                    new PieChart.Data("Confirmed But Location Unidentified",root.data.summary.confirmedButLocationUnidentified)
            );
            //System.out.println("hello"+ root.data.summary.total);
            pctotal1.setData(ol);
            bp1.setCenter(pctotal1);









        pctotal1.setLegendSide(Side.LEFT);
        FadeTransition f = new FadeTransition(Duration.seconds(2),pctotal1);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();

        for (PieChart.Data data : pctotal1.getData()){

            data.nameProperty().set(data.getName()+ " : "+(int)data.getPieValue()+ " cases");
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            JOptionPane.showMessageDialog(null,data.getName()+ "\n Cases -->" +(int)data.getPieValue());

                        }
                    }
            );
        }

    }
}
