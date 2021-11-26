import java.util.Scanner;

public class XYZ {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int arrayLength = input.nextInt();
    int[][] cards = new int[arrayLength][];
    for (int i = 0; i < arrayLength; i++) {
      String cardsString = input.next();
      switch (cardsString){
        case "X1": cards[i] = new int[]{0, 0}; break;
        case "X2": cards[i] = new int[]{0, 1}; break;
        case "X3": cards[i] = new int[]{0, 2}; break;
        case "X4": cards[i] = new int[]{0, 3}; break;
        case "X5": cards[i] = new int[]{0, 4}; break;
        case "Y1": cards[i] = new int[]{1, 0}; break;
        case "Y2": cards[i] = new int[]{1, 1}; break;
        case "Y3": cards[i] = new int[]{1, 2}; break;
        case "Y4": cards[i] = new int[]{1, 3}; break;
        case "Y5": cards[i] = new int[]{1, 4}; break;
        case "Z1": cards[i] = new int[]{2, 0}; break;
        case "Z2": cards[i] = new int[]{2, 1}; break;
        case "Z3": cards[i] = new int[]{2, 2}; break;
        case "Z4": cards[i] = new int[]{2, 3}; break;
        case "Z5": cards[i] = new int[]{2, 4}; break;
      }
    }
    cards = radixSort(cards);
    for (int i = 0; i < arrayLength; i++) {
      int numberRepresentation = (cards[i][0] * 10) + cards[i][1];
      switch (numberRepresentation){
        case 0: System.out.print("X1"); break;
        case 1: System.out.print("X2"); break;
        case 2: System.out.print("X3"); break;
        case 3: System.out.print("X4"); break;
        case 4: System.out.print("X5"); break;
        case 10: System.out.print("Y1"); break;
        case 11: System.out.print("Y2"); break;
        case 12: System.out.print("Y3"); break;
        case 13: System.out.print("Y4"); break;
        case 14: System.out.print("Y5"); break;
        case 20: System.out.print("Z1"); break;
        case 21: System.out.print("Z2"); break;
        case 22: System.out.print("Z3"); break;
        case 23: System.out.print("Z4"); break;
        case 24: System.out.print("Z5"); break;
      }
      System.out.print(" ");
    }
  }

  private static int[][] radixSort(int[][] cards){
    int[][] outputCards = cards;
    for (int i = 1; i >= 0; i--) {
      outputCards = countingSort(outputCards,i,5);
    }
    return outputCards;
  }

  private static int[][] countingSort(int[][] inputArray,int index,int range){
    int[][] outputArray = new int[inputArray.length][];
    int[] cumulativeFrequency = new int[range];
    for (int i = 0; i < inputArray.length; i++) {
      cumulativeFrequency[inputArray[i][index]]++;
    }
    for (int i = 1; i < cumulativeFrequency.length; i++){
      cumulativeFrequency[i] += cumulativeFrequency[i - 1];
    }
    for (int i = inputArray.length - 1; i >= 0; i--) {
      outputArray[cumulativeFrequency[inputArray[i][index]] - 1] = inputArray[i];
      cumulativeFrequency[inputArray[i][index]]--;
    }
    return outputArray;
  }
}