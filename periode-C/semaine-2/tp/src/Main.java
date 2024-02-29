import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import artistes.Artiste;
import artistes.Personne;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        try {
            scanner = new Scanner(new FileInputStream("periode-C/semaine-2/tp/src/artistes.txt"));
            ArrayList<Personne> list = lireFichier(scanner);
            System.out.println(list.size());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ArrayList<Personne> lireFichier(Scanner scan) {
        ArrayList<Personne> listDePersonnes = new ArrayList<>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            Personne p = new Personne();
            String[] prenomNom = line.split(" ");
            p.prenom = prenomNom[0];
            p.nom = prenomNom[1];
            try {
                Artiste.normPersonne(p);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            listDePersonnes.add(p);
        }

        return listDePersonnes;
    }
}   
