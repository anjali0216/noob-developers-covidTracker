package sample;


//a class that designs the framework to display the district-wise stats of a particular state in a table
public class District {
    int sno;
    String district,confirmed,active,recovered,deceased;

    public District(int sno, String district, String confirmed, String active, String recovered, String deceased) {
        this.sno = sno;
        this.district = district;
        this.confirmed = confirmed;
        this.active = active;
        this.recovered = recovered;
        this.deceased = deceased;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }
}
