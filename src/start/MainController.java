package start;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
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
    }
}
