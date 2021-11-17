package com.zamgo;

import java.util.Scanner;

public class First {

  private static long[] numbers;
  private static int n;

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    n = console.nextInt();
    numbers = new long[n];
    getArray(console, n, numbers);
    System.out.print(getPermutation());
  }

  private static void getArray(Scanner cin, int n, long[] numbers) {
    for (int i = 0; i < n; i++) {
      numbers[i] = cin.nextInt();
    }
  }

  private static void selectionSort(){
    for (int i = 0; i < numbers.length - 1; i++) {
      int leastIndex = i;
      for (int j = i; j < numbers.length; j++) {
        if (numbers[j] < numbers[leastIndex]){
          leastIndex = j;
        }
      }
      swap(leastIndex,i);
    }
  }

  private static void swap(int i,int j) {
    long temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
  }

  private static long getPermutation() {
    selectionSort();
    long result = 0;
    for (int i = 0; i < n; i++) {
      result += Math.abs(numbers[i] - (i + 1));
    }
    return result;
  }
}