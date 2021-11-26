import java.util.Arrays;
import java.util.Scanner;

public class Median {

//  private static int[] array;
  private static int[] array = {0, 12,22,3,4,77,80,9,102,14,16};
  private static int heapSize;

  public static void main(String[] args) {
//    Scanner input = new Scanner(System.in);
//    int arrayLength = input.nextInt();
//    array = new int[arrayLength];
//    array[0] = 0;
//    for (int i = 1; i <= arrayLength; i++) {
//      array[i] = input.nextInt();
//    }
    heapSize = array.length - 1;
    heapSort();
//    System.out.println(findMedian(i,isOdd(i + 1)));
  }

  private static void swap(int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private static double findMedian(int subArrayLength,boolean isLenthOdd){
    double median = 0;
    int middleIndex = (subArrayLength + 1) / 2;
    if (isLenthOdd){
      median = array[middleIndex];
    } else {
      median = (array[middleIndex] + array[middleIndex - 1]) / 2.0;
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

  private static void minHeapify(int brokenIndex){
    int left =left(brokenIndex);
    int right = right(brokenIndex);
    int indexOfSmallest = brokenIndex;

    if(left <= heapSize && array[left] < array[indexOfSmallest]){
      indexOfSmallest = left;
    }

    if(right <= heapSize && array[right] < array[indexOfSmallest]){
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
    return 2 * index;
  }

  private static int right(int index){
    return  (2 * index) + 1;
  }

  public static void buildMinHeap(){
    for (int i = (int) Math.floor((array.length - 1) / 2.0); i > 0; i--) {
      minHeapify(i);
    }
  }

  public static void heapSort(){
    buildMinHeap();
    for (int i = 1; i < array.length; i++) {
      System.out.println(array[1]);
      int lastElement = array[heapSize];
      array[1] = lastElement;
      heapSize--;
      minHeapify(1);
    }
  }

}
