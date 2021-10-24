package Panoplie;

import Mouvement.DirectionExacte;
import Mouvement.PositionOriente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tondeuse implements Serializable {

    int id_t;//identifiant de la tondeuse
    PositionOriente p;
    int id_Cc;  // identifiant de  chaine de commande
     Gazon g=new Gazon();

    //pivoter
    public void pivolterT(char h){
    //maj de l orientation de la tondeuse
        this.p.setD( DirectionExacte.calculerLaDirectionSuivante(h,this.p.getD()));
    }
    //calculer la position suivante


    public Boolean valider(){
      //  Gazon g=new Gazon();

        if(g.validerposition(this.calculerPositionSuivante())){
            this.p=this.calculerPositionSuivante();
            return true;
        }else{
            System.out.println("La tondeuse est en d hors du gazon");
            return false;
        }
    }
    public PositionOriente calculerPositionSuivante() {

       PositionOriente q=new PositionOriente();
        q.setX(this.getP().getX());
        q.setY(this.getP().getY());
        q.setD(this.getP().getD());

        switch (q.getD() ) {
            case N:
                q.setY(q.getY() + 1);
                break;
            case W:
                q.setX(q.getX() - 1);
                break;
            case S:
               q.setY(q.getY() - 1);
                break;
            case E:
               q.setX(q.getX() + 1);
                break;
            default:
                break;
        }
            return q;

    }
   //si l objet gazon valide l avancement de t ....
   public void RunT(String action) {   //  ici c est preferable de mettre le design pattern strategy
       for (int i=0; i<=action.length()-1; i++) {
               char a=action.charAt(i);
               if(a=='A'){ //avancer
                   valider();
               }else{//pivoter
                  pivolterT(a);
               }
           System.out.println("la tondeuse "+this.getId_t()+" a pour  position now "+this.getP().getX()+" "+this.getP().getY()+" "+this.getP().getD());
           }


}



}
