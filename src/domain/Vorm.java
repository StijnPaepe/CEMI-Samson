package domain;

public abstract class Vorm {
    public abstract Omhullende getOmhullende();
    public String toString() {
        return "\n" + getOmhullende().toString();
    };
}
