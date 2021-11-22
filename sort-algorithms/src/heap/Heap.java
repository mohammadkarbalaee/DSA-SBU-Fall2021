package heap;

public class Heap {
  public int[] heap;

  Heap(int[] heap){
    this.heap = heap;
  }

  public int[] getHeap() {
    return heap;
  }

  public int getHeapSize() {
    return heap.length - 1;
  }
}
