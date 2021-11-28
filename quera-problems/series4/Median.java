import java.util.*;

class queueMin
{

  ArrayList<Integer> array;

  queueMin()
  {
    array = new ArrayList<>();
  }

  int rootOfDlt()
  {
    int ansRoot = getRoot();
    swap(array,0,array.size() - 1);
    array.remove(array.size() - 1);
    minHeapify(0);
    return ansRoot;
  }

  void vlueForInsertt(int elementToInsert)
  {
    array.add(elementToInsert);
    
    for (int i = array.size() - 1;i > 0 && array.get(parent(i)) > array.get(i);i = parent(i)) 
    {
      swap(array,i,parent(i));
      
    }
  }

  int getRoot()
  {
    return array.get(0);
  }

  void minHeapify(int indexToMinHeapify) 
  {
    int leftLeaf = left(indexToMinHeapify);
    int rightLeaf = right(indexToMinHeapify);
    int minimunElementIndex = indexToMinHeapify;

    if (leftLeaf < array.size() && array.get(leftLeaf) < array.get(minimunElementIndex))
    {
      minimunElementIndex = leftLeaf;
    }

    if (rightLeaf < array.size() && array.get(rightLeaf) < array.get(minimunElementIndex))
    {
      minimunElementIndex = rightLeaf;
    }

    if (minimunElementIndex != indexToMinHeapify)
    {
      swap(array, indexToMinHeapify, minimunElementIndex);
      minHeapify(minimunElementIndex);
    }

  }

  int parent(int index)
  {
    return (index - 1) / 2;
  }

  void swap(ArrayList<Integer> array, int i, int j) 
  {
    int tmp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, tmp);
  }

  int left(int i) 
  {
    return 2 * i + 1;
  }

  int right(int i) 
  {
    return 2 * i + 2;
  }

  int getHeapSize()
  {
    return array.size();
  }
}

class queueMax{

  ArrayList<Integer> array;

  queueMax(){
    array = new ArrayList<>();
  }

  void maxHeapify(int indexToMaxHeapify) 
  {
    int leftLeaf = left(indexToMaxHeapify);
    int rightLeaf = right(indexToMaxHeapify);
    int maximumElementIndex = indexToMaxHeapify;
    if (leftLeaf < array.size() && array.get(leftLeaf) > array.get(maximumElementIndex))
    {
      maximumElementIndex = leftLeaf;
    }
    if (rightLeaf < array.size() && array.get(rightLeaf) > array.get(maximumElementIndex))
    {
      maximumElementIndex = rightLeaf;
    }
    if (maximumElementIndex != indexToMaxHeapify) 
    {
      swap(array, indexToMaxHeapify, maximumElementIndex);
      maxHeapify(maximumElementIndex);
    }

  }

  int getRoot()
  {
    return array.get(0);
  }

  int getHeapSize()
  {
    return array.size();
  }

  int rootOfDlt()
  {
    int ansRoot = getRoot();
    swap(array,0,array.size() - 1);
    array.remove(array.size() - 1);
    maxHeapify(0);
    return ansRoot;
  }

  void vlueForInsertt(int elementToInsert)
  {
    array.add(elementToInsert);
    
    for (int i = array.size() - 1; i > 0 && array.get(parent(i)) < array.get(i);i = parent(i)) 
    {
      swap(array,i,parent(i));
    }
  }

  int parent(int index)
  {
    return (index - 1) / 2;
  }

  void swap(ArrayList<Integer> array, int i, int j) 
  {
    int tmp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, tmp);
  }

  int left(int i) 
  {
    return 2 * i + 1;
  }

  int right(int i) 
  {
    return 2 * i + 2;
  }
}

public class Median 
{
  private static final queueMin minHeap = new queueMin();
  private static final queueMax maxHeap = new queueMax();

  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    int lengthOfArr = input.nextInt();
    int i = 0; 
    while (i < lengthOfArr)
    {

      add(input.nextInt());
      System.out.println(getMedian());
      i += 1;

    }
  }

  private static void add(int num) 
  {
    if (minHeap.getHeapSize() == maxHeap.getHeapSize()) 
    {
      maxHeap.vlueForInsertt(num);
      minHeap.vlueForInsertt(maxHeap.rootOfDlt());

    } 
    else 
    {
      minHeap.vlueForInsertt(num);
      maxHeap.vlueForInsertt(minHeap.rootOfDlt());

    }
  }

  private static double getMedian() 
  {
    double median;
    if (minHeap.getHeapSize() > maxHeap.getHeapSize()) 
    {
      median = minHeap.getRoot();
    } 
    else 
    {
      median = (minHeap.getRoot() + maxHeap.getRoot()) / 2.0;
    }
    return median;
  }
}