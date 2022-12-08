package day02;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class rpsGuide {
    public static void main(String args[]) throws FileNotFoundException {

        Scanner input = new Scanner(new File("day02\\fileInput.txt"));

        String opponent;
        String me;

        int win = 0;
        int points;
        int pointTotal = 0;

        while (input.hasNext()) {
            opponent = input.next();
            me = input.next();

            if (opponent.equals("A")) {
                if (me.equals("X")) {
                    win = 0;
                    points = 1;
                } else if (me.equals("Y")) {
                    win = 1;
                    points = 2;
                }else {
                    win = -1;
                    points = 3;  
                }
            } else if (opponent.equals("B")) {
                if (me.equals("X")) {
                    win = -1;
                    points = 1;
                } else if (me.equals("Y")) {
                    win = 0;
                    points = 2;
                }else {
                    win = 1;
                    points = 3;  
                }
            } else {
                if (me.equals("X")) {
                    win = 1;
                    points = 1;
                } else if (me.equals("Y")) {
                    win = -1;
                    points = 2;
                }else {
                    win = 0;  
                    points = 3;   
                }
            }

            if (win == 1) {
                points += 6;
            } else if (win == 0) {
                points += 3;
            }

            pointTotal += points;
        }

        System.out.println("Point total is: "+pointTotal);
    }
}
