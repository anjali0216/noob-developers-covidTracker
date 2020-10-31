package graphs;

import com.google.gson.Gson;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.chart.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.driver;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class graphcollection {

    public static BorderPane setGraph() {

        BorderPane bp1 = new BorderPane();
        PieChart pctotal1 = new PieChart();
        driver objec = new driver();
        String inline = "";

        pctotal1.setTitle("CoronaVirus Statistics for India");


        try {
            inline = objec.JsonToString(objec.path + "\\stateStats.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //

        var gson = new Gson();
        stateRoot root = gson.fromJson(inline, stateRoot.class);
        ObservableList<PieChart.Data> ol = FXCollections.observableArrayList(
                new PieChart.Data("Total Confirmed", root.data.summary.total),
                new PieChart.Data("Confirmed Cases Indian", root.data.summary.confirmedCasesIndian),
                new PieChart.Data("Confirmed Cases Foreign", root.data.summary.confirmedCasesForeign),
                new PieChart.Data("Discharged", root.data.summary.discharged),
                new PieChart.Data("Deaths", root.data.summary.deaths),
                new PieChart.Data("Confirmed But Location Unidentified", root.data.summary.confirmedButLocationUnidentified)
        );
        pctotal1.setData(ol);
        bp1.setCenter(pctotal1);


        pctotal1.setLegendSide(Side.LEFT);
        FadeTransition f = new FadeTransition(Duration.seconds(2), pctotal1);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();

        for (PieChart.Data data : pctotal1.getData()) {

            data.nameProperty().set(data.getName() + " : " + (int) data.getPieValue() + " cases");
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            JOptionPane.showMessageDialog(null, data.getName() + "\n Cases -->" + (int) data.getPieValue());

                        }
                    }
            );
        }
        return bp1;

    }


    public static BorderPane viewworlgraph() throws IOException, ParseException {

        BorderPane bp2 = new BorderPane();
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Countries");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Covid-19 Cases");
        BarChart bc = new BarChart(xAxis, yAxis);
        XYChart.Series dataseries1 = new XYChart.Series();
        dataseries1.setName("Total confirmed cases");
        XYChart.Series dataseries2 = new XYChart.Series();
        dataseries2.setName("Active Cases");
        XYChart.Series dataseries3 = new XYChart.Series();
        dataseries3.setName("Total Recovered");

        XYChart.Series dataseries4 = new XYChart.Series();
        dataseries4.setName("Serious Critical");
        XYChart.Series dataseries5 = new XYChart.Series();
        dataseries5.setName("Deaths");
        // ObservableList<BarChart.Data> ol = FXCollections.observableArrayList();
        driver obje = new driver();
        String inLine = "";
        try {
            inLine = obje.JsonToString(obje.path + "\\worldStats.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JSONParser parse = new JSONParser();

        JSONArray arr1 = (JSONArray) parse.parse(inLine);
        for (int i = 1; i < 51; i++) {
            JSONObject jsonobj = (JSONObject) arr1.get(i);
            //System.out.println("Hello");
            dataseries1.getData().add(new XYChart.Data(jsonobj.get("country"), jsonobj.get("cases")));
            dataseries2.getData().add(new XYChart.Data(jsonobj.get("country"), jsonobj.get("active")));
            dataseries3.getData().add(new XYChart.Data(jsonobj.get("country"), jsonobj.get("recovered")));
            dataseries4.getData().add(new XYChart.Data(jsonobj.get("country"), jsonobj.get("critical")));
            dataseries5.getData().add(new XYChart.Data(jsonobj.get("country"), jsonobj.get("deaths")));


        }


        bc.getData().add(dataseries1);
        bp2.setCenter(bc);
        FadeTransition f = new FadeTransition(Duration.seconds(4), bc);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();






        return bp2;
    }

    public static BorderPane showstategraph() {

        BorderPane bp = new BorderPane();


        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("States");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Total Confirmed Cases");
        BarChart pcstate = new BarChart(xAxis, yAxis);
        XYChart.Series dataseries1 = new XYChart.Series();
        dataseries1.setName("Total confirmed cases");
        XYChart.Series dataseries2 = new XYChart.Series();
        dataseries2.setName("Discharged");
        XYChart.Series dataseries3 = new XYChart.Series();
        dataseries3.setName("Deaths");
        XYChart.Series dataseries4 = new XYChart.Series();
        dataseries4.setName("Active Cases");

        // ObservableList<BarChart.Data> ol = FXCollections.observableArrayList();
        driver obje = new driver();
        String inLine = "";

        {
            try {
                inLine = obje.JsonToString(obje.path + "\\stateStats.txt");
                var gson = new Gson();
                stateRoot root = gson.fromJson(inLine, stateRoot.class);
                for (int i = 0; i < root.data.regional.size(); i++) {

                    dataseries1.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).totalConfirmed));
                    dataseries2.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).discharged));
                    dataseries3.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).deaths));
                    dataseries4.getData().add(new XYChart.Data(root.data.regional.get(i).loc, (root.data.regional.get(i).totalConfirmed - (root.data.regional.get(i).discharged + root.data.regional.get(i).deaths))));
                }

                pcstate.getData().add(dataseries1);
                pcstate.getData().add(dataseries2);
                pcstate.getData().add(dataseries4);

                pcstate.getData().add(dataseries3);

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


        return bp;
    }


    public static BorderPane showdategraph() throws FileNotFoundException, ParseException {
        BorderPane bp = new BorderPane();
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Date");
        NumberAxis y = new NumberAxis();
        y.setLabel("Total Confiemed Cases");
        LineChart lc = new LineChart(x, y);
        lc.setTitle("GrowthRate Chart of Covid-19 in India");
        XYChart.Series java = new XYChart.Series();
        XYChart.Series java1 = new XYChart.Series();
        XYChart.Series java2 = new XYChart.Series();
        XYChart.Series java3 = new XYChart.Series();

        java.setName("Total Confirmed");
        java1.setName("Total Deceased");
        java2.setName("Total Recovered");
        java3.setName("Total Active");
        driver obje = new driver();
        String inLine = "";
        inLine = obje.JsonToString(obje.path + "\\totalStats.txt");
        JSONParser parse = new JSONParser();
        JSONObject jobj = (JSONObject) parse.parse(inLine);
        JSONArray arr1 = (JSONArray) jobj.get("cases_time_series");
        for (int i = 0; i < arr1.size(); i++) {
            JSONObject jsonobj = (JSONObject) arr1.get(i);
            java.getData().add(new XYChart.Data(jsonobj.get("dateymd"), Integer.parseInt((String) jsonobj.get("totalconfirmed"))));
            java1.getData().add(new XYChart.Data(jsonobj.get("dateymd"), Integer.parseInt((String) jsonobj.get("totaldeceased"))));
            java2.getData().add(new XYChart.Data(jsonobj.get("dateymd"), Integer.parseInt((String) jsonobj.get("totalrecovered"))));
            java3.getData().add(new XYChart.Data(jsonobj.get("dateymd"), (Integer.parseInt((String) jsonobj.get("totalconfirmed"))-(Integer.parseInt((String) jsonobj.get("totalrecovered"))+Integer.parseInt((String) jsonobj.get("totaldeceased"))))));
        }
        lc.getData().add(java);
        lc.getData().add(java1);
        lc.getData().add(java2);
        lc.getData().add(java3);
        bp.setCenter(lc);
        return bp;
    }

    public static BorderPane showworldgraph() throws FileNotFoundException, ParseException {
        BorderPane bp3 = new BorderPane();
        PieChart pc3 = new PieChart();
        pc3.setTitle("CoronaVirus Statistics for world");
        driver obj = new driver();
        String inLine = "";
        inLine = obj.JsonToString(obj.path + "\\worldStats.txt");
        JSONParser parse = new JSONParser();

        JSONArray arr1 = (JSONArray) parse.parse(inLine);
        JSONObject jsonobj = (JSONObject) arr1.get(0);
        ObservableList<PieChart.Data> ol = FXCollections.observableArrayList(


          new PieChart.Data("Total Confirmed Cases",(long)jsonobj.get("cases")),

                new PieChart.Data("Total Active Cases",(long)jsonobj.get("active")),
                new PieChart.Data("Total Recovered Cases",(long) jsonobj.get("recovered")),
                new PieChart.Data("Total Critical Cases",(long)jsonobj.get("critical")),
                new PieChart.Data("Total Death Cases",(long) jsonobj.get("deaths"))
        );

        pc3.setData(ol);
        bp3.setCenter(pc3);


        pc3.setLegendSide(Side.LEFT);
        FadeTransition f = new FadeTransition(Duration.seconds(2), pc3);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();

        for (PieChart.Data data : pc3.getData()) {

            data.nameProperty().set(data.getName() + " : " + (long) data.getPieValue());
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            JOptionPane.showMessageDialog(null, data.getName());//+ (long) data.getPieValue());

                        }
                    }
            );
        }


return  bp3;
    }
}

