package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnstukApp {
    private Label invoerStartXLabel, invoerStartYLabel, invoerEindXLabel, invoerEindYLabel;
    private TextField invoerStartX, invoerStartY, invoerEindX, invoerEindY;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Vorm vorm;

    public LijnstukApp(GridPane root) {
        init(root, 0);
        invoerEindY.setOnAction(eventIngaveY -> {
            try {
                Punt start = new Punt(Integer.parseInt(invoerStartX.getText()), Integer.parseInt(invoerStartY.getText()));
                Punt eind = new Punt(Integer.parseInt(invoerEindX.getText()), Integer.parseInt(invoerEindY.getText()));
                vorm = new LijnStuk(start, eind);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.add(uitvoer, 0, 0);
            } catch(NumberFormatException e){

                invoerEindY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }

    public LijnstukApp(GridPane root, Tekening tekening) {
        init(root,1);
        invoerEindY.setOnAction(eventIngaveEindY -> {
            try {
                Punt start = new Punt(Integer.parseInt(invoerStartX.getText()), Integer.parseInt(invoerStartY.getText()));
                Punt eind = new Punt(Integer.parseInt(invoerEindX.getText()), Integer.parseInt(invoerEindY.getText()));
                vorm = new LijnStuk(start, eind);
                tekening.voegToe(vorm);
                cleanUp(root);
            } catch (DomainException e){
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(invoerStartXLabel);
        root.getChildren().remove(invoerStartX);
        root.getChildren().remove(invoerStartYLabel);
        root.getChildren().remove(invoerStartY);
        root.getChildren().remove(invoerEindXLabel);
        root.getChildren().remove(invoerEindX);
        root.getChildren().remove(invoerEindYLabel);
        root.getChildren().remove(invoerEindY);
    }

    private void init(GridPane root, int teller){
        invoerStartXLabel =  new Label("Geef de x-coordinaat van het startpunt ");
        invoerStartX= new TextField();
        invoerStartYLabel = new Label("Geef de y-coordinaat van het startpunt ");
        invoerStartY = new TextField();
        invoerEindXLabel =  new Label("Geef de x-coordinaat van het eindpunt ");
        invoerEindX= new TextField();
        invoerEindYLabel = new Label("Geef de y-coordinaat van het eindpunt ");
        invoerEindY = new TextField();

        root.add(invoerStartXLabel,0,teller);
        root.add(invoerStartX,1,teller);

        invoerStartX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerStartX.getText());
                root.add(invoerStartYLabel, 0, teller + 1);
                root.add(invoerStartY, 1, teller + 1);
            }
            catch(NumberFormatException e){
                invoerStartX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerStartY.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerStartY.getText());
                root.add(invoerEindXLabel, 0, teller + 2);
                root.add(invoerEindX, 1, teller + 2);
            }
            catch(NumberFormatException e){
                invoerStartY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerEindX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerEindX.getText());
                root.add(invoerEindYLabel, 0, teller + 3);
                root.add(invoerEindY, 1, teller + 3);
            }
            catch(NumberFormatException e){
                invoerEindX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }
}