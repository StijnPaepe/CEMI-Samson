package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class FiguurApp {
    private final ComboBox<String> keuzeMenu;
    private final ObservableList<String> mogelijkeFiguren;

    public FiguurApp(GridPane root) {
        mogelijkeFiguren = FXCollections.observableArrayList("Cirkel","Rechthoek", "Driehoek", "Lijnstuk");
        keuzeMenu = new ComboBox(mogelijkeFiguren);
        root.add(keuzeMenu,0,0);
        keuzeMenu.setOnAction(eventKeuze -> {
            keuzeMenu.setVisible(false);
            if (keuzeMenu.getValue()!=null){
                switch (keuzeMenu.getValue()) {
                    case "Cirkel" -> new CirkelApp(root);
                    case "Rechthoek" -> new RechthoekApp(root);
                    case "Driehoek" -> new DriehoekApp(root);
                    case "Lijnstuk" -> new LijnstukApp(root);
                }
            }
        });
    }
}