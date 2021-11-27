import java.util.*;

public class Median {

  private static Queue<Integer> minHeap = new PriorityQueue<>();
  private static Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int arrayLength = input.nextInt();
    int[] array = new int[arrayLength];
    for (int i = 0; i < arrayLength; i++) {
      array[i] = input.nextInt();
      add(array[i]);
      System.out.println(getMedian());
    }
  }

  private static void add(int num) {
    if (minHeap.size() == maxHeap.size()) {
      maxHeap.offer(num);
      minHeap.offer(maxHeap.poll());
    } else {
      minHeap.offer(num);
      maxHeap.offer(minHeap.poll());
    }
  }

  private static double getMedian() {
    double median;
    if (minHeap.size() > maxHeap.size()) {
      median = minHeap.peek();
    } else {
      median = (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
    return median;
  }
}
