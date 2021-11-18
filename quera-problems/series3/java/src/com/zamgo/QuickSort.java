package com.zamgo;

import java.util.Scanner;

public class QuickSort {

  public static long[] hoareCounts;
  public static long[] lomutoCounts;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testsQuantity = in.nextInt();
    long[][] testArraysLomuto = new long[testsQuantity][];
    long[][] testArraysHoare = new long[testsQuantity][];
    hoareCounts = new long[testsQuantity];
    lomutoCounts = new long[testsQuantity];
    for (int i = 0; i < testsQuantity; i++){
      int testArrayLength = in.nextInt();
      long[] testArrayLomuto = new long[testArrayLength];
      long[] testArrayHoare = new long[testArrayLength];
      for (int j = 0; j < testArrayLength; j++) {
        int input = in.nextInt();
        testArrayLomuto[j] = input;
        testArrayHoare[j] = input;
      }
      lomutoCounts[i] = 0;
      hoareCounts[i] = 0;
      testArraysLomuto[i] = testArrayLomuto;
      testArraysHoare[i] = testArrayHoare;
    }
    for (int i = 0; i < testsQuantity; i++){
      System.out.println(chooseEfficient(testArraysLomuto[i],testArraysHoare[i],i));
    }
  }

  public static String chooseEfficient(long[] lomutoTestCase,long[] hoareTestCase,int countIndex){
    lomutoQuickSort(lomutoTestCase,0,lomutoTestCase.length - 1,countIndex);
    hoareQuickSort(hoareTestCase,0,hoareTestCase.length - 1,countIndex);
//    System.out.println(lomutoCounts[countIndex]);
//    System.out.println(hoareCounts[countIndex]);
    if (lomutoCounts[countIndex] > hoareCounts[countIndex]){
      return "HR";
    } else if(hoareCounts[countIndex] > lomutoCounts[countIndex]){
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

  public static void lomutoQuickSort(long[] array,int startIndex, int endIndex,int countIndex){
    lomutoCounts[countIndex]++;
    if (startIndex < endIndex){
      int previousPivotIndex = lomutoPartition(array,startIndex,endIndex);
      lomutoQuickSort(array,startIndex,previousPivotIndex - 1,countIndex);
      lomutoQuickSort(array,previousPivotIndex + 1,endIndex,countIndex);
    }
  }

  public static void hoareQuickSort(long[] array,int startIndex, int endIndex,int countIndex){
    hoareCounts[countIndex]++;
    if (startIndex < endIndex){
      int previousPivotIndex = hoarePartition(array,startIndex,endIndex);
      hoareQuickSort(array,startIndex,previousPivotIndex - 1,countIndex);
      hoareQuickSort(array,previousPivotIndex + 1,endIndex,countIndex);
    }
  }

  private static void swap(long[] array,int i,int j){
    long temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}