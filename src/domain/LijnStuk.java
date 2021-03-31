package domain;

public class LijnStuk extends Vorm {
    private Punt startPunt;
    private Punt eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        setStartEnEindPunt(startPunt, eindPunt);
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    public void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
        if (startPunt == null) throw new DomainException("Startpunt mag niet null zijn.");
        if (eindPunt == null) throw new DomainException("Eindpunt mag niet null zijn.");
        if (startPunt.equals(eindPunt)) throw new DomainException("Start- en eindpunt mogen niet gelijk zijn.");
        this.startPunt = startPunt;
        this.eindPunt = eindPunt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LijnStuk lijnStuk = (LijnStuk) o;
        return getStartPunt().equals(lijnStuk.getStartPunt()) && getEindPunt().equals(lijnStuk.getEindPunt()) ||
                getStartPunt().equals(lijnStuk.getEindPunt()) && getEindPunt().equals(lijnStuk.getStartPunt());
    }

    @Override
    public String toString() {
        return "Lijn: startpunt: " + startPunt.toString() + " -  eindpunt: " + eindPunt.toString() + super.toString();
    }

    @Override
    public Omhullende getOmhullende() {
        int kleinsteX, kleinsteY, grootsteX, grootsteY;
        if (getStartPunt().getX() < getEindPunt().getX()) {
            kleinsteX = getStartPunt().getX();
            grootsteX = getEindPunt().getX();
        } else {
            grootsteX = getStartPunt().getX();
            kleinsteX = getEindPunt().getX();
        }
        if (getStartPunt().getY() < getEindPunt().getY()) {
            kleinsteY = getStartPunt().getY();
            grootsteY = getEindPunt().getY();
        } else {
            grootsteY = getStartPunt().getY();
            kleinsteY = getEindPunt().getY();
        }
        int breedte = grootsteX - kleinsteX;
        int hoogte = grootsteY - kleinsteY;
        Punt linkerbovenhoek = new Punt(kleinsteX, grootsteY);
        return new Omhullende(linkerbovenhoek, breedte, hoogte);
    }
}
