package ui;

import domain.Tekening;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxTekenVenster extends Application {

    private TextField invoerNaam;

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root,400,400);
        invoerNaam = new TextField("Geef de naam van de tekening");
        root.getChildren().add(invoerNaam);

        primaryStage.setScene(scene);

        invoerNaam.setOnAction( eventIngaveNaam -> {
            primaryStage.setTitle(invoerNaam.getText());
            root.getChildren().clear();
            new TekenVenster(root, new Tekening(invoerNaam.getText()));});
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}