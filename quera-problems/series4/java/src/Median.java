import java.util.Arrays;
import java.util.Scanner;

public class Median {

  private static int[] array;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int arrayLength = input.nextInt();
    array = new int[arrayLength];
    for (int i = 0; i < arrayLength; i++) {
      array[i] = input.nextInt();
      for (int m = 0, j = i; m < j; m++, j--) {
        int minValue = array[m];
        int maxValue = array[m];
        int minimumIndex = m;
        int maximumIndex = m;
        for (int k = m; k <= j; k++) {
          if (array[k] > maxValue) {
            maxValue = array[k];
            maximumIndex = k;
          } else if (array[k] < minValue) {
            minValue = array[k];
            minimumIndex = k;
          }
        }
        swap(m, minimumIndex);
        if (array[minimumIndex] == maxValue){
          swap(j, minimumIndex);
        } else {
          swap(j, maximumIndex);
        }
      }
      System.out.println(findMedian(i,isOdd(i + 1)));
    }
  }

  private static void swap(int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private static double findMedian(int subArrayLength,boolean isLenthOdd){
    double median = 0;
    int middleIndex = (subArrayLength + 1) / 2;
//    System.out.println("middle index: " + middleIndex);
    if (isLenthOdd){
      median = array[middleIndex];
    } else {
      median = (array[middleIndex] + array[middleIndex - 1]) / 2.0;
    }
    return median;
  }

  private static boolean isOdd(int arrayLength){
    if (arrayLength % 2 == 0){
      return false;
    } else {
      return true;
    }
  }
}
