package domain;

public class Punt {
    private final int x;
    private final int y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int compareTo(Punt punt) {
        if (getX() < punt.getX()) return 1;
        else if (getX() ==  punt.getX()) {
            if (getY() < punt.getY()) return 1;
            else return 2;
        }
        else return 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punt punt = (Punt) o;
        return x == punt.x && y == punt.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}