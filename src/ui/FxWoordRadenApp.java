package ui;

import domain.Speler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class FxWoordRadenApp extends Application {


    @Override
    public void start(Stage primaryStage) {
        TextField invoerNaam = new  TextField("Geef je naam");
        GridPane root = new GridPane();
        Scene scene = new Scene(root,300,200);

        primaryStage.setScene(scene);
        root.add(invoerNaam,0,0);
        invoerNaam.setOnAction(eventIngaveNaam -> {
            primaryStage.setTitle(invoerNaam.getText());
            root.getChildren().clear();
            try {
                new WoordRadenApp(root, new Speler(invoerNaam.getText()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
