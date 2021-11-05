package com.zamgo;

import java.util.Scanner;

public class Second {

    private static long[] numbers;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        numbers = new long[n];
        getArray(console, n, numbers);
        System.out.println(boxQuantity());
    }

    private static int boxQuantity() {
        int boxQuantity = 0;
        for (int i = 0; i < numbers.length; i++) {
            int count = 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]){
                    count++;
                }
            }
            if(boxQuantity < count){
                boxQuantity = count;
            }
        }
        return boxQuantity;
    }

    private static void getArray(Scanner cin, int n, long[] numbers) {
        for (int i = 0; i < n; i++) {
            numbers[i] = cin.nextInt();
        }
    }
}