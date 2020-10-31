package adHelp;

import javafx.scene.control.Hyperlink;

public class Advisory {
    int sno;
    String title;
    Hyperlink link;


    public Advisory(int sno, String title, Hyperlink link) {
        this.sno = sno;
        this.title = title;
        this.link = link;
    }

    public int getSno() {
        return sno;
    }

    public String getTitle() {
        return title;
    }

    public Hyperlink getLink() {
        return link;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(Hyperlink link) {
        this.link = link;
    }
}
