package bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Compte c1, c2;
        c1 = new Compte();
        c2 = new Compte();

        //changer le decouvert pour tout le monde
        Compte.setDecouvertMax(-1500.0);

        Compte c = new Compte();
        c.depot(1000.);
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        if(c.retraitPossible(n))
            c.retrait(n);

        System.out.println(c);
    } 
}
