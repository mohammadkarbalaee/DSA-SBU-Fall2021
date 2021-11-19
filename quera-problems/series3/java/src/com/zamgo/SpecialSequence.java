package com.zamgo;

import java.util.Scanner;

public class SpecialSequence {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int arrayLength = in.nextInt();
    int specialSubsequenceLength = in.nextInt();
    long[] array = new long[arrayLength];
    long degree = 0;
    for (int i = 0; i < arrayLength; i++){
      array[i] = in.nextInt();
    }
    quickSort(array,0,arrayLength - 1);
    for (int i = 0; i < arrayLength - specialSubsequenceLength; i++){
      degree += array[i];
    }
    System.out.println(degree);
  }

  public static int partition(long[] array,int startIndex, int endIndex){
    long pivot = array[endIndex];
    int startOfLeftHalf = startIndex - 1;
    for (int startOfRightHalf = startIndex; startOfRightHalf < endIndex; startOfRightHalf++) {
      if (array[startOfRightHalf] <= pivot){
        startOfLeftHalf++;
        swap(array,startOfLeftHalf,startOfRightHalf);
      }
    }
    swap(array,startOfLeftHalf + 1,endIndex);
    return startOfLeftHalf + 1;
  }

  public static void quickSort(long[] array,int startIndex, int endIndex){
    if (startIndex < endIndex){
      int previousPivotIndex = partition(array,startIndex,endIndex);
      quickSort(array,startIndex,previousPivotIndex - 1);
      quickSort(array,previousPivotIndex + 1,endIndex);
    }
  }

  private static void swap(long[] array,int i,int j){
    long temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}