package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

public class Cirkel extends Vorm implements Drawable {
    private Punt middelpunt;
    private int radius;

    public void setMiddelpunt(Punt middelpunt) {
        if (middelpunt == null) throw new DomainException("Middelpunt mag niet null zijn.");
        this.middelpunt = middelpunt;
    }

    public void setRadius(int radius) {
        if (radius <= 0) throw new DomainException("Straal moet positief zijn.");
        this.radius = radius;
    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }

    public int getRadius() {
        return radius;
    }

    public Cirkel(Punt middelpunt, int radius) {
        setMiddelpunt(middelpunt);
        setRadius(radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cirkel cirkel = (Cirkel) o;
        return radius == cirkel.radius && middelpunt.equals(cirkel.getMiddelpunt());
    }

    @Override
    public String toString() {
        return "Cirkel: middelpunt: " + middelpunt.toString() + " - straal: " + radius + super.toString();
    }

    @Override
    public Omhullende getOmhullende() {
        Punt linkerbovenhoek = new Punt(getMiddelpunt().getX() - getRadius(), getMiddelpunt().getY() + getRadius());
        return new Omhullende(linkerbovenhoek, getRadius() * 2, getRadius() * 2);
    }

    @Override
    public void teken(Pane root) {
        Circle nieuw = new Circle(getMiddelpunt().getX(), getMiddelpunt().getY(), getRadius());
        nieuw.setFill(Color.WHITE);
        nieuw.setStroke(Color.BLACK);
        root.getChildren().addAll(nieuw);
    }
}
