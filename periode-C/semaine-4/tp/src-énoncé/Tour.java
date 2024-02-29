/**
 * Repr�sente une tour du probl�me des tours de Hano�.
 */
public class Tour {
	/** Nombre maximal de disques qu'une tour peut supporter. */
	private static final int MAX = 100;
	/** Disques support�s par la tour (chacun �tant d�sign� par son diam�tre). */
	private int[] disques;
	/** Nombre de disques support�s par la tour. */
	private int nb;

	
	/**
	 * Construit une tour vide de tout disque.
	 */
	public Tour() {
		this(0);
	}
	

	public Tour(int nbDisques) {
		assert(nbDisques >= 0 && nbDisques <= MAX);
		nb = nbDisques;
		disques = new int[MAX];

		for(; nbDisques > 0; --nbDisques) {
			disques[nb - nbDisques] = nbDisques;
		}
	} 

	/**
	 * Retourne le nombre de disques �tant sur la tour.
	 */
	public int nbDisques() {
		return nb;
	}

	/**
	 * Retourne une cha�ne indiquant le diam�tre des disques pr�sents sur la
	 * tour (de la base au sommet).
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < nb; ++i) {
			if (i != 0)
				sb.append(", ");
			sb.append(disques[i]);
		}
		return sb.toString() + "]";
	}

	
}
