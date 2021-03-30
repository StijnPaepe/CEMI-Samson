package ui;

import domain.LijnStuk;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnstukApp {
    private Label invoerStartXLabel, invoerStartYLabel, invoerEindXLabel, invoerEindYLabel;
    private TextField invoerStartX, invoerStartY, invoerEindX, invoerEindY;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt start, eind;
    private LijnStuk lijnstuk;

    public LijnstukApp(GridPane root) {
        invoerStartXLabel =  new Label("Geef de x-coordinaat van het startpunt ");
        invoerStartX= new TextField();
        invoerStartYLabel = new Label("Geef de y-coordinaat van het startpunt ");
        invoerStartY = new TextField();
        invoerEindXLabel =  new Label("Geef de x-coordinaat van het eindpunt ");
        invoerEindX= new TextField();
        invoerEindYLabel = new Label("Geef de y-coordinaat van het eindpunt ");
        invoerEindY = new TextField();

        root.add(invoerStartXLabel,0,0);
        root.add(invoerStartX,1,0);

        invoerStartX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerStartX.getText());
                root.add(invoerStartYLabel, 0, 1);
                root.add(invoerStartY, 1, 1);
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
                root.add(invoerEindXLabel, 0, 1);
                root.add(invoerEindX, 1, 1);
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
                root.add(invoerEindYLabel, 0, 1);
                root.add(invoerEindY, 1, 1);
            }
            catch(NumberFormatException e){
                invoerEindX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerEindY.setOnAction(eventIngaveY -> {
            try {
                start = new Punt(Integer.parseInt(invoerStartX.getText()), Integer.parseInt(invoerStartY.getText()));
                eind = new Punt(Integer.parseInt(invoerEindX.getText()), Integer.parseInt(invoerEindY.getText()));
                lijnstuk = new LijnStuk(start, eind);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(lijnstuk.toString());
                root.add(uitvoer, 0, 0);
            } catch(NumberFormatException e){

                invoerEindY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }
}