package day06;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class signalFinder {
    
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("Solution to part 1 is "+markerFinder(new File("day06\\fileInput.txt")));
        System.out.println("Solution to part 2 is "+markerFinder14(new File("day06\\fileInput.txt")));
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
            if (noneEqual(last[0], last[1], last[2], last[3])) {
                result = i;
                input.close();
                return result;
            }

            last[0] = last[1];
            last[1] = last[2];
            last[2] = last[3];
            last[3] = charArr[i];
        }
        
        input.close();
        return result;
    }

    public static int markerFinder14(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        int result = 0;
        
        String signal = input.next();
        String[] charArr = new String[signal.length()];

        for (int i = 0; i < signal.length(); i++) {
            charArr[i] = signal.substring(i,i+1);
        }

        for(int i = 14; i < charArr.length; i++) {
            if (noneEqual14(charArr, i)) {
                result = i;
                input.close();
                return result;
            }
        }
        
        input.close();
        return result;
    }

    public static boolean noneEqual(String a, String b, String c, String d) {
        return !(a.equals(b)||a.equals(c)||a.equals(d)||b.equals(c)||b.equals(d)||c.equals(d));
    }

    public static boolean noneEqual14(String[] chars, int end) {
        int start = end-14 ;

        for (int i = start; i < end; i++) {
            for (int j = i+1; j < end; j++) {
                if (chars[i].equals(chars[j])) {
                    return false;
                }
            }
        }

        return true;
    }

}
