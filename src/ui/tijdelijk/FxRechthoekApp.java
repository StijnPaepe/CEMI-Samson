package ui.tijdelijk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ui.tijdelijk.RechthoekApp;

public class FxRechthoekApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 500,300);

        new RechthoekApp(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rechthoek App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

