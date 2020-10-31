package statFiles;
import java.util.List;

//a class which designs the framework of a similar type to that of the api from which the data is being stored

public class stateRoot{
    private boolean success;
    public Data data;
    private  String lastRefreshed;
    private String lastOriginUpdate;
}

class Summary{
     int total;
     int confirmedCasesIndian;
     int confirmedCasesForeign;
     int discharged;
     int confirmedButLocationUnidentified;
     int deaths;
     int confirmedButLocationunidentified;
}

class UnofficialSummary{
     String source;
    int total;
     int recovered;
    int active;
}

class Regional{
     String loc;
     int confirmedCasesIndian;
     int confirmedCasesForeign;
     int discharged;
     int totalConfirmed;
     int deaths;

    public Regional(String loc,int confirmedCasesForeign,int confirmedCasesIndian,int discharged,int deaths,int totalConfirmed) {
        this.loc = loc;
        this.confirmedCasesForeign=confirmedCasesForeign;
        this.confirmedCasesIndian=confirmedCasesIndian;
        this.discharged=discharged;
        this.totalConfirmed=totalConfirmed;
        this.deaths=deaths;
    }
}

class Data{
    Summary summary;
     List<UnofficialSummary> unofficial_summary;
     List<Regional> regional;


}


