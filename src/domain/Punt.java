package domain;

import java.util.Objects;

public class Punt {

    private int x, y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punt punt = (Punt) o;
        return x == punt.x &&
                y == punt.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public void setY(int y) {
        this.y = y;
    }
}