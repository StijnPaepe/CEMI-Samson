package domain.db;

import domain.model.Woord;

import java.util.ArrayList;

public class Woordenlijst {
    ArrayList<Woord> woorden;

    public Woordenlijst (){
        woorden = new ArrayList<>();
    }

    public void addWoord(Woord woord) {
        if (woord == null) throw new IllegalArgumentException();
        woorden.add(woord);
    }

    public ArrayList<Woord> getWoorden() {
        return woorden;
    }

    public ArrayList<Woord> getWoordenBeginner() {
        ArrayList<Woord> beginner = new ArrayList<>();
        for (Woord woord : getWoorden()) {
            if (woord.getNiveau().equals("beginner")) {
                beginner.add(woord);
            }
        }
        return beginner;
    }

    public ArrayList<Woord> getWoordenExpert() {
        ArrayList<Woord> expert = new ArrayList<>();
        for (Woord woord : getWoorden()) {
            if (woord.getNiveau().equals("expert")) {
                expert.add(woord);
            }
        }
        return expert;
    }

    public int getAantalWoorden() {
        return woorden.size();
    }

    public Woord getLangsteWoord() {
        Woord langestWoord = woorden.get(0);
        for(Woord woord : woorden) {
            if(woord.getLengte() > langestWoord.getLengte()) {
                langestWoord = woord;
            }
        }
        return langestWoord;
    }

    public Woord getKorsteWoord() {
        Woord kortsteWoord = woorden.get(0);
        for(Woord woord : woorden) {
            if(woord.getLengte() < kortsteWoord.getLengte()) {
                kortsteWoord = woord;
            }
        }
        return kortsteWoord;
    }

    public double gemiddeldVerschillendeLetters() {
        int totaal = 0;
        for (Woord woord : woorden) {
            totaal += woord.aantalVerschillendeLetters();
        }
        return totaal / getAantalWoorden();
    }

    public void verwijderVolgnummer(String volgnummer) {
        for (Woord woord : woorden) {
            if (woord.getVolgnummer().equals(volgnummer)) {
                woorden.remove(woord);
                break;
            }
        }
    }
}
