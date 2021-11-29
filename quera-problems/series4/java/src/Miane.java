import java.util.ArrayList;
import java.util.Scanner;

public class Miane
{
  private static final queue minHeap = new queueMin();
  private static final queue maxHeap = new queueMax();

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
      maxHeap.insert(num);
      minHeap.insert(maxHeap.delete());

    } 
    else 
    {
      minHeap.insert(num);
      maxHeap.insert(minHeap.delete());

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

class queue
{

  ArrayList<Integer> heapArray;

  queue()
  {
    heapArray = new ArrayList<>();
  }

  int delete()
  {
    int ansRoot = getRoot();
    swap(heapArray,0, heapArray.size() - 1);
    heapArray.remove(heapArray.size() - 1);
    heapify(0);
    return ansRoot;
  }

  void insert(int elementToInsert)
  {}

  int getRoot()
  {
    return heapArray.get(0);
  }

  void heapify(int i)
  {}

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
    return heapArray.size();
  }

}
class queueMin extends queue
{

  ArrayList<Integer> array;

  queueMin()
  {
    super();
    this.array = new ArrayList<>();
  }
  @Override
  void insert(int elementToInsert)
  {
    heapArray.add(elementToInsert);

    for (int i = heapArray.size() - 1; i > 0 && heapArray.get(parent(i)) > heapArray.get(i); i = parent(i))
    {
      swap(heapArray,i,parent(i));
    }
  }

  @Override
  void heapify(int i)
  {
    int left = left(i);
    int right = right(i);
    int min = i;

    if (left < heapArray.size() && heapArray.get(left) < heapArray.get(min))
    {
      min = left;
    }

    if (right < heapArray.size() && heapArray.get(right) < heapArray.get(min))
    {
      min = right;
    }

    if (min != i)
    {
      swap(heapArray, i, min);
      heapify(min);
    }

  }
}

class queueMax extends queue{

  ArrayList<Integer> array;

  queueMax(){
    super();
    this.array = new ArrayList<>();
  }

  @Override
  void insert(int elementToInsert)
  {
    heapArray.add(elementToInsert);

    for (int i = heapArray.size() - 1; i > 0 && heapArray.get(parent(i)) < heapArray.get(i); i = parent(i))
    {
      swap(heapArray,i,parent(i));
    }
  }

  @Override
  void heapify(int i)
  {
    int left = left(i);
    int right = right(i);
    int maxx = i;
    if (left < array.size() && array.get(left) > array.get(maxx))
    {
      maxx = left;
    }
    if (right < array.size() && array.get(right) > array.get(maxx))
    {
      maxx = right;
    }
    if (maxx != i)
    {
      swap(array, i, maxx);
      heapify(maxx);
    }

  }
}