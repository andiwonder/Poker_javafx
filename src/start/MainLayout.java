package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainLayout extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent scene = FXMLLoader.load(getClass().getResource("test4.fxml"));
        primaryStage.setTitle("Skasliwal Poker");
        primaryStage.setScene(new Scene(scene));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}

//-fx-background-image: url("/images/background.png");