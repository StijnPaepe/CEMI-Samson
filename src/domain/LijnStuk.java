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
        return "Lijn: startpunt: " + startPunt.toString() + " -  eindpunt: " + eindPunt.toString();
    }
}
