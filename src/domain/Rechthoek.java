package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rechthoek extends Vorm implements Drawable {
    private final int breedte;
    private final int hoogte;
    private final Punt linkerBovenHoek;

    public Rechthoek(Punt linkerBovenHoek, int breedte, int hoogte) {
        if (linkerBovenHoek == null) throw new DomainException("linkerbovenhoek mag niet null zijn");
        if (breedte <= 0 || hoogte <= 0) throw new DomainException("breedte en hoogte moeten groter dan 0 zijn");
        this.linkerBovenHoek = linkerBovenHoek;
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenHoek;
    }

    public Omhullende getOmhullende() {
         return new Omhullende(getLinkerBovenhoek(), getBreedte(), getHoogte());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rechthoek rechthoek = (Rechthoek) o;
        return breedte == rechthoek.breedte && hoogte == rechthoek.hoogte && linkerBovenHoek.equals(rechthoek.getLinkerBovenhoek());
    }

    @Override
    public String toString() {
        return "Rechthoek: linkerbovenhoek: " + getLinkerBovenhoek().toString() + " - breedte: " + getBreedte() + " - hoogte: " + getHoogte() + super.toString();
    }

    @Override
    public void teken(Pane root) {
        Rectangle rectangle = new Rectangle(getLinkerBovenhoek().getX(), getLinkerBovenhoek().getY(), getBreedte(), getHoogte());
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        root.getChildren().addAll(rectangle);
    }
}
