import Panoplie.Gazon;
import Panoplie.Tondeuse;
import Mouvement.Direction;
import Mouvement.PositionOriente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TondeuseTest {
    Tondeuse t;String chaineAction;PositionOriente p3;PositionOriente p1;
    @Before
    public void setup() {
        p1 = new PositionOriente(3, 3, Direction.E);
        Gazon g = new Gazon();
        g.setHauteur(5);
        g.setLargeur(5);

         chaineAction = "AADAADADDA";
         t = new Tondeuse();
        t.setP(p1);
        t.setId_t(1);
        t.setG(g);
         p3 = new PositionOriente(5, 1, Direction.E);
    }

    public PositionOriente Exec() {
        for (int i = 0; i <= chaineAction.length() - 1; i++) {
            t.RunT(String.valueOf(chaineAction.charAt(i)));
        }
        return t.getP();
    }
    @Test
            public void TestExecution() {
        Assert.assertEquals(p3, Exec());

    }


}