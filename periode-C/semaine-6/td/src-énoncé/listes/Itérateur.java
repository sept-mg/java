package listes;

public class It�rateur {
	private Maillon courant;
	
	public It�rateur(Liste li) {
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
