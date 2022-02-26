package com.dhirajsalian.cp;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, print the frequencies of array elements.

Examples:

Input 1: arr = [ 10, 12, 10, 15, 10, 20, 12, 12 ]
Output 1: 10 3
          12 3
          15 1
          20 1

Input 2: arr = [ 10, 10, 10, 10 ]
Output 2: 10 4

Input 3: arr = [ 10, 20 ]
Output 3: 10 1
          20 1

Source: geeksforgeeks.org
 */
public class FrequenciesOfArrayElements {
    static void frequencies(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("%s %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 12, 10, 15, 10, 20, 12, 12}, {10, 10, 10, 10}, {10, 20}};
        for (int[] input : inputs) {
            frequencies(input);
        }
    }
}
