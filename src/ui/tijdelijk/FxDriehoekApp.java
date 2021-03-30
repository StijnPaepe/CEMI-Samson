package ui.tijdelijk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ui.tijdelijk.DriehoekApp;

public class FxDriehoekApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 500,300);

        new DriehoekApp(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Driehoek App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

