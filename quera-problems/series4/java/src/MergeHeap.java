import java.util.Arrays;
import java.util.Scanner;

public class MergeHeap {

  private static int[] minHeapArray;
  private static int heapSize;

  public static void main(String[] args) {
    Scanner input =  new Scanner(System.in);
    int numberOfSortedArrays = input.nextInt();
    int[][] sortedArrays = new int[numberOfSortedArrays][];
    int mergedArrayLength = 0;
    for (int i = 0; i < numberOfSortedArrays; i++) {
      int sortedArrayLength = input.nextInt();
      mergedArrayLength += sortedArrayLength;
      int[] sortedArray = new int[sortedArrayLength];
      for (int j = 0; j < sortedArrayLength; j++) {
        sortedArray[j] = input.nextInt();
      }
      sortedArrays[i] = sortedArray;
    }

    minHeapArray = new int[numberOfSortedArrays];
    for (int i = 0; i < numberOfSortedArrays; i++) {
      minHeapArray[i] = sortedArrays[i][0];
    }
    heapSize = minHeapArray.length;

    buildMinHeap();



    int[] mergedArray = new int[mergedArrayLength];
  }

  public static void buildMinHeap(){
    for (int i = (int) Math.floor((minHeapArray.length - 1) / 2.0); i >= 0; i--) {
      minHeapify(i);
    }
  }

  private static void minHeapify(int brokenIndex){
    int left =left(brokenIndex);
    int right = right(brokenIndex);
    int indexOfSmallest = brokenIndex;

    if(left < heapSize && minHeapArray[left] < minHeapArray[indexOfSmallest]){
      indexOfSmallest = left;
    }

    if(right < heapSize && minHeapArray[right] < minHeapArray[indexOfSmallest]){
      indexOfSmallest = right;
    }

    if (indexOfSmallest != brokenIndex){
      swap(indexOfSmallest,brokenIndex);
      minHeapify(indexOfSmallest);
    }
  }

  private static int parent(int index){
    return (int) Math.floor(index / 2.0);
  }

  private static int left(int index){
    return 2 * index + 1;
  }

  private static int right(int index){
    return  (2 * index) + 2;
  }

  private static void swap(int i,int j){
    int temp = minHeapArray[i];
    minHeapArray[i] = minHeapArray[j];
    minHeapArray[j] = temp;
  }
}
