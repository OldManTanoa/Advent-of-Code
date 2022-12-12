package day04;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class pairAssignment {

    public static void main(String[] args) throws FileNotFoundException {
        pairAmount(new File("day04\\fileInput.txt"));
    }

    public static void pairAmount(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        String line;
        int counter = 0;

        while (input.hasNext()) {
            line = input.next();

            int[] segments = converter(line);

            if (segments[0] <= segments[2] && segments[1] >= segments[3]) {
                counter++;
            }
        }

        System.out.println("Amount is " + counter);
    }

    public static int[] converter(String s) {
        int[] result = new int[4];
        String[] tmp = new String[s.length()];
        int breakMark = 0, dashMark = 0;

        for (int i = 0; i < s.length(); i++) {
            tmp[i] = s.substring(i, i + 1);
        }

        // find where the two sections are separated
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].equals(",")) {
                breakMark = i;
            }
        }

        // extract values for first and second section
        for (int i = 0; i < breakMark; i++) {
            if (tmp[i].equals("-")) {
                dashMark = i;
            }
        }

        Scanner reader;

        for (int i = 0; i < dashMark; i++) {
            reader = new Scanner(tmp[i]);

            String valString = reader.next();
            int val = (int) (Integer.parseInt(valString) * Math.pow(10, (dashMark - 1 - i)));
            result[0] += val;
        }

        for (int i = dashMark + 1; i < breakMark; i++) {
            reader = new Scanner(tmp[i]);

            String valString = reader.next();
            int val = (int) (Integer.parseInt(valString) * Math.pow(10, (breakMark - 1 - i)));
            result[1] += val;
        }

        // repeat the same for the second section

        for (int i = breakMark; i < tmp.length; i++) {
            if (tmp[i].equals("-")) {
                dashMark = i;
                i = tmp.length;
            }
        }

        for (int i = breakMark+1; i < dashMark; i++) {
            reader = new Scanner(tmp[i]);

            String valString = reader.next();
            int val = (int) (Integer.parseInt(valString) * Math.pow(10, (dashMark - 1 - i)));
            result[2] += val;
        }

        for (int i = dashMark + 1; i < breakMark; i++) {
            reader = new Scanner(tmp[i]);

            String valString = reader.next();
            int val = (int) (Integer.parseInt(valString) * Math.pow(10, (breakMark - 1 - i)));
            result[3] += val;
        }

        return result;
    }

}
