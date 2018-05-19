package start;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class MainController {

    @FXML private Circle avatarCircle;

    @FXML private Rectangle cardone;
    @FXML private Rectangle cardtwo;
    @FXML private Rectangle cardthree;
    @FXML private Rectangle card4;
    @FXML private Rectangle card5;


    @FXML
    public void initialize() {
        Image img = new Image("1.png");
        cardone.setFill(new ImagePattern(img));
        Image imgtwo = new Image("13.png");
        cardtwo.setFill(new ImagePattern(imgtwo));
        Image imgthree = new Image("6.png");
        cardthree.setFill(new ImagePattern(imgthree));
        Image img4 = new Image("22.png");
        card4.setFill(new ImagePattern(img4));
        Image img5 = new Image("42.png");
        card5.setFill(new ImagePattern(img5));
    }
}
