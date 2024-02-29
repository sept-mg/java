package bank;

public class Compte {
    private int numero;
    private static int nbComptes;
    private double solde;
    private static double decMax = -1000.;

    public Compte() {
        this(0);
    }

    public Compte(double soldeIni) {
        assert(soldeIni >= 0.);
        solde = soldeIni;
        numero = ++nbComptes;
    }

    public static void setDecouvertMax(double d) {
        assert(d <= 0);
        decMax = d;
    }

    public static double getDecouvertMax() {
        return decMax;
    }

    public void depot(double d) {
        assert(d > 0);
        solde += d;
    }

    public boolean retraitPossible(double d) {
        return d > 0 && solde - d >= decMax;
    }

    public void retrait(double d) {
        assert(retraitPossible(d));
        solde -= d;
    }

    public String toString() {
        return "le compte n°" + numero + (solde >= 0 ? " est crédité de " + solde : " est à découvert de " + (-solde)) + "€";
    }

}