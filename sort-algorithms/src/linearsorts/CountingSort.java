package linearsorts;

import java.util.Arrays;

public class CountingSort {
  public static void main(String[] args) {
    int[] inputArray = {0,5,6,7,1,3,4,2,8,9};
    int[] cumulativeFrequency = {0,0,0,0,0,0,0,0,0,0};
    int[] outputArray = new int[10];
    for (int i = 1; i < inputArray.length; i++) {
      cumulativeFrequency[inputArray[i]]++;
    }
    for (int i = 2; i < cumulativeFrequency.length; i++){
      cumulativeFrequency[i] += cumulativeFrequency[i - 1];
    }
    for (int i = inputArray.length - 1; i >= 0; i--) {
      outputArray[cumulativeFrequency[inputArray[i]]] = inputArray[i];
      cumulativeFrequency[inputArray[i]]--;
    }
    System.out.println(Arrays.toString(outputArray));
  }
}
