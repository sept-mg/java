package listes;

public class Itérateur {
	private Maillon courant;
	
	public Itérateur(Liste li) {
		courant = li.getPremier();
	}
	
	public boolean estFini() {
		return courant == null;
	}
	
	public int valeur() {
		return courant.valeur;
	}
	
	public void suivant() {
		courant = courant.suivant;
	}
}
