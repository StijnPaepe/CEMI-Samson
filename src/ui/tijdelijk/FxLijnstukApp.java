package ui.tijdelijk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ui.tijdelijk.LijnstukApp;

public class FxLijnstukApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 300,50);

        new LijnstukApp(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Lijnstuk App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

