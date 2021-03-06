package adHelp;

public class Helpline {//class corresponding to the table view of helplines in helplinepage
    private int sno;//members of class
    private String loc,cno;//string location(state) and corresponding contact number

    public Helpline(int sno, String loc, String cno) {              //constructor for class
        this.sno = sno;
        this.loc = loc;
        this.cno = cno;
    }
    //getter methods
    public int getSno() {
        return sno;
    }
    //setter methods
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
}//end of class}