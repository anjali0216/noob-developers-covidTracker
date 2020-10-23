package sample;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class downloadFiles implements Runnable {
    @Override
    public void run(){
        try {
            downloadStatestats();
        }
        catch (Exception e) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "You are not connected to the internet!");
        }
    }
    public void downloadStatestats() throws IOException, InterruptedException {
        var url="https://api.rootnet.in/covid19-in/stats/latest";
        var request= HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client= HttpClient.newBuilder().build();

        HttpResponse<String> response= null;

            response = client.send(request, HttpResponse.BodyHandlers.ofString() );
            String s = response.body();

            var gson = new Gson();

            stateRoot root = gson.fromJson(s, stateRoot.class);

            File file=new File("C:\\Users\\hp\\Downloads\\AppData");
            file.mkdir();
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("C:\\Users\\hp\\Downloads\\AppData\\statestats.csv"));
        } catch (FileNotFoundException e) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "The provided path is not correct");
        }
        StringBuilder sb= new StringBuilder();
            sb.append("S.No.");
            sb.append(",");
            sb.append("Location");
            sb.append(",");
            sb.append("Total Confirmed");
            sb.append(",");
            sb.append("Indian");
            sb.append(",");
            sb.append("Foreign");
            sb.append(",");
            sb.append("Recovered");
            sb.append(",");
            sb.append("Deaths");
            sb.append("\r\n");
            for(int i=0;i<root.data.regional.size();i++)
            {
                sb.append((i + 1));
                sb.append(",");
                sb.append(root.data.regional.get(i).loc);
                sb.append(",");
                sb.append(root.data.regional.get(i).totalConfirmed);
                sb.append(",");
                sb.append(root.data.regional.get(i).confirmedCasesIndian);
                sb.append(",");
                sb.append(root.data.regional.get(i).confirmedCasesForeign);
                sb.append(",");
                sb.append(root.data.regional.get(i).discharged);
                sb.append(",");
                sb.append(root.data.regional.get(i).deaths);
                sb.append("\r\n");
            }
            pw.write(sb.toString());
            pw.close();
    }
}
