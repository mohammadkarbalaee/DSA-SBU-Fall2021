import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpecialSort {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int firstLength = input.nextInt();
    int secondLength = input.nextInt();
    int[] firstArray = new int[firstLength];
    int[] secondArray = new int[secondLength];
    for (int i = 0; i < firstLength; i++) {
      firstArray[i] = input.nextInt();
    }
    for (int i = 0; i < secondLength; i++) {
      secondArray[i] = input.nextInt();
    }
    specialSort(firstArray, secondArray);
    for (int i = 0; i < firstArray.length; i++) {
      System.out.print(firstArray[i] + " ");
    }
  }

  private static void specialSort(int[] firstArray, int[] secondArray) {
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int i: firstArray) {
      frequency.put(i, frequency.getOrDefault(i, 0) + 1);
    }
    int index = 0;
    for (int i: secondArray) {
      int n = frequency.getOrDefault(i, 0);
      while (n-- > 0) {
        firstArray[index++] = i;
      }
      frequency.remove(i);
    }
    for (Map.Entry<Integer, Integer> entry: frequency.entrySet())
    {
      int count = entry.getValue();
      while (count-- > 0) {
        firstArray[index++] = entry.getKey();
      }
    }
  }
}