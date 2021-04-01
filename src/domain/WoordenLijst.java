package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WoordenLijst {
    private ArrayList<String> woorden;

    public WoordenLijst() {
        woorden = new ArrayList<>();

    }

    public void voegToe(String woord) {
        if (woord == null || woord.trim().isBlank()) throw new DomainException("woord mag niet null of leeg zijn ");
        if (woorden.contains(woord)) throw new DomainException("woord mag niet twee keer voorkomen");
        woorden.add(woord);
    }

    public int getAantalWoorden() {

        return woorden.size();
    }

    public String getRandomWoord() {
        if (woorden == null || woorden.isEmpty()) throw new DomainException(" woorden mag niet null of leeg zijn ");
        Random ran = new Random();
        int nxt = ran.nextInt(woorden.size());
        return woorden.get(nxt);
    }

    public boolean containsWoord(String woord){
        return woorden.contains(woord);
    }

}

