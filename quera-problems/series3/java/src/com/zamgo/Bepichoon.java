package com.zamgo;

import java.util.Scanner;

public class Bepichoon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nutsBoltsQuantity = in.nextInt();
        char[] nuts = new char[nutsBoltsQuantity];
        char[] bolts = new char[nutsBoltsQuantity];
        for (int i = 0; i < nutsBoltsQuantity; i++) {
            nuts[i] = in.next().charAt(0);
        }
        for (int i = 0; i < nutsBoltsQuantity; i++) {
            bolts[i] = in.next().charAt(0);
        }
        quickSort(nuts, bolts,0, nutsBoltsQuantity - 1);
        quickSort(bolts,nuts,0, nutsBoltsQuantity - 1);
        for (int i = 0; i < nutsBoltsQuantity; i++) {
            System.out.print(nuts[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nutsBoltsQuantity; i++) {
            System.out.print(bolts[i] + " ");
        }
    }

    private static void swap(char[] array,int i,int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int partition(char[] array,int startIndex, int endIndex){
        int pivotIndex = startIndex;
        char pivot = array[startIndex];
        while (startIndex < endIndex){
            while ((startIndex < array.length) && array[startIndex] <= pivot){
                startIndex++;
            }
            while (array[endIndex] > pivot){
                endIndex--;
            }
            if (startIndex < endIndex){
                swap(array,endIndex,startIndex);
            }
        }
        swap(array,pivotIndex,endIndex);
        return endIndex;
    }

    public static void quickSort(char[] arrayA,char[] arrayB,int startIndex, int endIndex){
        if (startIndex < endIndex){
            int previousPivotIndex = partition(arrayB,startIndex,endIndex);
            quickSort(arrayA,arrayB,startIndex,previousPivotIndex - 1);
            quickSort(arrayA,arrayB,previousPivotIndex + 1,endIndex);
        }
    }
}