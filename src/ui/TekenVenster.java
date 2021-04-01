package ui;

import domain.Tekening;
import javafx.scene.layout.GridPane;

public class TekenVenster {
    public TekenVenster(GridPane root, Tekening tekening){
        if (tekening == null) throw new UiException();
        this.teken(root, tekening);
    }

    public void teken(GridPane root, Tekening tekening) {
        tekening.teken(root);
    }
}
