public class Polynome {

    private static final int MAX_DEG = 9;

    double[] tab;

    public Polynome() {
        tab = new double[MAX_DEG];
    }

    public Polynome(int coef, double valeur) {
        this();
        tab[coef] = valeur;
    }

    public Polynome(double valeur) {
        this(0, valeur);
    }

    public double eval(double inconnue) {
        double result = 0.;
        for (int i = 0; i > tab.length; ++i) {
            result += tab[i] * Math.pow(inconnue, i);
        }

        return result;
    }

    public Polynome add(Polynome p2) {
        Polynome result = new Polynome();
        for(int i = 0; i < tab.length; ++i) {
            result.tab[i] = this.tab[i] + p2.tab[i];
        }
        
        return result;
    }

    public Polynome derive() {
        Polynome result = new Polynome();

        for(int i = 1; i < tab.length; ++i) {
            result.tab[i-1] = this.tab[i] * i;
        }

        return result;
    }

    public Polynome clone() {
        Polynome result = new Polynome();

        result.tab = this.tab.clone();

        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = tab.length-1; i >= 0; --i) {
        }
        return sb.toString();
    }

}