package com.zamgo;

public class QuickSort {
  public static void main(String[] args) {

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

  public static void lomutoQuickSort(int[] array,int startIndex, int endIndex){
    if (startIndex < endIndex){
      int previousPivotIndex = lomutoPartition(array,startIndex,endIndex);
      lomutoPartition(array,startIndex,previousPivotIndex - 1);
      lomutoPartition(array,previousPivotIndex + 1,endIndex);
    }
  }

  public static void HoareQuickSort(int[] array,int startIndex, int endIndex){
    if (startIndex < endIndex){
      int previousPivotIndex = hoarePartition(array,startIndex,endIndex);
      lomutoPartition(array,startIndex,previousPivotIndex - 1);
      lomutoPartition(array,previousPivotIndex + 1,endIndex);
    }
  }

  private static void swap(int[] array,int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}