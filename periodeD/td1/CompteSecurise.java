package periodeD.td1;

import java.util.LinkedList;

public class CompteSecurise extends Compte {
    private long retraitMax;

    private static int MAXJOUR = 5;

    private LinkedList<Retrait> dernierRetrait;

    public CompteSecurise (long solde, long retraitMax) {
        super(solde);

        assert retraitMax >= 0 ;
        this.retraitMax = retraitMax;

        dernierRetrait = new LinkedList<>();
    }

    public boolean retraitPossible(long val) {
        if(!super.retraitPossible(val))
            return false;
        
        long acc = 0;
        for (Retrait currRetrait : dernierRetrait) {
            if(currRetrait.age() <= MAXJOUR)
                acc+=currRetrait.montant();
        }

        return acc <= this.retraitMax;
    }

    @Override
    public void retirer(long val) {
        assert retraitPossible(val);

        super.retirer(val);

        LinkedList<Retrait> temp = new LinkedList<>();
        Retrait curr;

        while (!dernierRetrait.isEmpty()) {
            curr = dernierRetrait.getFirst();
            
            if(curr.age() <= MAXJOUR)
                temp.add(curr);        
            
            dernierRetrait.removeFirst();
        }

        dernierRetrait = temp;

        dernierRetrait.add(new Retrait(val));


    }

}
