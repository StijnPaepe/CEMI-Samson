package ui.tijdelijk;

import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RechthoekApp {
    private Label invoerXLabel, invoerYLabel, invoerBreedteLabel, invoerHoogteLabel;
    private TextField invoerX, invoerY, invoerBreedte, invoerHoogte;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt linkerbovenhoek;
    private Rechthoek rechthoek;

    public RechthoekApp(GridPane root) {
        init(root, 0);
        invoerXLabel =  new Label("Geef de x-coördinaat van de linkerbovenhoek van de rechthoek ");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coördinaat van de linkerbovenhoek van de rechthoek ");
        invoerY = new TextField();
        invoerBreedteLabel =  new Label("Geef de breedte van de rechthoek ");
        invoerBreedte= new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek ");
        invoerHoogte = new TextField();

        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);

        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY ->{
            try {
                Integer.parseInt(invoerY.getText());
                root.add(invoerBreedteLabel, 0, 2);
                root.add(invoerBreedte, 1, 2);
            }
            catch(NumberFormatException e){
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerBreedte.setOnAction(eventIngaveBreedte ->{
            try {
                Integer.parseInt(invoerBreedte.getText());
                root.add(invoerHoogteLabel, 0, 3);
                root.add(invoerHoogte, 1, 3);
            }
            catch(DomainException e){
                invoerBreedte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });

        invoerHoogte.setOnAction(eventIngaveHoogte -> {
            try {
                linkerbovenhoek = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                rechthoek = new Rechthoek(linkerbovenhoek, Integer.parseInt(invoerBreedte.getText()), Integer.parseInt(invoerHoogte.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(rechthoek.toString());
                root.add(uitvoer, 0, 0);
            } catch(DomainException e){
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    private void init(GridPane root, int i) {
    }

    private void cleanUp(GridPane root) {

    }

    public RechthoekApp(GridPane root, Tekening tekening) {
       init(root, 1);
       invoerHoogte.setOnAction(eventIngaveHoogte -> {
           try {
               Punt linkerbovenhoek = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
               rechthoek = new Rechthoek(linkerbovenhoek, Integer.parseInt(invoerBreedte.getText()), Integer.parseInt(invoerHoogte.getText()));
               tekening.voegToe(rechthoek);
               cleanUp(root);

           } catch (NumberFormatException ne){
               invoerBreedte.clear();
               invoerHoogte.clear();

               foutenboodschap.setTitle("Warning");
               foutenboodschap.setContentText("breedte en hoogte moet een geheel getal zijn");
               foutenboodschap.showAndWait();
           }
           catch (DomainException e){
               cleanUp(root);
               foutenboodschap.setTitle("Warning");
               foutenboodschap.setHeaderText(null);
               foutenboodschap.setContentText(e.getMessage());
               foutenboodschap.showAndWait();
           }
       });
    }
}
