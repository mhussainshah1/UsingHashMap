package com.company;

import java.io.File;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Map<Integer, String> myMap = new HashMap<>();
        Scanner keyboard = new Scanner(System.in);
        int k;
        String v;

        while (true) {
            System.out.print("Enter a number or -1 to quit: ");
            k = keyboard.nextInt();
            if (k == -1) {
                break;
            } else {
                if (myMap.containsKey(k)) {
                    System.out.println("You entered " + myMap.get(k));
                } else {
                    System.out.print("Not found!!! Enter number in alphabet: ");
                    v = keyboard.next();
                    myMap.put(k, v);
                }
            }
        }

        File file = new File("out\\production\\UsingHashMap\\com\\company\\test.txt");

        //Writing
        Formatter f = new Formatter(file);
        for (Integer key : myMap.keySet()) {
            f.format("%s %s", key, myMap.get(key) + "\r\n");
        }
        f.close();

        //Reading
        Scanner scannerInput = new Scanner(file);
        String line;
        while (scannerInput.hasNextLine()) {
            line = scannerInput.nextLine();
            System.out.println(line);
        }
    }
}
