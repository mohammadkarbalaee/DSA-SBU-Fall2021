package com.zamgo;

import java.util.Scanner;

public class SpecialSequence {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int arrayLength = in.nextInt();
    int specialSubsequenceLength = in.nextInt();
    long[] array = new long[arrayLength];
    long degree = 0;
    for (int i = 0; i < arrayLength; i++) {
      array[i] = in.nextInt();
    }
    for (int i = 0; i < arrayLength - specialSubsequenceLength; i++) {
      for (int j = i; j < arrayLength; j++){
        int biggerCounter = 0;
        if (array[j] > array[i]){
          biggerCounter++;
          if (biggerCounter == specialSubsequenceLength){
            degree += array[i];
            break;
          } else {
            for (int k = j + 1; k < arrayLength; k++) {
              if (array[k] > array[i]){
                biggerCounter++;
                if (biggerCounter == specialSubsequenceLength){
                  degree += array[i];
                  break;
                }
              } else {
                break;
              }
            }
          }
        }
        if (biggerCounter == specialSubsequenceLength){
          break;
        }
      }
    }
    System.out.println(degree);
  }
}