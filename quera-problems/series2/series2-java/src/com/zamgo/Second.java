package com.zamgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        Map<Integer, Integer> occurrencesMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int key = console.nextInt();
            if(occurrencesMap.containsKey(key)) {
                int frequency = occurrencesMap.get(key);
                frequency++;
                occurrencesMap.put(key, frequency);
            } else {
                occurrencesMap.put(key, 1);
            }
        }
        int maxCount = 0;

        for(Map.Entry<Integer, Integer> val : occurrencesMap.entrySet()) {
            if (maxCount < val.getValue()) {
                maxCount = val.getValue();
            }
        }
        System.out.println(maxCount);
    }
}