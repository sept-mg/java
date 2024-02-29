import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Appli {
	private static void leçon(Poète p, String noms) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(noms));
		while (sc.hasNext()) 
			p.apprendre(sc.next());
		sc.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Poète p = new Poète();
		
		leçon(p, "lafontaine.txt");
		p.printStatistiques();

		if (!p.neSaitRien())
			System.out.println(p.inventer());
	}
}
