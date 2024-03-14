public class Segements {
    Coordonnee ex1, ex2;

    public Segement(Coordonnee extremite1, Coordonnee extremite2) {
        ex1 = extremite1;
        ex2 = extremite2;
    }

    public double taille() {
        return ex1.distance(ex2);
    }

    public String toString() {
        return "extreminté 1 : " + ex1.toString() + ", extreminité 2 : " + ex2.toString();
    }

    public boolean equals(Segements s) {
        return (s.ex1.equals(ex1) && s.ex2.equals(ex2)) || (s.ex1.equals(ex2) && s.ex2.equals(ex1));
    }
}
