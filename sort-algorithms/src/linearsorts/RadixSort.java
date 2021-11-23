package linearsorts;

import java.util.Arrays;

public class RadixSort {
  private static String[] words = {"red","ted","bed","kid","did","are","fed"}; 
  public static void main(String[] args) {
    radixSort();
    System.out.println(Arrays.toString(words));
  }
  
  private static void radixSort(){
    for (int i = 2; i >= 0; i--) {
      bubbleSort(i);
    }
  }

  private static void bubbleSort(int digitToCompare){
    for (int i = 0; i < words.length - 1; i++) {
      for (int j = 0; j < words.length - i - 1; j++) {
        if (words[j].charAt(digitToCompare) > words[j + 1].charAt(digitToCompare)){
          swap(j,j + 1);
        }
      }
    }
  }

  private static void swap(int i,int j){
    String temp = words[i];
    words[i] = words[j];
    words[j] = temp;
  }
}
