public class Athlete {
    private int num;
    private Temoin temoin; // par défaut false

    private static int NUM_COURANT = 1;

    public Athlete() {
        this.num = NUM_COURANT++;
    }

    public Athlete(boolean temoin) {
        this();
        if(temoin) prendLeTemoin();
    }

    public int getNum() {
        return num;
    }

    public boolean aLeTemoin() {
        return temoin != null;
    }

    public void passLeTemoin(Athlete athleteFin) {
        this.rendLeTemoin();
        athleteFin.prendLeTemoin();
    }

    private void prendLeTemoin() {
        assert !aLeTemoin();
        this.temoin = new Temoin();
    }

    private void rendLeTemoin() {
        assert aLeTemoin();
        this.temoin = null;
    }
    
    public String toString() {
        return "J'ai le dossard " + num;
    }
}