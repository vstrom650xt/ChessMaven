package tools;


import model.Coordinate;
import model.Piece;

import java.util.Scanner;

import static controller.Game.*;

public class Input {
    public static String getString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

    public static int getInteger(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextInt()) {
            System.out.println("Error. You have to enter a integer number.");
            sc.next();
        }
        return sc.nextInt();
    }


    public static float getFloat(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextFloat()) {
            System.out.println("Error. You have to enter a float number.");
            sc.next();
        }
        return sc.nextFloat();
    }

   public static char getChar(String message){
       Scanner sc = new Scanner(System.in);
       System.out.println(message);

        return sc.nextLine().toUpperCase().charAt(0);


   }

   public static Coordinate askCoordinate(){
       Scanner sc = new Scanner(System.in);
       String coordinate;
       Coordinate cord;

       do {
           coordinate = sc.next().toUpperCase().trim();
           if (!longEnought(coordinate)) {
               System.out.println("la coordenada debe estar formada por dos caracteres");
           } else if (!correctFormat(coordinate)) {
               System.out.println("ponga primero  la letra y el numero  luego");
           } else if (!isLetter(coordinate)) {
               System.out.println("la letra debe estar entre la A y la H");
           } else if (!isNumber(coordinate)) {
               System.out.println("el numero  debe estar entre el 1 y el 8");
           }

       } while (!longEnought(coordinate) || !isLetter(coordinate) || !isNumber(coordinate) || !correctFormat(coordinate));
       cord = new Coordinate((char) translateCoorLetter(coordinate), translateCoorNum(coordinate));

       return cord;
   }
}
