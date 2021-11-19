package com.zamgo;

import java.util.Scanner;

public class QuickSort {

  public static int hoareCounts = 0;
  public static int lomutoCounts = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testsQuantity = in.nextInt();
    long[][] testArraysLomuto = new long[testsQuantity][];
    long[][] testArraysHoare = new long[testsQuantity][];
    for (int i = 0; i < testsQuantity; i++){
      int testArrayLength = in.nextInt();
      long[] testArrayLomuto = new long[testArrayLength];
      long[] testArrayHoare = new long[testArrayLength];
      for (int j = 0; j < testArrayLength; j++) {
        long input = in.nextLong();
        testArrayLomuto[j] = input;
        testArrayHoare[j] = input;
      }
      testArraysLomuto[i] = testArrayLomuto;
      testArraysHoare[i] = testArrayHoare;
    }
    for (int i = 0; i < testsQuantity; i++){
      System.out.println(chooseEfficient(testArraysLomuto[i],testArraysHoare[i]));
    }
  }

  public static String chooseEfficient(long[] lomutoTestCase,long[] hoareTestCase){
    lomutoCounts = 0;
    hoareCounts = 0;
    lomutoQuickSort(lomutoTestCase,0,lomutoTestCase.length - 1);
    hoareQuickSort(hoareTestCase,0,hoareTestCase.length - 1);
    if (lomutoCounts > hoareCounts){
      return "HR";
    } else if(hoareCounts > lomutoCounts){
      return "LMT";
    } else {
      return "TIE";
    }
  }

  public static int hoarePartition(long[] array, int startIndex, int endIndex){
    long pivot = array[startIndex];
    int i = startIndex - 1;
    int j = endIndex + 1;

    while (true) {
      do {
        i++;
      }
      while (array[i] < pivot);
      do {
        j--;
      }
      while (array[j] > pivot);
      if (i >= j) {
        return j;
      } else {
        swap(array,i,j);
      }
    }
  }

  public static int lomutoPartition(long[] array,int startIndex, int endIndex){
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

  public static void lomutoQuickSort(long[] array,int startIndex, int endIndex){
    lomutoCounts++;
    if (startIndex < endIndex){
      int previousPivotIndex = lomutoPartition(array,startIndex,endIndex);
      lomutoQuickSort(array,startIndex,previousPivotIndex - 1);
      lomutoQuickSort(array,previousPivotIndex + 1,endIndex);
    }
  }

  public static void hoareQuickSort(long[] array,int startIndex, int endIndex){
    hoareCounts++;
    if (startIndex < endIndex){
      int previousPivotIndex = hoarePartition(array,startIndex,endIndex);
      hoareQuickSort(array,startIndex,previousPivotIndex);
      hoareQuickSort(array,previousPivotIndex + 1,endIndex);
    }
  }

  private static void swap(long[] array,int i,int j){
    long temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}