import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Appli {
	private static void le�on(Po�te p, String noms) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(noms));
		while (sc.hasNext()) 
			p.apprendre(sc.next());
		sc.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Po�te p = new Po�te();
		
		le�on(p, "lafontaine.txt");
		p.printStatistiques();

		if (!p.neSaitRien())
			System.out.println(p.inventer());
	}
}
