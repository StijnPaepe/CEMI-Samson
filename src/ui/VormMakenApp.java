package ui;

import domain.Tekening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class VormMakenApp {
    private ComboBox<String> keuzeMenu;
    private ObservableList<String> mogelijkeFiguren;

    public VormMakenApp(GridPane root, Tekening tekening) {
        mogelijkeFiguren = FXCollections.observableArrayList("Cirkel","Rechthoek","Lijnstuk","Driehoek");
        keuzeMenu = new ComboBox(mogelijkeFiguren);

        root.add(keuzeMenu,0,1);
        keuzeMenu.setOnAction(eventKeuze -> {
                    if (keuzeMenu.getValue() != null) {
                        switch (keuzeMenu.getValue()) {
                            case "Cirkel" -> new CirkelApp(root, tekening);
                            case "Rechthoek" -> new RechthoekApp(root, tekening);
                            case "Lijnstuk" -> new LijnstukApp(root, tekening);
                            case "Driehoek" -> new DriehoekApp(root, tekening);
                        }
                        root.getChildren().remove(keuzeMenu);
                    }
                }

        );}

}
