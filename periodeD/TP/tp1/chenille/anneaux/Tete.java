package chenille.anneaux;

import geometrie.Direction;

public class Tete extends Anneau {

    private Direction cap;

    public Tete(int xt, int yt, Direction direction) {
        super(xt, yt);
        this.cap = direction;
    }

    @Override
    public char getSymbole() {
        return 't';
    }

    public void deplacer(int xMax, int yMax) {
        if(getX() == 0 || getX() == xMax || getY() == 0 || getY() == yMax) {
            cap = cap.inverser();
        }
        else {
            cap = cap.deriver(1);
        }

        super.deplacer(xMax, yMax);

    }
}
