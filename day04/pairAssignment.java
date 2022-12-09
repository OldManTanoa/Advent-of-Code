package day04;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileStore;

public class pairAssignment {
    
    public static void main(String[] args) throws FileNotFoundException {
        pairAmount(new File("day04\\fileInput.txt"));
    }

    public static void pairAmount(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        String line;
        int counter = 0, seg1Start, seg1End, seg2Start, seg2End;

        while (input.hasNext()) {
            line = input.next();

            seg1Start = line.substring(0,1);
            System.out.println(line);
        }
    }

    public static int converter(String s) {
        Scanner input = new Scanner(s);

        int result = input.nextInt();

        input.close();
        return result;
    }

}
