package Panoplie;


import Mouvement.PositionOriente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gazon {
    private int Hauteur=5;
    private int Largeur=5;



    //verifier si la position n est pas en d 'hors  du champs de gazon
    public boolean validerposition(PositionOriente p) {
        if ( p.getX() <= this.Largeur && p.getX() >= 0 && p.getY() <= this.Hauteur && p.getY() >= 0)
        { return true;}
        else  {return false;}
    }




}
