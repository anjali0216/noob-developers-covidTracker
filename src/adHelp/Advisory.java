package adHelp;

//importing package to include hyperlinks
import javafx.scene.control.Hyperlink;

public class Advisory {//class corresponding to table of advisory dispaly in advisoriespage class
    private int sno;//memebers of class
    private String title;
    private Hyperlink link;

    //parametrized constructor for the class
    public Advisory(int sno, String title, Hyperlink link) {
        this.sno = sno;
        this.title = title;
        this.link = link;
    }
    //getter methods
    public int getSno() {
        return sno;
    }

    public String getTitle() {
        return title;
    }

    public Hyperlink getLink() {
        return link;
    }
    //setter methods
    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(Hyperlink link) {
        this.link = link;
    }
}//end of class
