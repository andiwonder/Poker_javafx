package customControl.bettingControl;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BettingControl extends FlowPane implements Initializable {

    public BettingControl(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("betting_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
