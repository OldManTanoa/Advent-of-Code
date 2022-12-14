package day06;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class signalFinder {
    
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("Solution to part 1 is "+markerFinder(new File("day06\\fileInput.txt")));
    }

    public static int markerFinder(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        String[] last = new String[4];
        int result = 0;
        
        String signal = input.next();
        String[] charArr = new String[signal.length()];

        for (int i = 0; i < signal.length(); i++) {
            charArr[i] = signal.substring(i,i+1);
        }

        for(int i = 0; i < 4; i++) {
            last[i] = charArr[i];
        }

        for(int i = 4; i < charArr.length; i++) {

        }

        return result;
    }
}
