package customControl.playerDisplay;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerDisplay extends StackPane implements Initializable {

    @FXML private ImageView useremoji;

    private String playerID;


    public PlayerDisplay(String playerID){
        this.playerID = playerID;
        StringBuilder fmlsource = new StringBuilder("player_display_");
        fmlsource.append(playerID).append(".fxml");
        String source = fmlsource.toString();
        System.out.println("Adding to display: " + source);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(source));
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
        String source = "avatar" + this.playerID + ".png";
        Image avatar = new Image(getClass().getClassLoader().getResource(source).toString(), true);
        useremoji.setImage(avatar);
    }

    private void setAvatar(){
//        Image image = new Image(getClass().getResource("avatar1.png").toExternalForm());
//        useremoji.setImage(image);
    }
}