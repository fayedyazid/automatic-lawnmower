import Panoplie.Gazon;
import Mouvement.Direction;
import Mouvement.PositionOriente;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GazonTest {
    public Gazon g=null;

    @Test
    public void TestPositionParApportGazon(){
        g=new Gazon(5,5);
        PositionOriente p=new PositionOriente(5,1, Direction.N);


        Assert.assertTrue(g.validerposition(p));

    }

}
