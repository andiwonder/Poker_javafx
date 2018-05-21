package start;

import customControl.playerDisplay.PlayerDisplay;
import customControl.bettingControl.BettingControl;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class MainController {

    @FXML private Circle avatarCircle;

    @FXML private Rectangle card1;
    @FXML private Rectangle card2;
    @FXML private Rectangle card3;
    @FXML private Rectangle card4;
    @FXML private Rectangle card5;

    @FXML private GridPane playergridpane;
    @FXML private GridPane bettingpane;



    @FXML
    public void initialize() {
        Image img = new Image("1.png");
        card1.setFill(new ImagePattern(img));
        Image img2 = new Image("13.png");
        card2.setFill(new ImagePattern(img2));
        Image img3 = new Image("6.png");
        card3.setFill(new ImagePattern(img3));
        Image img4 = new Image("22.png");
        card4.setFill(new ImagePattern(img4));
        Image img5 = new Image("42.png");
        card5.setFill(new ImagePattern(img5));

        PlayerDisplay display_player_1 = new PlayerDisplay("1");
        PlayerDisplay display_player_2 = new PlayerDisplay("2");
        PlayerDisplay display_player_3 = new PlayerDisplay("3");
        PlayerDisplay display_player_4 = new PlayerDisplay("4");
        PlayerDisplay display_player_5 = new PlayerDisplay("5");
        playergridpane.getChildren().add(display_player_1);
        playergridpane.getChildren().add(display_player_2);
        playergridpane.getChildren().add(display_player_3);
        playergridpane.getChildren().add(display_player_4);
        playergridpane.getChildren().add(display_player_5);

        BettingControl newControl = new BettingControl();
        bettingpane.getChildren().add(newControl);

    }

}
