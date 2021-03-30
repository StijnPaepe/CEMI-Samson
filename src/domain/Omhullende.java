package domain;

public class Omhullende {
    private Punt linkerBovenhoek;
    private int breedte, hoogte;

    public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) {
        setLinkerBovenhoek(linkerBovenhoek);
        setBreedte(breedte);
        setHoogte(hoogte);
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenhoek;
    }

    public void setLinkerBovenhoek(Punt linkerBovenhoek) {
        if (linkerBovenhoek == null ){
            throw new DomainException("Linkerbovenhoek is leeg");
        }
        this.linkerBovenhoek = linkerBovenhoek;
    }

    public int getBreedte() {
        return breedte;
    }

    public void setBreedte(int breedte) {
        if (breedte < 0){
            throw new DomainException("Breedte is nooit kleiner dan 0");
        }
        this.breedte = breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public void setHoogte(int hoogte) {
        if (hoogte < 0){
            throw new DomainException("Hoogte is nooit kleiner dan 0");
        }
        this.hoogte = hoogte;
    }

    public int getMinimumX(){

        return linkerBovenhoek.getX();
    }
    public int getMinimumY(){
        return linkerBovenhoek.getY();
    }
    public int getMaximumX(){
        return linkerBovenhoek.getX() + breedte ;
    }
    public int getMaximumY(){
        return linkerBovenhoek.getY() + hoogte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Omhullende that = (Omhullende) o;
        return breedte == that.breedte && hoogte == that.hoogte && linkerBovenhoek.equals(that.linkerBovenhoek);
    }

    @Override
    public String toString() {
        return "Omhullende: " + linkerBovenhoek.toString() + " -  breedte: " + breedte + " - hoogte: " + hoogte ;
    }
}
