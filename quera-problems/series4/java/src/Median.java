import java.util.Arrays;
import java.util.Scanner;

public class Median {

  private static int[] array;
  private static int heapSize;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int arrayLength = input.nextInt();
    array = new int[arrayLength + 1];
    array[0] = 0;
    for (int i = 1; i < arrayLength + 1; i++) {
      array[i] = input.nextInt();
    }
    heapSize = array.length - 1;
    heapSort();
    boolean isLengthOdd = isOdd(arrayLength);
    for (int i = 1; i <= arrayLength; i++) {
      System.out.println(findMedian(i, isLengthOdd));
    }
  }

  private static double findMedian(int subArrayLength,boolean isLenthOdd){
    double median = 0;
    double middleIndex = (subArrayLength + 1) / 2;
    System.out.println("mid " + middleIndex);
    if (isLenthOdd){
      median = array[(int) middleIndex];
    } else {
      median = (array[(int) Math.floor(middleIndex)] + array[(int) Math.ceil(middleIndex)]) / 2.0;
    }
    return median;
  }

  private static boolean isOdd(int arrayLength){
    if (arrayLength % 2 == 0){
      return false;
    } else {
      return true;
    }
  }

  private static void maxHeapify(int brokenIndex){
    int left =left(brokenIndex);
    int right = right(brokenIndex);
    int indexOfLargest = brokenIndex;

    if(left <= heapSize && array[left] > array[indexOfLargest]){
      indexOfLargest = left;
    }

    if(right <= heapSize && array[right] > array[indexOfLargest]){
      indexOfLargest = right;
    }

    if (indexOfLargest != brokenIndex){
      swap(indexOfLargest,brokenIndex);
      maxHeapify(indexOfLargest);
    }
  }

  private static int parent(int index){
    return (int) Math.floor(index / 2.0);
  }

  private static int left(int index){
    return 2 * index;
  }

  private static int right(int index){
    return  (2 * index) + 1;
  }

  private static void swap(int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void buildMaxHeap(){
    for (int i = (int) Math.floor((array.length - 1) / 2.0); i > 0; i--) {
      maxHeapify(i);
    }
  }

  public static void heapSort(){
    buildMaxHeap();
    for (int i = array.length - 1; i > 1; i--) {
      swap(1,i);
      heapSize--;
      maxHeapify(1);
    }
  }
}
