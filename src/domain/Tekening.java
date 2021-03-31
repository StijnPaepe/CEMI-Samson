package domain;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Tekening implements Drawable {
    private String naam;
    private List<Vorm> vormen;
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;

    public static boolean isValidNaam(String naamTekening) {
        return naamTekening != null && !naamTekening.trim().isBlank();
    }

    public String getNaam() {
        return naam;
    }

    public Tekening(String naam){
        if(!isValidNaam(naam)) throw new DomainException(" naam mag niet null zijn");
        this.naam = naam;
        vormen = new ArrayList<>();
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public Vorm getVorm(int cijfer) {
        if(cijfer < 0) throw new DomainException(" cijfer mag niet negatief zijn");
        if(cijfer > getAantalVormen() - 1) throw new DomainException(" cijfer mag niet groter dan het aantal vormen zijn");
        return vormen.get(cijfer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tekening tekening = (Tekening) o;
        if(getAantalVormen() != tekening.getAantalVormen()) return false;
        for (Vorm vorm: vormen){
            if(!tekening.bevat(vorm)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Tekening: naam: " + naam);
        for (Vorm vorm :  vormen) {
            result.append("\n\t");
            result.append(vorm.toString());
        }
        return result.toString();
    }

    public boolean bevat(Vorm vorm) {
        return vormen.contains(vorm);
    }

    public void verwijder(Vorm vorm) {
        if(!vormen.contains(vorm)) throw new DomainException(" vorm bestaat niet in tekening");
        vormen.remove(vorm);
    }

    public void voegToe(Vorm vorm) {
        if( vorm == null) throw new DomainException("vorm mag niet gelijk zijn null");
        if(vormen.contains(vorm)) throw new DomainException(" vorm bestaat al in tekening");
        if(vorm.getOmhullende().getMinimumX() < MIN_X || vorm.getOmhullende().getMinimumY() < MIN_Y ||vorm.getOmhullende().getMaximumX() > MAX_X ||vorm.getOmhullende().getMaximumY() > MAX_Y) {
            throw new DomainException("vorm past niet in de tekening");
        }
        vormen.add(vorm);
    }

    @Override
    public void teken(Pane root) {
        ArrayList<Object> nieuweVormen = new ArrayList<>();
        for (Vorm vorm : vormen) {
            if (vorm instanceof Cirkel) {
                Circle nieuw = new Circle(((Cirkel) vorm).getMiddelpunt().getX(), ((Cirkel) vorm).getMiddelpunt().getY(), ((Cirkel) vorm).getRadius());
                nieuw.setFill(vorm.getKleur());
                nieuw.setStroke(Color.BLACK);
                nieuweVormen.add(nieuw);
            } else if (vorm instanceof Rechthoek) {
                Rectangle nieuw = new Rectangle(((Rechthoek) vorm).getLinkerBovenhoek().getX(), ((Rechthoek) vorm).getLinkerBovenhoek().getY(), ((Rechthoek) vorm).getBreedte(), ((Rechthoek) vorm).getHoogte());
                nieuw.setFill(vorm.getKleur());
                nieuw.setStroke(Color.BLACK);
                nieuweVormen.add(nieuw);
            } else if (vorm instanceof LijnStuk) {
                Line nieuw = new Line(((LijnStuk) vorm).getStartPunt().getX(), ((LijnStuk) vorm).getStartPunt().getY(), ((LijnStuk) vorm).getEindPunt().getX(), ((LijnStuk) vorm).getEindPunt().getY());
                nieuw.setStrokeWidth(5);
                nieuweVormen.add(nieuw);
            } else {
                Polyline nieuw = new Polyline();
                nieuw.setFill(vorm.getKleur());
                nieuw.setStroke(Color.BLACK);
                nieuw.getPoints().addAll((double) ((Driehoek) vorm).getHoekpunt1().getX(), (double) ((Driehoek) vorm).getHoekpunt1().getY(), (double) ((Driehoek) vorm).getHoekpunt2().getX(),
                        (double) ((Driehoek) vorm).getHoekpunt2().getY(), (double) ((Driehoek) vorm).getHoekpunt3().getX(), (double) ((Driehoek) vorm).getHoekpunt3().getY());

            }
        }

        for (Object o : nieuweVormen) {
            root.getChildren().add((Node) o);
        }
    }
}


