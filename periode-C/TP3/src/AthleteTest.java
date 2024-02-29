import org.junit.Assert;
import org.junit.Test;

public class AthleteTest {

    @Test
    public void testDossardDifferent() {
        Athlete athlete1 = new Athlete();
        Athlete athlete2 = new Athlete();
        Assert.assertNotEquals(athlete1.getNum(), athlete2.getNum());
    }

    @Test
    public void testPassageDeTemoin() {
        Athlete athleteDebut = new Athlete(true);
        Athlete athleteFin = new Athlete();

        Assert.assertTrue(athleteDebut.aLeTemoin());
        Assert.assertFalse(athleteFin.aLeTemoin());

        athleteDebut.passLeTemoin(athleteFin);

        Assert.assertFalse(athleteDebut.aLeTemoin());
        Assert.assertTrue(athleteFin.aLeTemoin());
    }
    
}
