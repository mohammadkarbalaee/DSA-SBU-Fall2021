
import java.util.Scanner;

public class Third {

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    int n = console.nextInt();
    long[] numbers = new long[n];
    getArray(console, n, numbers);
    System.out.println(getInversions(numbers));
  }

  private static long getInversions(long[] numbers) {
    long inversions = 0;
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        if(numbers[i] > numbers[j]){
          inversions++;
        }
      }
    }
    return inversions % 100000;
  }

  private static void getArray(Scanner cin, int n, long[] numbers) {
    for (int i = 0; i < n; i++) {
      numbers[i] = cin.nextInt();
    }
  }
}