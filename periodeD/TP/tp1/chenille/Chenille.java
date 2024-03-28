package chenille;

import chenille.anneaux.Anneau;
import chenille.anneaux.Tete;
import geometrie.Direction;

public class Chenille {

    private Tete tete;
    private Anneau[] anneaux;

    public Chenille(int nbAnneaux, int xt, int yt) {
        this.tete = new Tete(xt, yt, Direction.EST);
        this.anneaux = new Anneau[nbAnneaux];

        for (int i = 0; i < anneaux.length; ++i) {
            anneaux[i] = new Anneau(xt-i-1, yt);
        }
    }

    public void dessiner(char[][] t) {
        //dessiner les anneaux
        for (int i = 0; i < anneaux.length; ++i) {
            t[anneaux[i].getX()][anneaux[i].getY()] = anneaux[i].getSymbole();
        }

        t[tete.getX()][tete.getY()] = tete.getSymbole();
        
    }

    public void deplacer(int xMAX, int yMAX) {
        for (int i = anneaux.length - 1; i > 0 ; --i) {
        }
        anneaux[0].placerA(tete);
        tete.deplacer(xMAX, yMAX);
    }
}
