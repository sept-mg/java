import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Poete {

	private static class Prefixe {
		public String premierMot;
		public String dernierMot;

		public Prefixe(String premierMot, String dernierMot) {
			this.premierMot = premierMot;
			this.dernierMot = dernierMot;
		}
		public Prefixe clone() {
			return new Prefixe(this.premierMot, this. dernierMot);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Poete p = (Poete) o;
		return Objects.equals(debuts, p.debuts) && Objects.equals(savoir, p.savoir);
	}

	@Override
	public int hashCode() {
		return Objects.hash(savoir, savoir);
	}

	
	// exo 3 : completer la definition ci-dessous
	private ArrayList<Prefixe> debuts;
	
	// exo 4 : completer la definition ci-dessous
	private HashMap<Prefixe, ArrayList<String>> savoir;

	public Poete() {
		debuts = new ArrayList<>();
		savoir = new HashMap<>();
	}

	public boolean neSaitRien() {
		return savoir.isEmpty();
	}

	public void printStatistiques() {
		// exo 8 : completer le code
		int nbDebuts = debuts.size(); // nombre de textes analyses
		int nbPrefixes = savoir.size(); // nombre de prefixes connus
		int max = 0, nbSup = 0, cumul = 0;
		// exo 8 : parcourir toutes les sequences de mots asociees à un prefixe
		// et initialiser :
		// - max avec la taille de la plus longue sequence
		// - nbSup avec le nombre de prefixes ayant au moins 2 mots associes
		// - cumul avec le nombre cumule de mots associes aux prefixes
		for (ArrayList<String> mots : savoir.values()) {
			if(mots.size() > max) max = mots.size();

			if(mots.size() >= 2) ++nbSup;
			cumul += mots.size();
		}
		
		System.out.println("nbre de textes : " + nbDebuts);
		System.out.println("nbre de prefixes : " + nbPrefixes);
		System.out.println("nbre maximal de mots lies à un même prefixe : "
				+ max);
		System.out
				.println("nbre de prefixes associes à au - 2 mots : " + nbSup);
		if (nbPrefixes != 0)
			System.out.println("nbre moyen de mots associes aux prefixes : "
					+ ((float) cumul / nbPrefixes));
}

	public void apprendre(String nom) throws FileNotFoundException,
			NoSuchElementException {
		// exo 9 : completer le code
		Scanner sc = new Scanner(new File(nom));
		// si le fichier contient moins de 2 mots, les deux lectures
		// suivantes levent l'exception NoSuchElementException
		Prefixe p = new Prefixe(sc.next(), sc.next());

		// exo 9 : ajouter une copie du prefixe p aux debuts de textes connus
		// Attention : cela doit être necessairement une copie !!!
		debuts.add(p.clone());

		while (sc.hasNext()) {
			String s = sc.next();
			ajouterMotAPrefixe(p, s);
			// exo 10 : mettre à jour p pour qu'il corresponde aux 2 derniers 
			// mots lus

			p.premierMot = p.dernierMot;
			p.dernierMot = s;
		}
		ajouterMotAPrefixe(p, "");
		sc.close();
	}

	private void ajouterMotAPrefixe(Prefixe p, String s) {
		// exo 9 : ajouter s à la sequence de mots associee à p 
		if (savoir.containsKey(p)) {
			savoir.get(p).add(s);
		} else {
			savoir.put(p, new ArrayList<>(Arrays.asList(s)));
		}
	}

	public String inventer() {
		// exo 10 : completer le code
		assert (!neSaitRien());
		StringBuilder sb = new StringBuilder();
		Random rd = new Random();
		Prefixe p;
		// exo 10 : initialiser p avec un prefixe choisi aleatoirement 
		// parmi ceux que le poete connait comme pouvant commencer un texte
		p = debuts.get(rd.nextInt(debuts.size() - 1));
		// exo 10 : ajouter les 2 mots du prefixe p dans sb 
		sb.append(p.premierMot + " " + p.dernierMot);
		
		// exo 10 : tant que (p est connu comme pouvant être suivi par un mot)
		while (savoir.containsKey(p) && savoir.get(p) != null && !savoir.get(p).isEmpty()) {
			String s;
			// exo 10 : initialiser s avec un mot choisi aleatoirement parmi 
			// ceux pouvant suivre le prefixe p
			s = savoir.get(p).get(rd.nextInt(savoir.get(p).size() - 1));
			sb.append(" " + s);
			// exo 10 : mettre à jour p pour qu'il corresponde aux 2 derniers 
			// mots produits
			p.premierMot = p.dernierMot;
			p.dernierMot = s;
		}
		return sb.toString();
	}
}
