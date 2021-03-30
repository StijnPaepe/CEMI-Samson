package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tekening {
    private String naam;
    private List<Vorm> vormen;
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;

    public static boolean isValidNaam(String naamTekening) {
        if(naamTekening == null || naamTekening.trim().isBlank()) return false;
        else return true;
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
        if(cijfer > getAantalVormen() - 1) throw new DomainException(" cijfer mag niet groter zijn");
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
        return "Tekening:" +
                "naam:" + naam +
                " - vormen:" + vormen;
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
        vormen.add(vorm);
    }
}


