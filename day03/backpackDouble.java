package day03;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileStore;

public class backpackDouble {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("day03\\fileInput.txt"));

        String currentBag, doubleItem, firstHalf, secondHalf;
        String[] firstpart,secondpart;
        int bagLength;

        while (input.hasNext()) {
            currentBag = input.next();
            bagLength = currentBag.length();
            firstHalf = currentBag.substring(0,bagLength/2);
            secondHalf = currentBag.substring(bagLength/2);

            firstpart = stringArray(firstHalf);
            secondpart = stringArray(secondHalf);

            for (int i = 0; i < firstpart.length; i++) {
                if (firstpart[i].equals(secondPart[j]));
            }
        }
    }

    public static int converter(String s) {
        String[] compare = new String[] {null,"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        for (int i = 0; i < compare.length; i++) {
            if (s.equals(compare[i])) {
                return i;
            }
        }

        return 0;
    }

    public static String[] stringArray(String s) {
        String[] result = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            result[i] = s.substring(i, i+1);
        }

        return result;
    }
}
