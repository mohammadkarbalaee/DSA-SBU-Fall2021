package com.zamgo;

import javafx.scene.transform.Scale;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testsQuantity = in.nextInt();
    int[][] testArrays = new int[testsQuantity][];
    for (int i = 0; i < testsQuantity; i++) {
      int testArrayLength = in.nextInt();
      int[] testArray = new int[testArrayLength];
      for (int j = 0; j < testArrayLength; j++) {
        testArray[j] = in.nextInt();
      }
      testArrays[i] = testArray;
    }

    System.out.println(Arrays.deepToString(testArrays));
  }

  public static int hoarePartition(int[] array, int startIndex, int endIndex){
    int pivot = array[startIndex];
    int i = startIndex - 1;
    int j = endIndex + 1;

    while (true) {
      do {
        i++;
      } while (array[i] < pivot);

      do {
        j--;
      } while (array[j] > pivot);

      if (i >= j) {
        return j;
      }

       swap(array,i,j);
    }
  }

  public static int lomutoPartition(int[] array,int startIndex, int endIndex){
    int pivot = array[endIndex];
    int startOfLeftHalf = startIndex - 1;
    for (int startOfRightHalf = startIndex; startOfRightHalf < endIndex - 1; startOfRightHalf++) {
      if (array[startOfRightHalf] <= pivot){
        startOfLeftHalf++;
        swap(array,startOfLeftHalf,startOfRightHalf);
      }
    }
    swap(array,startOfLeftHalf + 1,endIndex);
    return startOfLeftHalf + 1;
  }

  public static int lomutoQuickSort(int[] array,int startIndex, int endIndex){
    int count = 0;
    if (startIndex < endIndex){
      int previousPivotIndex = lomutoPartition(array,startIndex,endIndex);
      count += lomutoPartition(array,startIndex,previousPivotIndex);
      count++;
      count += lomutoPartition(array,previousPivotIndex + 1,endIndex);
      count++;
    }
    return count;
  }

  public static int hoareQuickSort(int[] array,int startIndex, int endIndex){
    int count = 0;
    if (startIndex < endIndex){
      int previousPivotIndex = hoarePartition(array,startIndex,endIndex);
      count += lomutoPartition(array,startIndex,previousPivotIndex);
      count++;
      count += lomutoPartition(array,previousPivotIndex + 1,endIndex);
      count++;
    }
    return count;
  }

  private static void swap(int[] array,int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}