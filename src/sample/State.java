package sample;

public class State {
    int sno;
    String loc,totalConfirmed,discharged,deaths;

    public State(int sno, String loc, String totalConfirmed, String discharged, String deaths) {
        this.sno = sno;
        this.loc = loc;
        this.totalConfirmed = totalConfirmed;
        this.discharged = discharged;
        this.deaths = deaths;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public String getDischarged() {
        return discharged;
    }

    public void setDischarged(String discharged) {
        this.discharged = discharged;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}
