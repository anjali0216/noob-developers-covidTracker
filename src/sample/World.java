package sample;

public class World {
    int sno;
    String country;
    long cases,active,recovered,critical,deaths;
    public World(int sno, String country, long cases, long active, long recovered, long critical, long deaths) {
        this.sno = sno;
        this.country = country;
        this.cases = cases;
        this.active = active;
        this.recovered = recovered;
        this.critical = critical;
        this.deaths = deaths;
    }

    public int getSno() {
        return sno;
    }

    public String getCountry() {
        return country;
    }

    public long getCases() {
        return cases;
    }

    public long getActive() {
        return active;
    }

    public long getRecovered() {
        return recovered;
    }

    public long getCritical() {
        return critical;
    }

    public long getDeaths() {
        return deaths;
    }



    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public void setCritical(long critical) {
        this.critical = critical;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }
}
