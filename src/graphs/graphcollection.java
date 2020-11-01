package graphs;
//importing necessary packages

import com.google.gson.Gson;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
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

 class graphcollection {

     static BorderPane setGraph() {//function creates graph for covid-19 stats of
        // india sets it to borderpane and returns that borderpane to corresponding calling function

        BorderPane bp1 = new BorderPane();//creating new borderpane
        PieChart pctotal1 = new PieChart();//creating new piechart
        String inline = "";

        pctotal1.setTitle("CoronaVirus Statistics for India");//setting title for piechart


        try {
            inline = driver.getInstance().JsonToString(driver.getInstance().path + "\\stateStats.txt");//calling data from
            // statestats file n storing it in string inLine


        } catch (FileNotFoundException e) {//exception handling
            e.printStackTrace();
        }
        //

        var gson = new Gson();//creating object of gson class to convert the json data to java object
        stateRoot root = gson.fromJson(inline, stateRoot.class);//mapping json data to stateroot
        // java class
        //list of data to be represented on the piechart
        ObservableList<PieChart.Data> ol = FXCollections.observableArrayList(
                //storing data corresponding to total confirmed cases in piechart
                new PieChart.Data("Total Confirmed", root.data.summary.total),
                //storing data corresponding to total confirmed indian cases in piechart
                new PieChart.Data("Confirmed Cases Indian", root.data.summary.confirmedCasesIndian),
                new PieChart.Data("Confirmed Cases Foreign", root.data.summary.confirmedCasesForeign),
                //storing data corresponding to total discharged cases in piechart
                new PieChart.Data("Discharged", root.data.summary.discharged),
                //storing data corresponding to total death cases in piechart
                new PieChart.Data("Deaths", root.data.summary.deaths),
                new PieChart.Data("Confirmed But Location Unidentified", root.data.summary.confirmedButLocationUnidentified)
        );

        pctotal1.setData(ol);//setting the data on this list to piechart pctotal1
        bp1.setCenter(pctotal1);//setting the piechart to the borderpane


        pctotal1.setLegendSide(Side.LEFT);//setting the key of the chart to the left of the scene
        //settings for fade in transition for graph to load(2 second time)
        FadeTransition f = new FadeTransition(Duration.seconds(2), pctotal1);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();
//code for getting the corresponding data name and pie value on clicking on any sector of the chart
        for (PieChart.Data data : pctotal1.getData()) {

            data.nameProperty().set(data.getName() + " : " + (int) data.getPieValue() + " cases");
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {//on clicking the chart sectors
                            //dialogue to be displayed
                            JOptionPane.showMessageDialog(null, data.getName() + "\n Cases -->" + (int) data.getPieValue());

                        }
                    }
            );
        }
        return bp1;//returning the borderpane

    }//end of method


    static BorderPane viewworlgraph() throws IOException, ParseException {//function creates
        // graph for covid-19 stats of world sets it to borderpane and returns
        // that borderpane to corresponding calling function

        BorderPane bp2 = new BorderPane();
        CategoryAxis xAxis = new CategoryAxis();//setting x axis as countries
        xAxis.setLabel("Countries");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Covid-19 Cases");//setting y axis as cases of covid-19
        BarChart bc = new BarChart(xAxis, yAxis);//creating new bar chart
        //setting the different bars that we want to plot
        XYChart.Series dataseries1 = new XYChart.Series();//setting bar for total confirmed cases
        dataseries1.setName("Total confirmed cases");
        // ObservableList<BarChart.Data> ol = FXCollections.observableArrayList();
        String inLine = "";

        try {
            inLine = driver.getInstance().JsonToString(driver.getInstance().path + "\\worldStats.txt");//accessing data
            //from worldstat text file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JSONParser parse = new JSONParser();//creating object of JSONParser class to parse the JSON data
//parsing the inLine as JSON array
        JSONArray arr1 = (JSONArray) parse.parse(inLine);
        //displaying top 50 countries in covid growth list
        for (int i = 1; i < 51; i++) {
            //converting each array element to JSON object
            JSONObject jsonobj = (JSONObject) arr1.get(i);
            //System.out.println("Hello");
            //adding data to the barchart
            dataseries1.getData().add(new XYChart.Data(jsonobj.get("country"), jsonobj.get("cases")));
        }


        bc.getData().add(dataseries1);//setting the data to barchart for plotting
        bp2.setCenter(bc);//setting bar chart in centre of pane

//settings for fade in transition of graph upon launching
        FadeTransition f = new FadeTransition(Duration.seconds(4), bc);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();
        return bp2;//return borderpane with graph
    }

    static BorderPane showstategraph() {//shows graph for the different states of india

        BorderPane bp = new BorderPane();


        CategoryAxis xAxis = new CategoryAxis();//setting the axes
        xAxis.setLabel("States");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Total Confirmed Cases");
        BarChart pcstate = new BarChart(xAxis, yAxis);
        XYChart.Series dataseries1 = new XYChart.Series();//creating different data series corresponding
        //to different bars of the chart
        dataseries1.setName("Total confirmed cases");
        XYChart.Series dataseries2 = new XYChart.Series();
        dataseries2.setName("Discharged");
        XYChart.Series dataseries3 = new XYChart.Series();
        dataseries3.setName("Deaths");
        XYChart.Series dataseries4 = new XYChart.Series();
        dataseries4.setName("Active Cases");


        String inLine = "";

        {
            try {
                inLine = driver.getInstance().JsonToString(driver.getInstance().path + "\\stateStats.txt");//accessing data from
                // stateStats txt file containing the api
                var gson = new Gson();//gson object to convert json to java object
                stateRoot root = gson.fromJson(inLine, stateRoot.class);//mapping json data to stateroot class
                for (int i = 0; i < root.data.regional.size(); i++) {
                    //adding new dataseries for different bars

                    dataseries1.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).totalConfirmed));
                    dataseries2.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).discharged));
                    dataseries3.getData().add(new XYChart.Data(root.data.regional.get(i).loc, root.data.regional.get(i).deaths));
                    dataseries4.getData().add(new XYChart.Data(root.data.regional.get(i).loc, (root.data.regional.get(i).totalConfirmed - (root.data.regional.get(i).discharged + root.data.regional.get(i).deaths))));
                }
//setting the series to bar chart
                pcstate.getData().add(dataseries1);
                pcstate.getData().add(dataseries2);
                pcstate.getData().add(dataseries4);

                pcstate.getData().add(dataseries3);

                bp.setCenter(pcstate);
                pcstate.setBarGap(0);//setting gap between bars to 0
                pcstate.setCategoryGap(3);

                FadeTransition f = new FadeTransition(Duration.seconds(4), pcstate);
                f.setFromValue(0);
                f.setToValue(1);
                f.play();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        return bp;
    }//end of method

    //function shows the chart for growthrate of covid in india over time
    static BorderPane showdategraph() throws FileNotFoundException, ParseException {
        BorderPane bp = new BorderPane();
        //setting axes
        CategoryAxis x = new CategoryAxis();
        x.setLabel("Date");
        NumberAxis y = new NumberAxis();
        y.setLabel("Total Confirmed Cases");
        //creating new line chart
        LineChart lc = new LineChart(x, y);
        lc.setTitle("GrowthRate Chart of Covid-19 in India");
        //setting the values we need to plot on the graph
        XYChart.Series java = new XYChart.Series();
        XYChart.Series java1 = new XYChart.Series();
        XYChart.Series java2 = new XYChart.Series();
        XYChart.Series java3 = new XYChart.Series();
//setting names for each plot
        java.setName("Total Confirmed");
        java1.setName("Total Deceased");
        java2.setName("Total Recovered");
        java3.setName("Total Active");

        String inLine = "";
        inLine = driver.getInstance().JsonToString(driver.getInstance().path + "\\totalStats.txt");
        //JSON parser parses the Json data
        JSONParser parse = new JSONParser();

        JSONObject jobj = (JSONObject) parse.parse(inLine);
        //we retrieve the case time series from the json format
        JSONArray arr1 = (JSONArray) jobj.get("cases_time_series");
        for (int i = 0; i < arr1.size(); i++) {
            //converting each element from json array to json object
            JSONObject jsonobj = (JSONObject) arr1.get(i);
            //setting plot values
            java.getData().add(new XYChart.Data(jsonobj.get("dateymd"), Integer.parseInt((String) jsonobj.get("totalconfirmed"))));
            java1.getData().add(new XYChart.Data(jsonobj.get("dateymd"), Integer.parseInt((String) jsonobj.get("totaldeceased"))));
            java2.getData().add(new XYChart.Data(jsonobj.get("dateymd"), Integer.parseInt((String) jsonobj.get("totalrecovered"))));
            java3.getData().add(new XYChart.Data(jsonobj.get("dateymd"), (Integer.parseInt((String) jsonobj.get("totalconfirmed"))-(Integer.parseInt((String) jsonobj.get("totalrecovered"))+Integer.parseInt((String) jsonobj.get("totaldeceased"))))));
        }
        //adding these data to line chart
        lc.getData().add(java);
        lc.getData().add(java1);
        lc.getData().add(java2);
        lc.getData().add(java3);
        bp.setCenter(lc);
        return bp;
    }
    //shows covid-19 cases stats for the world
    static BorderPane showworldgraph() throws FileNotFoundException, ParseException {
        BorderPane bp3 = new BorderPane();
        PieChart pc3 = new PieChart();//new piechart
        pc3.setTitle("CoronaVirus Statistics for world");

        String inLine = "";
        inLine = driver.getInstance().JsonToString(driver.getInstance().path + "\\worldStats.txt");
        JSONParser parse = new JSONParser();

        JSONArray arr1 = (JSONArray) parse.parse(inLine);
        JSONObject jsonobj = (JSONObject) arr1.get(0);
        ObservableList<PieChart.Data> ol = FXCollections.observableArrayList(

//setting data to piechart
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

        for (PieChart.Data data : pc3.getData()) {//on clicking sectors of piechart
            //we get the corresponding data values

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
}//end of class

