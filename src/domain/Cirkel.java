package domain;

public class Cirkel extends Vorm{
    private Punt middelpunt;
    private int radius;

    public void setMiddelpunt(Punt middelpunt) {
        if (middelpunt == null || middelpunt.getX() == 0 && middelpunt.getY() == 0) throw new IllegalArgumentException();
        this.middelpunt = middelpunt;
    }

    public void setRadius(int radius) {
        if (radius <= 0) throw new IllegalArgumentException();
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
        return "Cirkel: middelpunt: " + middelpunt.toString() + " - straal: " + radius;
    }
}
