import java.util.Arrays;
import java.util.Scanner;

public class MergeHeap {
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

    int[] minHeapArray = new int[numberOfSortedArrays];
    for (int i = 0; i < numberOfSortedArrays; i++) {
      minHeapArray[i] = sortedArrays[i][0];
    }

    System.out.println(Arrays.toString(minHeapArray));

    int[] mergedArray = new int[mergedArrayLength];
  }
}
