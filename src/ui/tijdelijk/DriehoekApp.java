package ui.tijdelijk;

import domain.Driehoek;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {
    private Label invoerHoek1XLabel, invoerHoek1YLabel, invoerHoek2XLabel, invoerHoek2YLabel, invoerHoek3XLabel, invoerHoek3YLabel;
    private TextField invoerHoek1X, invoerHoek1Y, invoerHoek2X, invoerHoek2Y, invoerHoek3X, invoerHoek3Y;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt hoek1, hoek2, hoek3;
    private Driehoek driehoek;

    public DriehoekApp(GridPane root) {
        invoerHoek1XLabel =  new Label("Geef de x-coordinaat van het eerste punt ");
        invoerHoek1X= new TextField();
        invoerHoek1YLabel = new Label("Geef de y-coordinaat van het eerste punt ");
        invoerHoek1Y = new TextField();
        invoerHoek2XLabel =  new Label("Geef de x-coordinaat van het eerste punt ");
        invoerHoek2X= new TextField();
        invoerHoek2YLabel = new Label("Geef de y-coordinaat van het eerste punt ");
        invoerHoek2Y = new TextField();
        invoerHoek3XLabel =  new Label("Geef de x-coordinaat van het eerste punt ");
        invoerHoek3X= new TextField();
        invoerHoek3YLabel = new Label("Geef de y-coordinaat van het eerste punt ");
        invoerHoek3Y = new TextField();

        root.add(invoerHoek1XLabel,0,0);
        root.add(invoerHoek1X,1,0);

        invoerHoek1X.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerHoek1X.getText());
                root.add(invoerHoek1YLabel, 0, 1);
                root.add(invoerHoek1Y, 1, 1);
            }
            catch(NumberFormatException e){
                invoerHoek1X.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoek1Y.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerHoek1Y.getText());
                root.add(invoerHoek2XLabel, 0, 2);
                root.add(invoerHoek2X, 1, 2);
            }
            catch(NumberFormatException e){
                invoerHoek1Y.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoek2X.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerHoek2X.getText());
                root.add(invoerHoek2YLabel, 0, 3);
                root.add(invoerHoek2Y, 1, 3);
            }
            catch(NumberFormatException e){
                invoerHoek2X.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoek2Y.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerHoek2Y.getText());
                root.add(invoerHoek3XLabel, 0, 4);
                root.add(invoerHoek3X, 1, 4);
            }
            catch(NumberFormatException e){
                invoerHoek2Y.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoek3X.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerHoek3X.getText());
                root.add(invoerHoek3YLabel, 0, 5);
                root.add(invoerHoek3Y, 1, 5);
            }
            catch(NumberFormatException e){
                invoerHoek3X.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoek3Y.setOnAction(eventIngaveY -> {
            try {
                hoek1 = new Punt(Integer.parseInt(invoerHoek1X.getText()), Integer.parseInt(invoerHoek1Y.getText()));
                hoek2 = new Punt(Integer.parseInt(invoerHoek2X.getText()), Integer.parseInt(invoerHoek2Y.getText()));
                hoek3 = new Punt(Integer.parseInt(invoerHoek3X.getText()), Integer.parseInt(invoerHoek3Y.getText()));
                driehoek = new Driehoek(hoek1, hoek2, hoek3);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(driehoek.toString());
                root.add(uitvoer, 0, 0);
            } catch(NumberFormatException e){

                invoerHoek3Y.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }
}
