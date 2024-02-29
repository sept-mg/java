package artistes;

import artistes.Personne;

public class Artiste {
    public static String normString(String s) throws Exception {
        if(s == null || s.isBlank()) {
            throw new Exception("invalid name");
        }
        return Character.toUpperCase(s.charAt(0)) + s.trim().substring(1).toLowerCase();
    }

    public static void normPersonne(Personne p) throws Exception {
        p.nom = normString(p.nom);
        p.prenom = normString(p.prenom);
    }
}
