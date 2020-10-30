package models;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class Getnews {
    private String title;
    private String description;
    private RadioButton rdbtn;



    public Getnews() {
    }

    public Getnews(String title, String description) {

        this.title = title;
        this.description = description;
        this.rdbtn=new RadioButton();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  RadioButton getButton(){return this.rdbtn;}

    public void setButton(RadioButton rdbtn){this.rdbtn=rdbtn;}


}
