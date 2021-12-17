import java.util.Scanner;

class MaxSumImplementation{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = input.nextInt();
    }
    int stackSum = 0;
    int tailSum ;
    for(int i=0; i<m; i++) {
      stackSum += array[i];
    }
    tailSum = stackSum;
    for(int i=0 ; i<m-1; i++) {
      stackSum = stackSum + array[n - 1 - i] - array[m - 1 - i];

      if(stackSum >= tailSum){
        tailSum = stackSum;
      }
    }
    System.out.println(tailSum);
  }
}