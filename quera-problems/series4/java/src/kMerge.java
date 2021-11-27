import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kMerge {
  private MinHeapNode[] heapArray;
  private int heapSize;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer input1 = new StringTokenizer(br.readLine());

    int numberOfSortedArrays = Integer.parseInt(input1.nextToken());
    int[][] sortedArrays = new int[numberOfSortedArrays][];

    for (int i = 0; i < numberOfSortedArrays; i++) {
      StringTokenizer input2 = new StringTokenizer(br.readLine());
      int sortedArrayLength = Integer.parseInt(input2.nextToken());

      int[] sortedArray = new int[sortedArrayLength];
      for (int j = 0; j < sortedArrayLength; j++) {
        sortedArray[j] = Integer.parseInt(input2.nextToken());
      }
      sortedArrays[i] = sortedArray;
    }
    int[] mergedFinalArray = mergeKSortedArrays(sortedArrays,sortedArrays.length);
    for (int j : mergedFinalArray) {
      System.out.print(j + " ");
    }
  }

  public kMerge(MinHeapNode[] heapArray, int heapSize) {
    this.heapSize = heapSize;
    this.heapArray = heapArray;
    int i = (heapSize - 1) / 2;
    while (i >= 0) {
      MinHeapify(i);
      i--;
    }
  }

  private void MinHeapify(int indexToMinHeapify) {
    int l = left(indexToMinHeapify);
    int r = right(indexToMinHeapify);
    int smallestElementIndex = indexToMinHeapify;
    if (l < heapSize && heapArray[l].elementToBeSorted < heapArray[indexToMinHeapify].elementToBeSorted){
      smallestElementIndex = l;
    }
    if (r < heapSize && heapArray[r].elementToBeSorted < heapArray[smallestElementIndex].elementToBeSorted){
      smallestElementIndex = r;
    }
    if (smallestElementIndex != indexToMinHeapify) {
      swap(heapArray, indexToMinHeapify, smallestElementIndex);
      MinHeapify(smallestElementIndex);
    }
  }

  private static int left(int i) {
    return 2 * i + 1;
  }
  private static int right(int i) {
    return 2 * i + 2;
  }
  private MinHeapNode getMin() {
    return heapArray[0];
  }

  private void replaceMin(MinHeapNode root) {
    heapArray[0] = root;
    MinHeapify(0);
  }

  private static void swap(MinHeapNode[] array, int i, int j) {
    MinHeapNode temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private static int[] mergeKSortedArrays(int[][] array, int quantityOfSortedArrays) {
    MinHeapNode[] heapArray = new MinHeapNode[quantityOfSortedArrays];
    int resultSize = 0;
    for(int i = 0; i < array.length; i++) {
      MinHeapNode node = new MinHeapNode(array[i][0],i,1);
      heapArray[i] = node;
      resultSize += array[i].length;
    }

    kMerge minHeap = new kMerge(heapArray, quantityOfSortedArrays);
    int[] result = new int[resultSize];
    for(int i = 0; i < resultSize; i++) {
      MinHeapNode root = minHeap.getMin();
      result[i] = root.elementToBeSorted;
      if(root.nextOriginIndex < array[root.originIndex].length){
        root.elementToBeSorted = array[root.originIndex][root.nextOriginIndex++];
      } else {
        root.elementToBeSorted = Integer.MAX_VALUE;
      }
      minHeap.replaceMin(root);
    }
    return result;
  }
};

class MinHeapNode {
  int elementToBeSorted;
  int nextOriginIndex;
  int originIndex;
  public MinHeapNode(int elementToBeSorted, int originIndex, int nextOriginIndex) {
    this.elementToBeSorted = elementToBeSorted;
    this.originIndex = originIndex;
    this.nextOriginIndex = nextOriginIndex;
  }
};