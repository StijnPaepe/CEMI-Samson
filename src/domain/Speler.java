package domain;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam){
        if (naam == null || naam.trim().isEmpty()) throw new DomainException("naam is null of bestaat uit enkel spaties");
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

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }
}
