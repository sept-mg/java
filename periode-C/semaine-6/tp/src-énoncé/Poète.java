import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Po�te {
	// exo 2 : d�finir une classe priv�e statique nomm�e Pr�fixe
	...
	
	// exo 3 : compl�ter la d�finition ci-dessous
	private ... d�buts;
	
	// exo 4 : compl�ter la d�finition ci-dessous
	private ... savoir;

	public Po�te() {
		// exo 6 : compl�ter le code
	}

	public boolean neSaitRien() {
		// exo 7 : compl�ter le code
	}

	public void printStatistiques() {
		// exo 8 : compl�ter le code
		int nbD�buts = ...; // nombre de textes analys�s
		int nbPr�fixes = ...; // nombre de pr�fixes connus
		int max = 0, nbSup = 0, cumul = 0;
		// exo 8 : parcourir toutes les s�quences de mots asoci�es � un pr�fixe
		// et initialiser :
		// - max avec la taille de la plus longue s�quence
		// - nbSup avec le nombre de pr�fixes ayant au moins 2 mots associ�s
		// - cumul avec le nombre cumul� de mots associ�s aux pr�fixes
		...
		
		System.out.println("nbre de textes : " + nbD�buts);
		System.out.println("nbre de pr�fixes : " + nbPr�fixes);
		System.out.println("nbre maximal de mots li�s � un m�me pr�fixe : "
				+ max);
		System.out
				.println("nbre de pr�fixes associ�s � au - 2 mots : " + nbSup);
		if (nbPr�fixes != 0)
			System.out.println("nbre moyen de mots associ�s aux pr�fixes : "
					+ ((float) cumul / nbPr�fixes));
}

	public void apprendre(String nom) throws FileNotFoundException,
			NoSuchElementException {
		// exo 9 : compl�ter le code
		Scanner sc = new Scanner(new File(nom));
		// si le fichier contient moins de 2 mots, les deux lectures
		// suivantes l�vent l'exception NoSuchElementException
		Pr�fixe p = new Pr�fixe(sc.next(), sc.next());

		// exo 9 : ajouter une copie du pr�fixe p aux d�buts de textes connus
		// Attention : cela doit �tre n�cessairement une copie !!!
		...

		while (sc.hasNext()) {
			String s = sc.next();
			ajouterMotAPr�fixe(p, s);
			// exo 10 : mettre � jour p pour qu'il corresponde aux 2 derniers 
			// mots lus
		}
		ajouterMotAPr�fixe(p, "");
		sc.close();
	}

	private void ajouterMotAPr�fixe(Pr�fixe p, String s) {
		// exo 9 : ajouter s � la s�quence de mots associ�e � p 
		...
	}

	public String inventer() {
		// exo 10 : compl�ter le code
		assert (!neSaitRien());
		StringBuilder sb = new StringBuilder();
		Random rd = new Random();
		Pr�fixe p;
		// exo 10 : initialiser p avec un pr�fixe choisi al�atoirement 
		// parmi ceux que le po�te connait comme pouvant commencer un texte
		p = ...;
		// exo 10 : ajouter les 2 mots du pr�fixe p dans sb 
		sb.append(...);
		
		// exo 10 : tant que (p est connu comme pouvant �tre suivi par un mot)
		while (...) {
			String s;
			// exo 10 : initialiser s avec un mot choisi al�atoirement parmi 
			// ceux pouvant suivre le pr�fixe p
			s = ...;
			sb.append(" " + s);
			// exo 10 : mettre � jour p pour qu'il corresponde aux 2 derniers 
			// mots produits
			...
		}
		return sb.toString();
	}
}
