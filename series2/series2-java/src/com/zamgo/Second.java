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
        int boxQuantity = 1;
        for (int i = 0; i < numbers.length; i++) {
            int maxIndex = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] > numbers[maxIndex]){
                    maxIndex = j;
                }
            }
            swap(maxIndex,i);
            if (i != 0){
                if(numbers[i] == numbers[i - 1]){
                    boxQuantity++;
                    for (int j = i + 1; j < numbers.length; j++) {
                        if (numbers[j] < numbers[i]){
                            swap(i,j);
                        }
                    }
                }
            }
        }
        return boxQuantity;
    }

    private static void getArray(Scanner cin, int n, long[] numbers) {
        for (int i = 0; i < n; i++) {
            numbers[i] = cin.nextInt();
        }
    }

    private static void swap(int i,int j) {
        long temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}