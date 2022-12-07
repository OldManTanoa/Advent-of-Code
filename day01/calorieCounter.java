package day01;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class calorieCounter {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\zoggr\\OneDrive\\Big comp\\Dokumente\\VSS\\Git projects\\Advent-of-Code\\day01\\fileInput.txt"));
        int max = 0;

        while (input.hasNextLine()) {
            String line = input.next();
            Scanner lineRead = new Scanner(line);
            int currentTotal = 0;
            
            while (!line.equals("")) {
                int next = lineRead.nextInt();
                currentTotal += next;
                if (currentTotal > max) {
                    max = currentTotal;
                    System.out.println("Set max to "+max);
                }
                line = input.nextLine();
                lineRead = new Scanner(line);
            }

            lineRead.close();
        }

        System.out.println("Max is " + max);

        input.close();
    }
}
