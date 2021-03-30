package domain;

public class Rechthoek extends Vorm {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rechthoek rechthoek = (Rechthoek) o;
        return breedte == rechthoek.breedte && hoogte == rechthoek.hoogte && linkerBovenHoek.equals(rechthoek.getLinkerBovenhoek());
    }

    @Override
    public String toString() {
        return "Rechthoek: linkerbovenhoek: " + getLinkerBovenhoek().toString() + " - breedte: " + getBreedte() + " - hoogte: " + getHoogte();
    }
}
