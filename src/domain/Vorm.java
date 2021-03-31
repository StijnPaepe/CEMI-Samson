package domain;

import javafx.scene.paint.Color;

public abstract class Vorm {
    private Color kleur = Color.WHITE;

    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        if (kleur == null) throw new DomainException("kleur is null");
        this.kleur = kleur;
    }

    public abstract Omhullende getOmhullende();

    public String toString() {
        return "\n" + getOmhullende().toString();
    };
}
