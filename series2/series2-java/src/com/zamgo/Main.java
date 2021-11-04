package com.zamgo;

import java.util.*;

public class Main
{
    private static long[] numbers;
    private static int n;

    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        numbers = new long[n];
        getArray(cin, n, numbers);
        System.out.print(getPermutation());
    }

    private static void getArray(Scanner cin, int n, long[] numbers)
    {
        for (int i = 0; i < n; i++)
        {
            numbers[i] = cin.nextInt();
        }
    }
    private static long getPermutation()
    {
        Arrays.sort(numbers);
        long result = 0;
        for (int i = 0; i < n; i++)
        {
            result += Math.abs(numbers[i] - (i + 1));
        }
        return result;
    }
}