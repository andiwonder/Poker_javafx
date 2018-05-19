package customControl;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class CustomControl extends VBox {
    @FXML private TextField textField;
    @FXML private Circle avatar;

    public CustomControl(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("custom_control2.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            textField.setText("Hello");
            Image image = new Image("avatar8.png");
            avatar.setFill(new ImagePattern(image));
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    @FXML
    protected void doSomething() {
        System.out.println("The button was clicked!");
    }
}
