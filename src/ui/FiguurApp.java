package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import ui.CirkelApp;
import ui.DriehoekApp;
import ui.LijnstukApp;
import ui.RechthoekApp;

public class FiguurApp {
    private ComboBox<String> keuzeMenu;
    private ObservableList<String> mogelijkeFiguren;

    public FiguurApp(GridPane root) {
        mogelijkeFiguren = FXCollections.observableArrayList("Cirkel","Rechthoek", "Driehoek", "Lijnstuk");
        keuzeMenu = new ComboBox(mogelijkeFiguren);
        root.add(keuzeMenu,0,0);
        keuzeMenu.setOnAction(eventKeuze -> {
            keuzeMenu.setVisible(false);
            if (keuzeMenu.getValue()!=null){
                if (keuzeMenu.getValue().equals("Cirkel")) {
                    new CirkelApp(root);
                } else if (keuzeMenu.getValue().equals("Rechthoek")) {
                    new RechthoekApp(root);
                }
                else if (keuzeMenu.getValue().equals("Driehoek")) {
                    new DriehoekApp(root);
                }
                else if (keuzeMenu.getValue().equals("Lijnstuk")) {
                    new LijnstukApp(root);
                }
            }
        });
    }
}