package heap;

import java.util.Arrays;

public class HeapSort {

  private static int[] array = {0,1,2,3,4,7,8,9,10,14,16};
  private static int heapSize;

  public static void main(String[] args) {
    heapSize = array.length - 1;
    heapSort();
    System.out.println(Arrays.toString(array));
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