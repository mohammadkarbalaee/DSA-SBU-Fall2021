import java.util.Arrays;
import java.util.Scanner;

public class Median {

//  private static int[] array;
  private static int[] array = {0, 12,4,5,3,7,8};
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
    heapSort(array.length);

  }

  private static void swap(int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private static double findMedian(int[] sortedArray,int subArrayLength,boolean isLenthOdd){
    double median = 0;
    int middleIndex = (subArrayLength + 1) / 2;
    if (isLenthOdd){
      median = sortedArray[middleIndex];
    } else {
      median = (sortedArray[middleIndex] + sortedArray[middleIndex - 1]) / 2.0;
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

  public static void heapSort(int arrayLength){
    int[] sortedArray = new int[arrayLength];
    buildMinHeap();
    for (int i = 1; i < array.length; i++) {
      sortedArray[i - 1] = array[1];
      System.out.println(Arrays.toString(sortedArray));
      System.out.println(findMedian(sortedArray,i - 1,isOdd(i)));
      int lastElement = array[heapSize];
      array[1] = lastElement;
      heapSize--;
      minHeapify(1);
    }

  }

}
