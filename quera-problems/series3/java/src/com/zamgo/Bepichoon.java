package com.zamgo;

import java.util.Scanner;

public class Bepichoon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nutsBoltsQuantity = in.nextInt();
        char[] nutsBolts = new char[2 * nutsBoltsQuantity];
        for (int i = 0; i < 2 * nutsBoltsQuantity; i++) {
            nutsBolts[i] = in.next().charAt(0);
        }
        for (int i = nutsBoltsQuantity; i < 2 * nutsBoltsQuantity; i++) {
            for (int j = 1; j < nutsBoltsQuantity; j++) {
                char key = nutsBolts[i];
                int beforeProperIndex = i - 1;
                while (beforeProperIndex > 0 && nutsBolts[beforeProperIndex] > key){
                    nutsBolts[beforeProperIndex + 1] = nutsBolts[beforeProperIndex];
                    beforeProperIndex--;
                }
                nutsBolts[beforeProperIndex + 1] = key;
            }
        }
        System.out.println(nutsBolts);
//        for (int i = 0; i < 2 * nutsBoltsQuantity; i += 2) {
//            System.out.print(nutsBolts[i] + " ");
//        }
//        System.out.println();
//        for (int i = 1; i < 2 * nutsBoltsQuantity; i += 2) {
//            System.out.print(nutsBolts[i] + " ");
//        }

    }
}