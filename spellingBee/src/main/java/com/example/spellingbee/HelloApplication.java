package com.example.spellingbee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        SpellingBee sb = new SpellingBee();
        Scene scene = new Scene(sb, 600, 400);
        sb.setStyle("-fx-background-color:\n" +
                "            white,\n" +
                "            #b5b5b5,\n" +
                "            linear-gradient(#fdfdfd, #e1e1e1),\n" +
                "            linear-gradient(#eeeeee, #d9d9d9);");
        stage.setTitle("Spelling Bee");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}