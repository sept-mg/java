public class Main {
    public static void main(String[] args) {
        final int MAX = 5;
        int scoreJ1 = 0, scoreJ2 = 0;
        De d1 = new De(), d2 = new De();
        while (scoreJ1 < MAX && scoreJ2 < MAX) {
            d1.lancer();
            d2.lancer();
            if(d1.estFortQue(d2))
                scoreJ1++;
            else
                scoreJ2++;

            System.out.println(d1.toString() + " - " + d2.toString());
        }

        System.out.println("le " + (scoreJ1 == MAX ? "premier" : "second") + "joueur a gagné");
    }   
}