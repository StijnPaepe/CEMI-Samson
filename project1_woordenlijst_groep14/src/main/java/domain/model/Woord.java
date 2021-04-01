package domain.model;

public class Woord {
    private String woord;
    private String niveau;
    private String volgnummer;

    public Woord(String woord, String niveau) {
        if (woord == null || woord.trim().isEmpty()) throw new IllegalArgumentException("leeg woord");
        this.woord = woord;
        this.niveau = niveau;
        setVolgnummer();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Woord woord1 = (Woord) o;
        if (getNiveau() == null && woord1.getNiveau() == null) {
            return getWoord().equals(woord1.getWoord());
        } else if (getNiveau() == null || woord1.getNiveau() == null) {
            return false;
        }
        return getWoord().equals(woord1.getWoord()) && getNiveau().equals(woord1.getNiveau());
    }

    public String getWoord() {
        return woord;
    }

    public String getNiveau() {
        if (niveau == null) return "";
        return niveau;
    }

    public int getLengte() {
        return woord.length();
    }

    public int aantalVerschillendeLetters() {
        return (int) woord.chars().distinct().count();
    }

    public String getVolgnummer() {
        return volgnummer;
    }

    public void setVolgnummer() {
        this.volgnummer = toString() + Math.floor(Math.random() * (100));
    }
}
