package model;

import model.Coordinate;

public class Tools {
    public static Coordinate[] add(Coordinate [] coordinates,Coordinate c){
        Coordinate[]  aux = new Coordinate[coordinates.length+1];
        System.arraycopy(coordinates
        ,0,aux,0,coordinates.length);
        aux[aux.length-1]=c;
        return  aux;
        
        
    }
}
