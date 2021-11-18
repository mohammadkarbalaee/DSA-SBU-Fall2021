package com.zamgo;

import java.util.Scanner;

public class SpecialSequence {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int arrayLength = in.nextInt();
    int specialSubsequenceLength = in.nextInt();
    int[] array = new int[arrayLength];
    int degree = 0;
    for (int i = 0; i < arrayLength; i++) {
      array[i] = in.nextInt();
    }
    for (int i = 0; i < arrayLength - specialSubsequenceLength; i++) {
      for (int j = i + 1; j < arrayLength; j++) {
        boolean biggerFound = false;
        if (array[j] > array[i]){
          int basesFound = 1;
          int newBase = array[j];
          for (int k = j + 1; k < arrayLength; k++) {
            if (array[k] > newBase){
              newBase = array[k];
              basesFound++;
              if (basesFound == specialSubsequenceLength){
                biggerFound = true;
                break;
              }
            } else {
              break;
            }
          }
        }
        if (biggerFound){
          degree += array[i];
        }
      }
    }
    System.out.println(degree);
  }
}