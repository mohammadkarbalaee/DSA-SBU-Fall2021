package com.zamgo;

import java.util.Scanner;

public class Bepichoon {

//    public static char[] nuts;
//    public static char[] bolts;
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int nutsBoltsQuantity = in.nextInt();
//        char[] nuts = new char[nutsBoltsQuantity];
//        char[] bolts = new char[nutsBoltsQuantity];
//
//        for (int i = 0; i < nutsBoltsQuantity; i++) {
//            nuts[i] = in.next().charAt(0);
//        }
//
//        for (int i = 0; i < nutsBoltsQuantity; i++) {
//           bolts[i] = in.next().charAt(0);
//        }
//
//
//        for (int i = 0; i < nutsBoltsQuantity; i += 2) {
//            System.out.print(nuts[i] + " ");
//        }
//        System.out.println();
//        for (int i = 1; i < nutsBoltsQuantity; i += 2) {
//            System.out.print(bolts[i] + " ");
//        }
//    }
//
//    public static void quickSort(int startIndex, int endIndex){
//        if (startIndex < endIndex){
//            int previousPivotIndex = partition(array,startIndex,endIndex);
//            quickSort(array,startIndex,previousPivotIndex - 1);
//            quickSort(array,previousPivotIndex + 1,endIndex);
//        }
//    }
//
//    public static int partition(int startIndex, int endIndex,char pivot){
//        int startOfLeftHalf = startIndex - 1;
//        for (int startOfRightHalf = startIndex; startOfRightHalf < endIndex; startOfRightHalf++) {
//            if (array[startOfRightHalf] <= pivot){
//                startOfLeftHalf++;
//                swap(array,startOfLeftHalf,startOfRightHalf);
//            }
//        }
//        return startOfLeftHalf + 1;
//    }

    private static void swap(char[] array,int i,int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/*
the key of solving this problem lies under the partition function in the quick sort algorithm
so, since the first question is about the partition function, let's solve that first and by the knowledge that
you gain there, you can certainly solve this problem easier.

this text is meant to be a reminder, so that you will not forget what the idea here was
 */
