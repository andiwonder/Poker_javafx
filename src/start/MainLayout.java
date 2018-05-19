package start;

import customControl.CustomControl;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class MainLayout extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//        StackPane root = new StackPane();
//        root.setId("pane");

//        CustomControl customControl = new CustomControl();
//        primaryStage.setScene(new Scene(customControl));
//        primaryStage.setTitle("Custom Control");
//        primaryStage.setWidth(300);
//        primaryStage.setHeight(200);
//        primaryStage.show();

        //        scene.getStylesheets().addAll(this.getClass().getResource("styles/style.css").toExternalForm());
        Parent scene = FXMLLoader.load(getClass().getResource("test3.fxml"));
        primaryStage.setTitle("Skasliwal Poker");
        primaryStage.setScene(new Scene(scene));
        primaryStage.setResizable(false);
        primaryStage.show();


    }
}

//-fx-background-image: url("/images/background.png");