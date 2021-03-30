package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxCirkelApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 500,300);

        new CirkelApp(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Cirkel App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

