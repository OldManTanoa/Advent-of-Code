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
        int highest = 0;

        while((line = input.nextLine()).charAt(1) != '1') {
            highest++;
            continue;
        }

        int stackNumber = line.split("   ").length;

        input = new Scanner(file);

        Stacks stack = new Stacks(stackNumber);

        while (input.hasNextLine() && (line = input.nextLine()).charAt(1) != '1') {
			for (int i = 0; i < stackNumber; i++) {
				String toAdd = line.substring(1+4*i, 2+4*i);
				if (!toAdd.equals(" ")) {
					stack.stacks.get(i).addLast(toAdd);
				}
			}
		}
        
        //skip a line
        input.nextLine();
        
        while (input.hasNext()) {
            //skip move
            input.next();
            int amount = input.nextInt();
            //skip from
            input.next();
            int from = input.nextInt();
            //skip to
            input.next();
            int to = input.nextInt();

            for (int i = 0; i < amount; i++) {
                stack.move(from-1, to-1);
            }
        }
        return stack.getSol();
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
            result = ""+result+current.removeFirst();
        }

        return result;
    }
}
