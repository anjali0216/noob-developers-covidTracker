package sample;

import javax.swing.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class driver{
    String path = System.getProperty("user.dir");
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
}
