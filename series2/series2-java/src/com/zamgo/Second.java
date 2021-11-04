package com.zamgo;

import java.util.Scanner;

public class Second {

    private static long[] numbers;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        numbers = new long[n];
        getArray(console, n, numbers);
        System.out.println(boxQuantity());
    }

    private static int boxQuantity() {
        int boxQuantity = 1;
        mergeSort(numbers,0,numbers.length - 1);
        for (int i = numbers.length - 1; i > 0 ; i--) {
            if(numbers[i] == numbers[i - 1]){
                boxQuantity++;
            }
        }
        return boxQuantity;
    }

    private static void getArray(Scanner cin, int n, long[] numbers) {
        for (int i = 0; i < n; i++) {
            numbers[i] = cin.nextInt();
        }
    }

    private static void mergeSort(long[] array,int leftIndex,int rightIndex){
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            mergeSort(array,leftIndex,middleIndex);
            mergeSort(array,middleIndex + 1,rightIndex);
            merge(array,leftIndex,middleIndex,rightIndex);
        }
    }

    private static void merge(long[] array, int leftIndex, int middleIndex, int rightIndex) {
        long[] leftArray = new long[middleIndex - leftIndex + 1];
        long[] rightArray = new long[rightIndex - middleIndex];

        for (int i = 0; i < leftArray.length; i++){
            leftArray[i] = array[leftIndex + i];
        }
        for (int i = 0; i < rightArray.length; i++){
            rightArray[i] = array[middleIndex + i + 1];
        }
        int li = 0;
        int ri = 0;

        for (int i = leftIndex; i < rightIndex + 1; i++) {
            if (li < leftArray.length && ri < rightArray.length) {
                if (leftArray[li] < rightArray[ri]) {
                    array[i] = leftArray[li];
                    li++;
                } else {
                    array[i] = rightArray[ri];
                    ri++;
                }
            } else if (li < leftArray.length) {
                array[i] = leftArray[li];
                li++;
            } else if (ri < rightArray.length) {
                ri++;
            }
        }
    }

    private static void swap(int i,int j) {
        long temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}