import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Poète {
	// exo 2 : définir une classe privée statique nommée Préfixe
	...
	
	// exo 3 : compléter la définition ci-dessous
	private ... débuts;
	
	// exo 4 : compléter la définition ci-dessous
	private ... savoir;

	public Poète() {
		// exo 6 : compléter le code
	}

	public boolean neSaitRien() {
		// exo 7 : compléter le code
	}

	public void printStatistiques() {
		// exo 8 : compléter le code
		int nbDébuts = ...; // nombre de textes analysés
		int nbPréfixes = ...; // nombre de préfixes connus
		int max = 0, nbSup = 0, cumul = 0;
		// exo 8 : parcourir toutes les séquences de mots asociées à un préfixe
		// et initialiser :
		// - max avec la taille de la plus longue séquence
		// - nbSup avec le nombre de préfixes ayant au moins 2 mots associés
		// - cumul avec le nombre cumulé de mots associés aux préfixes
		...
		
		System.out.println("nbre de textes : " + nbDébuts);
		System.out.println("nbre de préfixes : " + nbPréfixes);
		System.out.println("nbre maximal de mots liés à un même préfixe : "
				+ max);
		System.out
				.println("nbre de préfixes associés à au - 2 mots : " + nbSup);
		if (nbPréfixes != 0)
			System.out.println("nbre moyen de mots associés aux préfixes : "
					+ ((float) cumul / nbPréfixes));
}

	public void apprendre(String nom) throws FileNotFoundException,
			NoSuchElementException {
		// exo 9 : compléter le code
		Scanner sc = new Scanner(new File(nom));
		// si le fichier contient moins de 2 mots, les deux lectures
		// suivantes lèvent l'exception NoSuchElementException
		Préfixe p = new Préfixe(sc.next(), sc.next());

		// exo 9 : ajouter une copie du préfixe p aux débuts de textes connus
		// Attention : cela doit être nécessairement une copie !!!
		...

		while (sc.hasNext()) {
			String s = sc.next();
			ajouterMotAPréfixe(p, s);
			// exo 10 : mettre à jour p pour qu'il corresponde aux 2 derniers 
			// mots lus
		}
		ajouterMotAPréfixe(p, "");
		sc.close();
	}

	private void ajouterMotAPréfixe(Préfixe p, String s) {
		// exo 9 : ajouter s à la séquence de mots associée à p 
		...
	}

	public String inventer() {
		// exo 10 : compléter le code
		assert (!neSaitRien());
		StringBuilder sb = new StringBuilder();
		Random rd = new Random();
		Préfixe p;
		// exo 10 : initialiser p avec un préfixe choisi aléatoirement 
		// parmi ceux que le poète connait comme pouvant commencer un texte
		p = ...;
		// exo 10 : ajouter les 2 mots du préfixe p dans sb 
		sb.append(...);
		
		// exo 10 : tant que (p est connu comme pouvant être suivi par un mot)
		while (...) {
			String s;
			// exo 10 : initialiser s avec un mot choisi aléatoirement parmi 
			// ceux pouvant suivre le préfixe p
			s = ...;
			sb.append(" " + s);
			// exo 10 : mettre à jour p pour qu'il corresponde aux 2 derniers 
			// mots produits
			...
		}
		return sb.toString();
	}
}
