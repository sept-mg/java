import java.util.Random;

public class De {
    private int valeur;
    private int MAXFACE;
    private boolean estCasser;

    public De() {
        this.valeur = 1;
        MAXFACE = 6;
        estCasser = false;
    }

    public void lancer() {
        final int chanceCasser = 100; 
        
        Random random = new Random();
        int i = random.nextInt(chanceCasser) + 1;
        if(i == chanceCasser)
            this.estCasser = true;
        else
        {
            estCasser = false;
            this.valeur = i%MAXFACE + 1;
        }

    }

    public boolean estFortQue(De adversaire) {
        assert(!estCasser && !adversaire.estCasser);
        return this.valeur > adversaire.valeur;
    }

    public boolean estCasser() {
        return estCasser;
    }

    public String toString() {
        //return Integer.toString(valeur); //la bonne maniere
        return !estCasser ? ("" + valeur) : "cassé";
    }
}