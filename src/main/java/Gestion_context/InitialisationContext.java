package Gestion_context;

import Panoplie.Tondeuse;
import Mouvement.Direction;
import Mouvement.ChaineAction;
import Mouvement.PositionOriente;
import Panoplie.Gazon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitialisationContext {
    public static  String[] fileData;//recuperer les donnees de fichier d entree
    //creer l objet  gazon (suposant plusieurs sinon on creer gazon comme singleton
    public static Gazon g=null;
    public static List<Tondeuse> ListTondeuse=new ArrayList<>();
    public static List<ChaineAction> lesitiniraires =new ArrayList<>();
    //initialiser le gazon


    //lire les lignes de fichier
    public static void initialiserlefichier() throws IOException {
        fileData = FileContext.getFile("/file_data.txt").split("\n");
    }
    public static void initialiserGazon(){
        g = new Gazon();
        String[] fildes = fileData[0].split(" ");//eliminate blanc
        int x=Integer.parseInt(fildes[0]);
        int y=Integer.parseInt(fildes[1]);
        g.setLargeur(x);
        g.setHauteur(y);

    }

     public static void initialiserTondeuses() {
         //creer la liste des tondeuses
         ListTondeuse.clear();
         //creer la liste des itiniraires
         lesitiniraires.clear();


         String[] fildesi = null;
         int j = 0; //id tondeuse
         int l = 0;//id iti
         for (int i = 1; i < fileData.length; i++) {

             if (i % 2 != 0) {//position
                 fildesi = fileData[i].split(" ");//eliminate blanc
                 PositionOriente p = new PositionOriente(Integer.parseInt(fildesi[0]), Integer.parseInt(fildesi[1]), Direction.valueOf(fildesi[2]));
                 Tondeuse t = new Tondeuse();
                 t.setId_t(j);
                 t.setP(p);
                 t.setG(g);
                 ListTondeuse.add(t);
                 j++;

             } else if (i % 2 == 0) {// action  tondeuse add chemin
                 fildesi = fileData[i].split("");//eliminate blanc
                 ChaineAction It = new ChaineAction();
                 It.setId_chA(l);
                 It.setChemin(fildesi);

                 lesitiniraires.add(It);
                 l++;
             }

             fildesi = null;

         }
     }
         //associer les itiniraires aux tondeuses
    public static void associeractionTondeuse() {
        int nbreTondeuse = ListTondeuse.size();
        System.out.println("le nombre de Tondeuse est :"+nbreTondeuse);
        for (int k = 0; k < nbreTondeuse; k++) {
            ListTondeuse.get(k).setId_Cc(lesitiniraires.get(k).getId_chA());
        }
    }


}
