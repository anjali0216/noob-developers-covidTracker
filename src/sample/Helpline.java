package sample;

public class Helpline {
    int sno;
    String loc,cno;

    public Helpline(int sno, String loc, String cno) {
        this.sno = sno;
        this.loc = loc;
        this.cno = cno;
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

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }
}