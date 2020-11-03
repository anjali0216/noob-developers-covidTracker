package statFiles;


//a class that designs a framework to display the country-wise stats in a table
public class World {
    private int sno;
    private String country;
    private String cases,active,recovered,critical,deaths;
//parametrized constructor
    public World(int sno, String country, String cases, String active, String recovered, String critical, String deaths) {
        this.sno = sno;
        this.country = country;
        this.cases = cases;
        this.active = active;
        this.recovered = recovered;
        this.critical = critical;
        this.deaths = deaths;
    }
//getter functions
    public int getSno() {
        return sno;
    }

    public String getCountry() {
        return country;
    }

    public String getCases() {
        return cases;
    }

    public String getActive() {
        return active;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getCritical() {
        return critical;
    }

    public String getDeaths() {
        return deaths;
    }
//setter functions
    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}
