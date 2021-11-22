package heap;

import java.util.Arrays;

public class HeapFunctions {

  private static int[] array = {0,1,2,3,4,7,8,9,10,14,16};

  public static void main(String[] args) {
    buildMaxHeap();
    System.out.println(Arrays.toString(array));
  }

  private static void maxHeapify(int brokenIndex){
    int left =left(brokenIndex);
    int right = right(brokenIndex);
    int indexOfLargest = brokenIndex;

    if(left < array.length && array[left] > array[indexOfLargest]){
      indexOfLargest = left;
    }

    if(right < array.length && array[right] > array[indexOfLargest]){
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
}