package heap;

import java.util.Arrays;

public class MaxHeapify {

  private static int[] array = {0,16,14,10,8,7,9,3,2,4,1};
  private static Heap heap = new Heap(array);

  public static void main(String[] args) {
    maxHeapify(3);
    System.out.println(Arrays.toString(heap.getHeap()));
  }

  private static void maxHeapify(int brokenIndex){
    int left = left(brokenIndex);
    int right = right(brokenIndex);
    int indexOfLargest;
    if(left <= heap.getHeapSize() && heap.heap[left] > heap.heap[brokenIndex]){
      indexOfLargest = left;
    } else {
      indexOfLargest = brokenIndex;
    }

    if(right<= heap.getHeapSize() && heap.heap[right] > heap.heap[brokenIndex]){
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
    return  2 * index + 1;
  }

  private static void swap(int i,int j){
    int temp = heap.heap[i];
    heap.heap[i] = heap.heap[j];
    heap.heap[j] = temp;
  }
}