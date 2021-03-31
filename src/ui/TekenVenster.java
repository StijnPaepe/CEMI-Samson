package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import domain.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.*;


public class TekenVenster {
    private Label naamTekeningLabel;
    private TextField invoerNaamTekening;
    private TextArea uitvoer;

    private ComboBox<String> keuzeMenu;
    private ObservableList<String> opties;
    private Tekening tekening;

    public TekenVenster(GridPane root, Tekening tekening){
        if (tekening == null) throw new UiException();
        this.tekening = tekening;
        this.teken(root, tekening);
    }

    public void teken(GridPane root, Tekening tekening) {
        uitvoer = new TextArea();
        naamTekeningLabel = new Label("Geef de naam van je tekening: ");
        invoerNaamTekening = new TextField();

        opties = FXCollections.observableArrayList("Vorm maken","Tekening tonen","stop","");
        keuzeMenu = new ComboBox<>(opties);

        root.add(keuzeMenu,0,0);
        root.add(uitvoer, 3, 0);

        keuzeMenu.setOnAction(eventKeuze -> {
            uitvoer.setVisible(false);
            if (keuzeMenu.getValue() != null) {
                switch (keuzeMenu.getValue()) {
                    case "Vorm maken":
                        keuzeMenu.setValue("");
                        new VormMakenApp(root, tekening);
                        break;
                    case "Tekening tonen":
                        tekening.teken(root);
                        break;
                    case "stop":
                        break;
                }

            }
        });
    }

    public void toonWaarschuwing(String s){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Waarschuwing");
        alert.setContentText(s);
        alert.showAndWait();
    }
}
