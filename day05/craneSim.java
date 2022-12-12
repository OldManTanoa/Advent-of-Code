package day05;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class craneSim {
    
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("Solution to part 1 is "+topOfStack(new File("day05\\fileInput.txt")));
    }

    public static String topOfStack(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        String[] platform;
        String line;
        int a = 1;

        while(a == 1) {
            line = input.nextLine();
            System.out.println(line);
            a= 0;
        }

        return "";
    }
}
