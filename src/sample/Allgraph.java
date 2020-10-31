package sample;

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

public class Allgraph {
    public Button worldgraph;
    public Button indiagraph;
    public Button statewisegraph;
    public Button growthchart;
    public Button hmbtn;
    public Button wholestats;
    public void viewworldgraph(ActionEvent actionEvent) throws IOException {
        worldgraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage=new Stage();
                stage.setTitle("Graphical Analysis");
                Scene sc= null;
                try {
                    sc = new Scene(graphcollection.viewworlgraph(),500,500);
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
    }

    public void viewindiagraph(ActionEvent actionEvent) throws IOException {
        indiagraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage=new Stage();
                stage.setTitle("Graphical Analysis");
                Scene sc=new Scene(graphcollection.setGraph(),500,500);
                stage.setScene(sc);
                stage.setMaximized(true);
                stage.show();
            }
        });

    }

    public void viewstategraph(ActionEvent actionEvent) throws IOException {
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

    public void viewgrowthchart(ActionEvent actionEvent) throws IOException {

        growthchart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage=new Stage();
                stage.setTitle("Graphical Analysis");
                Scene sc= null;
                try {
                    sc = new Scene(graphcollection.showdategraph(),500,500);
                } catch (FileNotFoundException e) {
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

    public void backhome1(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)hmbtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public void showwholestats(ActionEvent actionEvent) {
        wholestats.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage=new Stage();
                stage.setTitle("Graphical Analysis");
                Scene sc= null;
                try {
                    sc = new Scene(graphcollection.showworldgraph(),500,500);
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
    }
}
