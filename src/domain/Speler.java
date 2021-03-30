package domain;

public class Speler {
    private final String naam;
    private int score;

    public Speler(String naam){
        if (naam == null || naam.trim().isEmpty()) throw new DomainException("De naam van de speler is niet correct.\nDe naam moet minstens 1 niet spatie bevatten.");
        this.naam = naam;
        this.score = 0;
    }

    public String getNaam() {
        return naam;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int score){
        if (this.score + score < 0) throw new DomainException("score mag niet negatief worden");
        this.score += score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!o.getClass().equals(getClass())) return false;
        Speler s = (Speler) o;
        return getNaam().equals(s.getNaam()) && getScore() == s.getScore();
    }

    @Override
    public String toString() {
        return getNaam() + " heeft als score " + getScore();
    }
}
