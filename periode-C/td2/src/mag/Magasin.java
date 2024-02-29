package mag;

import java.util.ArrayList;

public class Magasin {
    public static void main(String[] args) {
        Produit p = new Produit();
        p.libelle = "Sophie, la giraphe";
        p.prix = 11.99;
        System.out.println(p.libelle + " (" + p.prix + "€)");
    }

    public static void ExempleArrayList() {
        ArrayList<String> l; 
        l = new ArrayList<>(); //tableau dynamique vide de string

        l.add("C++");
        l.add("Python");
        int nbElement = l.size();
        System.out.println(l.get(0)); // affiche l'élément a l'index 0 (le premier)
        l.set(1, "Java"); //modifie l'élément a l'index 1 (le deuxieme)
    }

    public static double montant(ArrayList<LigneDeCde> cde) {
        double total = 0;
        
        /*
        for(int i=0; i < cde.size(); ++i) {
            LigneDeCde l = cde.get(i);

            total += l.qte * l.produit.prix;
        }
        */

        // ou plus simple

        for(LigneDeCde l : cde) {  //prends chaqu'un des objet de la liste 1 par 1 et le met dans l
            total += l.qte * l.produit.prix;
        }
        
        return total;
    }

    public static String facture(ArrayList<LigneDeCde> cde) {
        StringBuilder sb = new StringBuilder(); // mieux que de concatener un string comme String s += ..... ca c'est mieux
        double total = 0;
        for (LigneDeCde l : cde) {
            double temp = l.produit.prix * l.qte;
            sb.append(l.qte);
            sb.append("x");
            sb.append(l.produit.libelle);
            sb.append(" (");
            sb.append(temp);
            sb.append("€)");
            sb.append(System.lineSeparator()); // saut de ligne mais il choisie le bon en fonction du systeme genre \n ou \r sur mac
            total += temp;
        }

        sb.append("total : ");
        sb.append(total);
        sb.append("€");

        return sb.toString(); //remettre en string a la fin le string builder
    }

    public static void ajoute(ArrayList<LigneDeCde> cde, Produit p, int q) {
        LigneDeCde l = null;
        for(LigneDeCde c : cde) {
            if(c.produit.libelle.equals(p.libelle)) {
                l = c;
                break;
            }
        }

        if (l == null) {
            l = new LigneDeCde();
            l.produit = p;
            l.qte = q;
            cde.add(l);
        }

        else {
            l.qte += q;
        }
    }
}

