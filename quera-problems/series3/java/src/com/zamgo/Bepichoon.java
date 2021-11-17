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

        int sortedToIndex = 1;
        for (int i = nutsBoltsQuantity; i < 2 * nutsBoltsQuantity; i++) {
            for (int j = 0; j < nutsBoltsQuantity; j++) {
                char key = nutsBolts[i];
                int beforeProperIndex = sortedToIndex - 1;
                while (beforeProperIndex > 0 && nutsBolts[beforeProperIndex] > key){
                    nutsBolts[beforeProperIndex + 1] = nutsBolts[beforeProperIndex];
                    beforeProperIndex--;
                }
                nutsBolts[beforeProperIndex + 1] = key;
                sortedToIndex++;
            }
        }

        for (int i = 0; i < 2 * nutsBoltsQuantity; i += 2) {
            System.out.print(nutsBolts[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < 2 * nutsBoltsQuantity; i += 2) {
            System.out.print(nutsBolts[i] + " ");
        }
    }
}

/*
the key of solving this problem lies under the partition function in the quick sort algorithm
so, since the first question is about the partition function, let's solve that first and by the knowledge that
you gain there, you can certainly solve this problem easier.

this text is meant to be a reminder, so that you will not forget what the idea here was
 */
