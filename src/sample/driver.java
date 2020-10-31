package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class driver {
    public String path = System.getProperty("user.dir");
    public int checkURL(String link){
        int response=0;
        try{
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            response = conn.getResponseCode();
        }catch(Exception e){
        }
        return response;
    }

    public void displayDialog(String msg){
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,msg);
    }

    public String JsonToString(String path) throws FileNotFoundException {
        File file=new File(path);
        Scanner sc=new Scanner(file);
        String inLine;
        StringBuilder data=new StringBuilder();
        while(sc.hasNext()){
            data.append(sc.nextLine());
        }
        inLine= data.toString();
        return inLine;
    }
    public EventHandler<ActionEvent> open(Hyperlink link){
        Desktop d=Desktop.getDesktop();
        EventHandler e=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    d.browse(URI.create(link.getText()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        return e;
    }
}
