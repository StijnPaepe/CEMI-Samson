package ui;

import domain.Tekening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


public class TekenVenster {
    private TextArea uitvoer;

    private ComboBox<String> keuzeMenu;
    private ObservableList<String> opties;

    public TekenVenster(GridPane root, Tekening tekening){
        if (tekening == null) throw new UiException();
        this.teken(root, tekening);
    }

    public void teken(GridPane root, Tekening tekening) {
        uitvoer = new TextArea();

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
}
