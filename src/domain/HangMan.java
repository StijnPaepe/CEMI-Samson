package domain;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan;
    private WoordenLijst woordenLijst;
    private HintWoord hintwoord;
    private boolean gewonnen;

    public HangMan(Speler speler, WoordenLijst woordenLijst) {
        if (speler == null || woordenLijst == null) throw new DomainException("speler / woordenlijst mag niet null zijn.");
        if (woordenLijst.getAantalWoorden() == 0) throw new DomainException("lege woordenlijst");
        this.speler = speler;
        this.woordenLijst = woordenLijst;
        this.hintwoord = new HintWoord(woordenLijst.getRandomWoord());
        tekeningHangMan = new TekeningHangMan();
    }

    public Speler getSpeler() {
        return speler;
    }

    public TekeningHangMan getTekening() {
        return tekeningHangMan;
    }

    public String getHint() {
        return hintwoord.toString();
    }

    public boolean isGameOver() {
        return tekeningHangMan.getAantalOnzichtbaar() == 0;
    }

    public boolean isGewonnen() {
        return hintwoord.isGeraden() && !isGameOver();
    }

    public boolean raad(char c) {
        if (hintwoord.getWoord().indexOf(c) == -1) {
            tekeningHangMan.zetVolgendeZichtbaar();
        }
        return hintwoord.raad(c);
    }
}
