package chenille.anneaux;

public class Anneau {
    private int x, y;

    public Anneau(int ax, int ay) {
        x = ax;
        y = ay;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public char getSymbole() {
        return 'a';
    }

    public void deplacer(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void placerA(Anneau anneau) {
        x = anneau.x;
        y = anneau.y;
    }
}
