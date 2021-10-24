import Gestion_context.InitialisationContext;
import Panoplie.Tondeuse;
import org.junit.Test;

import java.io.IOException;

 public class PrincipaleTest {
    public  void lancerAllTondeuse() throws InterruptedException {
        for(Tondeuse t:InitialisationContext.ListTondeuse){
            System.out.println("la tondeuse "+t.getId_t()+" la position initiale est "+t.getP().getX()+" "+t.getP().getY()+" "+t.getP().getD());
            String[] v=InitialisationContext.lesitiniraires.get(t.getId_Cc()).getChemin();

            for (int i=0; i < v.length; i++) {


                t.RunT(v[i]);
                Thread.sleep(1000);
            }


           System.out.println("la tondeuse "+t.getId_t()+" Lanouvelle position "+t.getP().getX()+" "+t.getP().getY()+" "+t.getP().getD());
        }
    }
   @Test
    public  void TestExecution() throws IOException, InterruptedException {
        InitialisationContext.initialiserlefichier();
       InitialisationContext.initialiserGazon();
        InitialisationContext.initialiserTondeuses();
        InitialisationContext.associeractionTondeuse();
        lancerAllTondeuse();

    }
}
