import java.util.Scanner;

public class MaxSumImplementation {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = input.nextInt();
    }
    int maximumSum = 0;
    for (int i = 1; i <= m; i++) {
      int sum = 0;
      int stackHead = 0;
      int stackTail = n - 1;

      for (int j = 0; j < i; j++) {
        sum += array[j];
        stackHead++;
      }

      for (int j = 0; j < m - i; j++) {
        sum += array[stackTail];
        stackTail--;
      }

      if (sum > maximumSum){
        maximumSum = sum;
      }
    }
    System.out.println(maximumSum);
  }
}
