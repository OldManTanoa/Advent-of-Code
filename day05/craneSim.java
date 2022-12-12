package day05;

import java.util.ArrayList;
import java.util.LinkedList;
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

        while((line = input.nextLine()).charAt(1) != '1') {
            continue;
        }
        
        int stackNumber = line.split("   ").length;

        input.reset();

        return "";
    }
}

class Stacks {
    ArrayList<LinkedList<String>> stacks;

    Stacks(int size) {
        stacks = new ArrayList<LinkedList<String>>();
        
        for (int i = 0; i < size; i++) {
            stacks.add(new LinkedList<String>());
        }
    }

    void move(int from, int to) {
        String moved = stacks.get(from).removeLast();

        stacks.get(to).addLast(moved);
    }

    void add(int to, String added) {
        stacks.get(to).addLast(added);
    }

    String getSol() {
        String result = "";

        for (LinkedList<String> current : stacks) {
            result = ""+result+current.removeLast();
        }

        return result;
    }
}
