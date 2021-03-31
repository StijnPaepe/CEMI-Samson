package domain;

public class HintWoord {
    private String woord;
    private HintLetter[] hintWoord;

    public HintWoord(String woord) {
        if(woord == null || woord.trim().isEmpty()){
            throw new DomainException("Woord is leeg");
        }
        this.woord = woord;
    }

    public String getWoord() {
        return woord;
    }

    @Override
    public String toString() {
        return "HintWoord{" +
                "woord=" + woord +
                '}';
    }

    public boolean raad(char e) {
        return true;
    }

    public boolean isGeraden() {
        return true;
    }
}
