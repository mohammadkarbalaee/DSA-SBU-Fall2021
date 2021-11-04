package com.zamgo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declarations
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int timeCounter = 0;
        int inputNumber;
        ArrayList<Integer> numbers = new ArrayList<>();
        //getting the input numbers
        for (int i = 0; i < n; i++) {
            inputNumber = console.nextInt();
            numbers.add(inputNumber);
        }
        //main operations
        int leastDifference;
        int varyingDifference;
        for (int i = 1; i <= n; i++) {
            leastDifference = Math.abs(numbers.get(0) - i);
            for (int j = 1; j < n; j++) {
                varyingDifference = Math.abs(numbers.get(j) - i);
                if(varyingDifference < leastDifference){
                    leastDifference = varyingDifference;
                }
            }
            timeCounter += leastDifference;
        }
        System.out.println(timeCounter);
    }
}