package day01;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class calorieCounter {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\zoggr\\OneDrive\\Big comp\\Dokumente\\VSS\\Git projects\\Advent-of-Code\\day01\\fileInput.txt"));
        int max = 0;
        int currentTotal = 0;
        String line = input.nextLine();
        Scanner lineread = new Scanner(line);
        while (input.hasNextInt()) {
            while (lineread.hasNextInt()) {
                int next = lineread.nextInt();
                System.out.println("Looking at "+next);
                currentTotal+= next;
                if (currentTotal > max) {
                    max = currentTotal;
                }

                line = input.nextLine();
                lineread = new Scanner(line);
            }
            
            currentTotal = 0;
            line = input.nextLine();
            lineread = new Scanner(line);
        }

        System.out.println("Max is " + max);
        lineread.close();
        input.close();
    }
}
