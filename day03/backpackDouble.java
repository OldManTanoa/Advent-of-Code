package day03;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class backpackDouble {
    
    public static void main(String[] args) throws FileNotFoundException {
        //doubleItemSearch(new File("day03\\fileInput.txt"));
        keySearch(new File("day03\\fileInput.txt"));
    }

    public static void keySearch(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        String bag1, doubleItem = "", bag2, bag3;
        String[] bag1Array,bag2Array, bag3Array;
        int totalValue = 0, value = 0;

        while (input.hasNext()) {
            bag1 = input.next();
            bag2 = input.next();
            bag3 = input.next();

            bag1Array = stringArray(bag1);
            bag2Array = stringArray(bag2);
            bag3Array = stringArray(bag3);

            for (int i = 0; i < bag1Array.length; i++) {
                for (int j = 0; j < bag2Array.length; j++) {
                    for (int k = 0; k < bag3Array.length; k++) {
                        if (bag1Array[i].equals(bag2Array[j]) && bag2Array[j].equals(bag3Array[k])) {
                            doubleItem = bag1Array[i];
                            i = bag1Array.length;
                            j = bag2Array.length;
                            k = bag3Array.length;
                        }
                    }
                }
            }

            value = converter(doubleItem);
            totalValue += value;
        }

        System.out.println("Total value is " + totalValue);
        input.close();
    }

    public static void doubleItemSearch(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        String currentBag, doubleItem = "", firstHalf, secondHalf;
        String[] firstpart,secondpart;
        int bagLength, totalValue = 0, value = 0;

        while (input.hasNext()) {
            currentBag = input.next();
            bagLength = currentBag.length();
            firstHalf = currentBag.substring(0,bagLength/2);
            secondHalf = currentBag.substring(bagLength/2);

            firstpart = stringArray(firstHalf);
            secondpart = stringArray(secondHalf);

            for (int i = 0; i < firstpart.length; i++) {
                for (int j = 0; j < secondpart.length; j++) {
                    if (firstpart[i].equals(secondpart[j])) {
                        doubleItem = firstpart[i];
                        j = secondpart.length;
                        i = firstpart.length;
                        System.out.println("Found item "+doubleItem);
                    }
                }
            }

            value = converter(doubleItem);
            totalValue += value;
        }

        System.out.println("Total Value is "+totalValue);
        input.close();
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
