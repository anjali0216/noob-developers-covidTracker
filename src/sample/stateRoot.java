package sample;
import java.util.List;

public class stateRoot{
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


