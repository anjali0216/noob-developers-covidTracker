package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Allgraph {
    public Button worldgraph;
    public Button indiagraph;
    public Button statewisegraph;
    public Button growthchart;
    public void viewworldgraph(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)worldgraph.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("worldallgraph.fxml"));
        // Stategraph graph1=new Stategraph();
        //graph1.initialize();
        stage.setScene(new Scene( root,500, 500));
        stage.setMaximized(true);
        stage.show();
    }

    public void viewindiagraph(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)indiagraph.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("totalgraph.fxml"));
        // Stategraph graph1=new Stategraph();
        //graph1.initialize();
        stage.setScene(new Scene( root,500, 500));
        //stage.setMaximized(true);
        stage.show();
    }

    public void viewstategraph(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)statewisegraph.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("stategraph.fxml"));
        // Stategraph graph1=new Stategraph();
        //graph1.initialize();
        stage.setScene(new Scene( root,500, 500));
        stage.setMaximized(true);
        stage.show();
    }

    public void viewgrowthchart(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)indiagraph.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("totalgraph.fxml"));
        // Stategraph graph1=new Stategraph();
        //graph1.initialize();
        stage.setScene(new Scene( root,500, 500));
        //stage.setMaximized(true);
        stage.show();

    }
}
