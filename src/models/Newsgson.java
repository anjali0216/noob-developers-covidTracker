package models;

import com.google.gson.Gson;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Newsgson {

    public String getnews() throws IOException, InterruptedException {
        var url = "https://newsapi.org/v2/everything?q=covid19&apiKey=24402ddd2ca644e8b12ef256927ad15c";
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String s = response.body();

        Gson gson = new Gson();
        News covidnews = gson.fromJson(s, News.class);
        StringBuilder s1=new StringBuilder();

        for (int i = 0; i < covidnews.getArticles().size(); i++) {
            s1.append("TITLE : \n"+covidnews.getArticles().get(i).getTitle()+"\n");
            s1.append("Description :  \n"+covidnews.getArticles().get(i).getDescription()+"\n");
            s1.append("----------------------------------------------------------------------------------------------\n\n");
        }
        return s1.toString();
    }

}
