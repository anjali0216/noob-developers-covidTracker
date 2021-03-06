package statFiles;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//a class to display the total stats for india and world
class totalcase{

    //function to display the overall stats for india
    String displaytotal(){
        String stats="";
        boolean found=false;
        File file=new File(driver.getInstance().path+"\\stateStats.txt");
        try {
            Scanner sc=new Scanner(file);
            String inLine;
            StringBuilder data=new StringBuilder();
            while(sc.hasNext()){
                data.append(sc.nextLine());
            }
            inLine= data.toString();

            var gson = new Gson();

            stateRoot root = gson.fromJson(inLine, stateRoot.class);

                    int confTotal1 = root.data.summary.total;
                    int confIndian1 = root.data.summary.confirmedCasesIndian;
                    int confForeign1 = root.data.summary.confirmedCasesForeign;
                    int recovered1 = root.data.summary.discharged;
                    int deaths1 = root.data.summary.deaths;
                 int confUnidentified1 = root.data.summary.confirmedButLocationunidentified;
                    stats="\nTotal Confirmed: "+confTotal1+"\n"+"Confirmed Cases(Indian): "+confIndian1+"\n"+"Confirmed Cases(Foreign): "+confForeign1+"\n" +
                            "Recovered: "+recovered1+"\nDeaths: "+deaths1+"\nConfirmedButLocationUnidentified: "+confUnidentified1 ;

        } catch (FileNotFoundException e) {
            driver.getInstance().displayDialog("Something went wrong. Refresh, and try again!");
        }
        return stats;
    }

    //function to display the overall stats for world
    String displayworldtotal() throws FileNotFoundException, ParseException {
        String inLine = "";
        String stats2="";
        inLine = driver.getInstance().JsonToString(driver.getInstance().path + "\\worldStats.txt");
        JSONParser parse = new JSONParser();//parsing json data

        JSONArray arr1 = (JSONArray) parse.parse(inLine);
        JSONObject jsonobj = (JSONObject) arr1.get(0);
        long totalcase=(long)jsonobj.get("cases");
        long totalactive=(long)jsonobj.get("active");
        long totalrecovered=(long)jsonobj.get("recovered");
        long totalcritical=(long)jsonobj.get("critical");
        long totaldeaths=(long)jsonobj.get("deaths");
        stats2="\nTotal Confirmed Cases:\t"+totalcase+"\n"+"Total active Cases:\t"+totalactive+"\n"+"Total Recovered Cases:\t"+totalrecovered+"\n" +
                "Total Critical Cases:\t"+totalcritical+"\nTotal Death Cases:\t"+totaldeaths;
        return  stats2;
    }


}
