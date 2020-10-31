package graphs;

//importing necessary packages
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Allgraph {//class containing function calls to various buttons for displaying graphs
    public Button worldgraph;
    public Button indiagraph;
    public Button statewisegraph;
    public Button growthchart;
    public Button hmbtn;
    public Button wholestats;
    //function that calls the stage containing the graph with overall stats for the world
    public void viewworldgraph(ActionEvent actionEvent) throws IOException {
        worldgraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage=new Stage();//creating new stage
                stage.setTitle("Graphical Analysis");
                Scene sc= null;
                try {//placing the code in try block for exception handling
                    sc = new Scene(graphcollection.viewworlgraph(),500,500);//set the scene
                    // containing the graph to this new stage
                } catch (FileNotFoundException e) {//file not found exception handling
                    e.printStackTrace();
                } catch (ParseException | IOException e) {//possible exception if problems
                    // arise while parsing
                    e.printStackTrace();
                }
                stage.setScene(sc);
                stage.setMaximized(true);//setting the stage to max window size
                stage.show();
            }
        });
    }
    //function that calls the stage containing the scene with stats of India graph
    public void viewindiagraph(ActionEvent actionEvent) throws IOException {
        indiagraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {//on clicking the button
                Stage stage=new Stage();//new stage creation
                stage.setTitle("Graphical Analysis");
                Scene sc=new Scene(graphcollection.setGraph(),500,500);
                stage.setScene(sc);//setting scene to stage
                stage.setMaximized(true);
                stage.show();
            }
        });

    }

    public void viewstategraph(ActionEvent actionEvent) throws IOException {//call to statewise
        // stats graph
        statewisegraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage=new Stage();
                stage.setTitle("Graphical Analysis");
                Scene sc=new Scene(graphcollection.showstategraph(),500,500);
                stage.setScene(sc);
                stage.setMaximized(true);
                stage.show();
            }
        });

    }
    //function displays the growthrate chart of covid-19 in india
    public void viewgrowthchart(ActionEvent actionEvent) throws IOException {

        growthchart.setOnAction(new EventHandler<ActionEvent>() {//on clicking the
            // corresponding button
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage=new Stage();
                stage.setTitle("Graphical Analysis");
                Scene sc= null;
                try {
                    sc = new Scene(graphcollection.showdategraph(),500,500);//setting
                    // graph to new scene by calling the showdategraph function of
                    // graphcollection class
                } catch (FileNotFoundException e) {//exception  handling
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                stage.setScene(sc);
                stage.setMaximized(true);
                stage.show();
            }
        });
    }
    //button to take us back to previous page
    public void backhome1(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)hmbtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));//setting previous page scene to the stage
        stage.show();
    }
    //function that shows the graphical representation of the top countries in covid-19 case-count
    public void showwholestats(ActionEvent actionEvent) {
        wholestats.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage=new Stage();
                stage.setTitle("Graphical Analysis");
                Scene sc= null;
                try {
                    sc = new Scene(graphcollection.showworldgraph(),500,500);//setting scene
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ParseException | IOException e) {
                    e.printStackTrace();
                }
                stage.setScene(sc);
                stage.setMaximized(true);
                stage.show();
            }
        });
    }//end of method
}//end of class
