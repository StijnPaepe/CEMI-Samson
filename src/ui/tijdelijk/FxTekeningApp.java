package ui.tijdelijk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxTekeningApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);
        new TekeningApp(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Almost hangman :) ");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}