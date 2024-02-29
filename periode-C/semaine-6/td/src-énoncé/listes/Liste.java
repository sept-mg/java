package listes;

// visiblité paquetage
class Maillon {
	public int valeur;
	public Maillon suivant;
	public Maillon(int valeur) {
		this.valeur = valeur;
		this.suivant = null;
	}
}

public class Liste {	
	private Maillon premier;
	
	public Liste() {
		premier = null;
	}
	
	public Liste(Liste li) {
		this();
		for (Maillon m = li.premier; m != null; m = m.suivant)
			ajouter(m.valeur);
	}
	
	// visiblité paquetage
	Maillon getPremier() {
		return premier;
	}
	
	public void ajouter(int v) {
		Maillon m = new Maillon(v);
		if (premier == null)
			premier = m;
		else {
			Maillon tmp = premier;
			while (tmp.suivant != null)
				tmp = tmp.suivant;
			tmp.suivant = m;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		boolean first = true;
		for (Itérateur it = new Itérateur(this); !it.estFini(); it.suivant()) {
			if (!first)
				sb.append(", ");
			else
				first = false;
			sb.append(Integer.toString(it.valeur()));
		}
		return sb.toString() + "]";
	}
}
