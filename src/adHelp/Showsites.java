package adHelp;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
//class that displays the urls for covid-19
public class Showsites {
    public SplitPane splitpane;
    public AnchorPane anchorpane1;
    public AnchorPane anchorpane2;
    public Label labelhead1;
    public Label WHOlabel;
    public Label helplabel;
    public Label label3;
    public Label mygovlabel;
    public Label label2;

    public Button whobutton;
    public Button mygovbutton;
    public Button helpline1;
    public Button toibutton;
    public Button htbutton;
    public Button ecobutton;
    public Button worldbutton;
    public Button testbutton;
    public Button homebutton;
    Desktop d=Desktop.getDesktop();
//function that displays the link for who
    public void clickWHO(ActionEvent actionEvent) throws URISyntaxException, IOException {
//to open the link in a new browser
        d.browse(new URI("https://www.who.int/"));
    }
  public void clickmygov(ActionEvent actionEvent) throws URISyntaxException, IOException {

        d.browse(new URI("https://www.mygov.in/covid-19"));
  }
    public void testingcentres(ActionEvent actionEvent) throws URISyntaxException, IOException {

        d.browse(new URI("https://www.firstpost.com/health/looking-coronavirus-test-centres-near-list-private-government-testing-sites-states-union-territories-india-8159111.html"));
    }
    public void helpconsult(ActionEvent actionEvent) throws URISyntaxException, IOException {

        d.browse(new URI("https://www.indiatvnews.com/coronavirus/helpline-numbers"));
    }

    public void toinews(ActionEvent actionEvent) throws URISyntaxException, IOException {

        d.browse(new URI("https://m.timesofindia.com/india/coronabytes.cms"));
    }
    public void htnews(ActionEvent actionEvent) throws URISyntaxException, IOException {

        d.browse(new URI("https://www.who.int/"));
    }
    public void econews(ActionEvent actionEvent) throws URISyntaxException, IOException {

        d.browse(new URI("https://m.economictimes.com/news/coronavirus/newslist/74382222.cms"));
    }

    public void worldnews(ActionEvent actionEvent) throws URISyntaxException, IOException {

        d.browse(new URI("https://covid19.who.int/"));
    }
//function that takes back to the home page
    public void gotohome(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)homebutton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}
