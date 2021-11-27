import java.util.*;

class MinPriorityQueue{

  ArrayList<Integer> array;
  int heapSize = 0;

  MinPriorityQueue(){
    array = new ArrayList<>();
  }

  void minHeapify(int indexToMinHeapify) {
    int leftLeaf = left(indexToMinHeapify);
    int rightLeaf = right(indexToMinHeapify);
    int minimunElementIndex = indexToMinHeapify;
    if (leftLeaf < heapSize && array.get(leftLeaf) < array.get(indexToMinHeapify)){
      minimunElementIndex = leftLeaf;
    }
    if (rightLeaf < heapSize && array.get(rightLeaf) < array.get(minimunElementIndex)){
      minimunElementIndex = rightLeaf;
    }
    if (minimunElementIndex != indexToMinHeapify) {
      swap(array, indexToMinHeapify, minimunElementIndex);
      minHeapify(minimunElementIndex);
    }
  }

  void buildMinHeap(){
    for (int i = (int) Math.floor((heapSize - 1) / 2.0); i >= 0; i--) {
      minHeapify(i);
    }
  }

  int deleteRoot(){
    int rootValue = getRoot();
    swap(array,0,heapSize - 1);
    heapSize--;
    return rootValue;
  }

  void insertElement(int elementToInsert){
    heapSize++;
    array.add(elementToInsert);
    int i = heapSize - 1;
    while (i > 0 && array.get(parent(i)) < array.get(i)) {
      swap(array,i,parent(i));
      i = parent(i);
    }
  }
  int getRoot(){
    return array.get(0);
  }

  int parent(int index){
    return (int) Math.floor(index / 2.0);
  }

  void swap(ArrayList<Integer> array, int i, int j) {
    int temp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, temp);
  }

  int left(int i) {
    return 2 * i + 1;
  }

  int right(int i) {
    return 2 * i + 2;
  }

  int getHeapSize(){
    return heapSize;
  }
}

class MaxPriorityQueue{

  ArrayList<Integer> array;
  int heapSize = 0;

  MaxPriorityQueue(){
    array = new ArrayList<>();
  }

  int getRoot(){
    return array.get(0);
  }

  int getHeapSize(){
    return heapSize;
  }

  void maxHeapify(int indexToMaxHeapify) {
    int leftLeaf = left(indexToMaxHeapify);
    int rightLeaf = right(indexToMaxHeapify);
    int maximumElementIndex = indexToMaxHeapify;
    if (leftLeaf < heapSize && array.get(leftLeaf) < array.get(indexToMaxHeapify)){
      maximumElementIndex = leftLeaf;
    }
    if (rightLeaf < heapSize && array.get(rightLeaf) < array.get(maximumElementIndex)){
      maximumElementIndex = rightLeaf;
    }
    if (maximumElementIndex != indexToMaxHeapify) {
      swap(array, indexToMaxHeapify, maximumElementIndex);
      maxHeapify(maximumElementIndex);
    }
  }

  void buildMinHeap(){
    for (int i = (int) Math.floor((heapSize - 1) / 2.0); i >= 0; i--) {
      maxHeapify(i);
    }
  }

  int deleteRoot(){
    int rootValue = getRoot();
    swap(array,0,heapSize - 1);
    heapSize--;
    return rootValue;
  }

  void insertElement(int elementToInsert){
    heapSize++;
    array.add(elementToInsert);
    int i = heapSize - 1;
    while (i > 0 && array.get(parent(i)) < array.get(i)) {
      swap(array,i,parent(i));
      i = parent(i);
    }
  }

  int parent(int index){
    return (int) Math.floor(index / 2.0);
  }

  void swap(ArrayList<Integer> array, int i, int j) {
    int temp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, temp);
  }

  int left(int i) {
    return 2 * i + 1;
  }

  int right(int i) {
    return 2 * i + 2;
  }
}

public class Median {

  private static MinPriorityQueue minHeap = new MinPriorityQueue();
  private static MaxPriorityQueue maxHeap = new MaxPriorityQueue();

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int arrayLength = input.nextInt();
    for (int i = 0; i < arrayLength; i++) {
      add(input.nextInt());
      System.out.println(getMedian());
    }
  }

  private static void add(int num) {
    if (minHeap.getHeapSize() == maxHeap.getHeapSize()) {
      maxHeap.insertElement(num);
      minHeap.insertElement(maxHeap.deleteRoot());
    } else {
      minHeap.insertElement(num);
      maxHeap.insertElement(minHeap.deleteRoot());
    }
  }

  private static double getMedian() {
    double median;
    if (minHeap.getHeapSize() > maxHeap.getHeapSize()) {
      median = minHeap.getRoot();
    } else {
      median = (minHeap.getRoot() + maxHeap.getRoot()) / 2.0;
    }
    return median;
  }
}