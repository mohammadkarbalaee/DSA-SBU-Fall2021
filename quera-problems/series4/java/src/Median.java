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
      for (int j = 0; j < i; j++) {
        int leastIndex = j;
        for (int k = j; k < i + 1; k++) {
          if (array[k] < array[leastIndex]){
            leastIndex = k;
          }
        }
        swap(leastIndex,j);
      }
    }
    boolean isLengthOdd = isOdd(arrayLength);
    System.out.println(Arrays.toString(array));
  }

  private static void swap(int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private static boolean isOdd(int arrayLength){
    if (arrayLength % 2 == 0){
      return false;
    } else {
      return true;
    }
  }
}
