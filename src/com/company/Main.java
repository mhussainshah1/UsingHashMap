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

        File file = new File("out\\production\\UsingHashMap\\com\\company\\test.txt");

        if(file.exists()){
            //Reading
            Scanner scannerInput = new Scanner(file);
            String line;
            while (scannerInput.hasNextLine()) {
                line = scannerInput.nextLine();
                System.out.println(line);
            }

            //file into hashmap
            scannerInput = new Scanner(file);
            while (scannerInput.hasNext()) {
                k = scannerInput.nextInt();
                v = scannerInput.next();
                myMap.put(k, v);
//                System.out.println(k+ " " +v);
            }
            scannerInput.close();
        }

        while (true) {
            System.out.print("Prompt: Enter a number or -1 to quit: ");
            k = keyboard.nextInt();
            if (k == -1) {
                break;
            } else {
                if (myMap.containsKey(k)) {
                    System.out.println ("Response: You entered " + myMap.get(k));
                } else {
                    System.out.print("Not found!!! Enter number in alphabet: ");
                    v = keyboard.next();
                    myMap.put(k, v);
                }
            }
        }
        //Writing
        Formatter f = new Formatter(file);
        for (Integer key : myMap.keySet()) {
            f.format("%s %s", key, myMap.get(key) + "\r\n");
        }
        f.close();
    }
}
