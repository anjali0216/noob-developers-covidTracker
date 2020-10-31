package models;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Newsgson {

    /*function for getting news from API*/

    String getnews() throws IOException, InterruptedException {
        var url = "https://newsapi.org/v2/everything?q=covid19&apiKey=24402ddd2ca644e8b12ef256927ad15c";
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();   //sending a request
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());    //getting the response from the given url
        String s = response.body();
        return s;
    }

    /*Function returning observable list of Getnews classes objects having details about bookmarked news*/
    public ObservableList<Getnews> newsList() throws IOException, InterruptedException {
        ObservableList<Getnews> list= FXCollections.observableArrayList();
        String inline=getnews();
        Gson gson=new Gson();
        News covidnews=gson.fromJson(inline,News.class);
        for(int i=0;i<covidnews.getArticles().size();i++)
        {
            list.add(new Getnews(covidnews.getArticles().get(i).getTitle(),covidnews.getArticles().get(i).getDescription()));
        }
        return list;
    }



}
