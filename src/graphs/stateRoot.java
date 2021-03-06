package graphs;
import java.util.List;

//a class which designs the framework of a similar type to that of the api from which the data is being stored

class stateRoot{
    public boolean success;
    public Data data;
    public  String lastRefreshed;
    public  String lastOriginUpdate;
}

class Summary{
    public int total;
    public int confirmedCasesIndian;
    public int confirmedCasesForeign;
    public int discharged;
    public int confirmedButLocationUnidentified;
    public int deaths;
    public int confirmedButLocationunidentified;
}

class UnofficialSummary{
    public String source;
    public int total;
    public int recovered;
    public int active;
}

class Regional{
    public String loc;
    public int confirmedCasesIndian;
    public int confirmedCasesForeign;
    public int discharged;
    public int totalConfirmed;
    public int deaths;

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
    public Summary summary;
    public List<UnofficialSummary> unofficial_summary;
    public List<Regional> regional;


}


