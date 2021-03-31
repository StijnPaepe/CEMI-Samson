package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class Driehoek extends Vorm implements Drawable{
    private Punt hoekpunt1;
    private Punt hoekpunt2;
    private Punt hoekpunt3;

    public Driehoek(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
        if (hoekpunt1 == null) throw new DomainException("Hoekpunt mag niet null zijn.");
        if (hoekpunt2 == null) throw new DomainException("Hoekpunt mag niet null zijn.");
        if (hoekpunt3 == null) throw new DomainException("Hoekpunt mag niet null zijn.");
        if (hoekpunt1.equals(hoekpunt2) || hoekpunt1.equals(hoekpunt3) || hoekpunt2.equals(hoekpunt3)) throw new DomainException("Hoekpunten mogen niet samenvallen");
        if (liggenOp1Lijn(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Hoekpunten mogen niet op één lijn liggen.");
        setHoekpunt1(hoekpunt1);
        setHoekpunt2(hoekpunt2);
        setHoekpunt3(hoekpunt3);
        sorteerHoekpunten();
    }

    public Punt getHoekpunt1() {
        return hoekpunt1;
    }

    public void setHoekpunt1(Punt hoekpunt1) {
        this.hoekpunt1 = hoekpunt1;
    }

    public Punt getHoekpunt2() {
        return hoekpunt2;
    }

    public void setHoekpunt2(Punt hoekpunt2) {
        this.hoekpunt2 = hoekpunt2;
    }

    public Punt getHoekpunt3() {
        return hoekpunt3;
    }

    public void setHoekpunt3(Punt hoekpunt3) {
        this.hoekpunt3 = hoekpunt3;
    }

    private static boolean liggenOp1Lijn(Punt punt1, Punt punt2, Punt punt3) {
        return (punt2.getX() - punt1.getX()) * (punt3.getY() - punt1.getY()) == (punt3.getX() - punt1.getX()) * (punt2.getY() - punt1.getY());
    }

    private void sorteerHoekpunten() {
        Punt[] punten = {getHoekpunt1(), getHoekpunt2(), getHoekpunt3()};
        if (punten[0].compareTo(punten[1]) == 2) {
            Punt kleinste = punten[1];
            punten[1] = punten[0];
            punten[0] = kleinste;
        }
        if (punten[0].compareTo(punten[2]) == 2) {
            Punt kleinste = punten[2];
            punten[2] = punten[0];
            punten[0] = kleinste;
        }
        if (punten[1].compareTo(punten[2]) == 2) {
            Punt kleinste = punten[2];
            punten[2] = punten[1];
            punten[1] = kleinste;
        }
        setHoekpunt1(punten[0]);
        setHoekpunt2(punten[1]);
        setHoekpunt3(punten[2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driehoek driehoek = (Driehoek) o;
        return (getHoekpunt1().equals(driehoek.getHoekpunt1()) && getHoekpunt2().equals(driehoek.getHoekpunt2()) && getHoekpunt3().equals(driehoek.getHoekpunt3()))
                || (getHoekpunt1().equals(driehoek.getHoekpunt2()) && getHoekpunt2().equals(driehoek.getHoekpunt3()) && getHoekpunt3().equals(driehoek.getHoekpunt1()))
                || (getHoekpunt1().equals(driehoek.getHoekpunt2()) && getHoekpunt2().equals(driehoek.getHoekpunt1()) && getHoekpunt3().equals(driehoek.getHoekpunt3()))
                || (getHoekpunt1().equals(driehoek.getHoekpunt1()) && getHoekpunt2().equals(driehoek.getHoekpunt3()) && getHoekpunt3().equals(driehoek.getHoekpunt2()))
                || (getHoekpunt1().equals(driehoek.getHoekpunt3()) && getHoekpunt2().equals(driehoek.getHoekpunt1()) && getHoekpunt3().equals(driehoek.getHoekpunt2()))
                || (getHoekpunt1().equals(driehoek.getHoekpunt3()) && getHoekpunt2().equals(driehoek.getHoekpunt2()) && getHoekpunt3().equals(driehoek.getHoekpunt1()));
    }

    @Override
    public String toString() {
        return "Driehoek: hoekpunt1: " + hoekpunt1.toString() + " - hoekpunt2: " + hoekpunt2.toString() + " - hoekpunt3: " + hoekpunt3.toString() + super.toString();
    }

    @Override
    public Omhullende getOmhullende() {
        int grootsteX, grootsteY, kleinsteX, kleinsteY;
        kleinsteX = getHoekpunt1().getX();
        grootsteX = getHoekpunt3().getX();
        if (getHoekpunt1().getY() >= getHoekpunt2().getY() && getHoekpunt1().getY() >= getHoekpunt3().getY()) {
            grootsteY = getHoekpunt1().getY();
        } else if (getHoekpunt2().getY() >= getHoekpunt3().getY()) {
            grootsteY = getHoekpunt2().getY();
        } else {
            grootsteY = getHoekpunt3().getY();
        }
        if (getHoekpunt1().getY() <= getHoekpunt2().getY() && getHoekpunt1().getY() <= getHoekpunt3().getY()) {
            kleinsteY = getHoekpunt1().getY();
        } else if (getHoekpunt2().getY() <= getHoekpunt3().getY()) {
            kleinsteY = getHoekpunt2().getY();
        } else {
            kleinsteY = getHoekpunt3().getY();
        }
        Punt linkerbovenhoek = new Punt(kleinsteX, grootsteY);
        int breedte = grootsteX - kleinsteX;
        int hoogte = grootsteY - kleinsteY;
        return new Omhullende(linkerbovenhoek, breedte, hoogte);
    }

    @Override
    public void teken(Pane root) {
        Polyline driehoek = new Polyline();
        driehoek.setFill(Color.WHITE);
        driehoek.setStroke(Color.BLACK);
        driehoek.getPoints().addAll(new Double[]{(double) getHoekpunt1().getX(), (double) getHoekpunt1().getY(), (double) getHoekpunt2().getX(), (double) getHoekpunt2().getY(), (double) getHoekpunt3().getX(), (double) getHoekpunt3().getY()});
        root.getChildren().addAll(driehoek);
    }
}
