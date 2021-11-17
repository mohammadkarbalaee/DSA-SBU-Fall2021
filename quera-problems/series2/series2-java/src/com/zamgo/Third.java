package com.zamgo;

import java.util.Scanner;

public class Third {

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    int n = console.nextInt();
    int[] numbers = new int[n];
    getArray(console, n, numbers);
    System.out.println(mergeSortAndCount(numbers, 0, numbers.length - 1) % 100000);
  }

  private static void getArray(Scanner cin, int n, int[] numbers){
    for (int i = 0; i < n; i++) {
      numbers[i] = cin.nextInt();
    }
  }

  private static long mergeAndCount(int[] numbers, int leftIndex, int middleIndex, int rightIndex) {

    int[] leftArray = new int[middleIndex - leftIndex + 1];
    int[] rightArray = new int[rightIndex - middleIndex];

    for (int i = 0; i < leftArray.length; i++){
      leftArray[i] = numbers[leftIndex + i];
    }
    for (int i = 0; i < rightArray.length; i++){
      rightArray[i] = numbers[middleIndex + i + 1];
    }

    int i = 0;
    int j = 0;
    int k = leftIndex;
    long inversions = 0;

    while (i < leftArray.length && j < rightArray.length){
      if (leftArray[i] <= rightArray[j]){
        numbers[k++] = leftArray[i++];
      } else {
        numbers[k++] = rightArray[j++];
        inversions += (middleIndex + 1) - (leftIndex + i);
      }
    }
    while (i < leftArray.length){
      numbers[k++] = leftArray[i++];
    }
    while (j < rightArray.length){
      numbers[k++] = rightArray[j++];
    }
    return inversions;
  }

  private static long mergeSortAndCount(int[] numbers, int left, int right){
    long count = 0;
    if (left < right) {
      int middle = (int) Math.floor((left + right) / 2.0);
      count += mergeSortAndCount(numbers, left, middle);
      count += mergeSortAndCount(numbers, middle + 1, right);
      count += mergeAndCount(numbers, left, middle, right);
    }
    return count;
  }
}