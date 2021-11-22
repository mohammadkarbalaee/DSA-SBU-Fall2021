package heap;

public class Heap {
  public int[] array;
  public int heapSize;

  Heap(int[] heap){
    this.array = heap;
    this.heapSize = this.array.length - 1;
  }
}
