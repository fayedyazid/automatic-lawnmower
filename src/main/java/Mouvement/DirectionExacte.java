package Mouvement;

public class DirectionExacte {

//fonction static pas besoin de creer des objects
    public static Direction calculerLaDirectionSuivante(char action, Direction d) {
        if (action == 'D') {
            if (d == Direction.E){
                return Direction.S;}
            else if (d == Direction.N){
                return Direction.E;}
            else if (d == Direction.W){
                return Direction.N;}
            else if (d == Direction.S){
                return Direction.W;}
        } else if (action == 'G') {
            if (d == Direction.E){
                return Direction.N;}
            else if (d == Direction.N){
                return Direction.W;}
            else if (d == Direction.W){
                return Direction.S;}
            else if (d == Direction.S){
                return Direction.E;}
        } else {
            return null;
        }
return null;
    }//calculer la position suivante
}
