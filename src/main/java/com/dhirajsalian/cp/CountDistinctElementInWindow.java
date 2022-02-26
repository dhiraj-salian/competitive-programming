package com.dhirajsalian.cp;

import java.util.HashMap;

/*
Given an array, one needs to Count Distinct Elements In Every Window of Size K.

Examples:

Input 1: arr = [ 10, 20, 20, 10, 30, 40, 10 ], k = 4
Output 1: 2 3 4 3

Input 2: arr = [ 10, 10, 10, 10 ], k = 3
Output 2: 1 1

Input 3: arr = [ 10, 20, 30, 40 ], k = 3
Output 3: 3 3

Source: geeksforgeeks.org
 */
public class CountDistinctElementInWindow {

    static void distinctWindowElementsCount(int[] arr, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < k; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }
        System.out.printf("%s ", m.size());
        for (int i = k; i < arr.length; i++) {
            m.put(arr[i - k], m.get(arr[i - k]) - 1);
            if (m.get(arr[i - k]) == 0) m.remove(arr[i - k]);
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
            System.out.printf("%s ", m.size());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 20, 10, 30, 40, 10}, {10, 10, 10, 10}, {10, 20, 30, 40}};
        int[] k = {4, 3, 3};
        for (int i = 0; i < inputs.length; i++) {
            distinctWindowElementsCount(inputs[i], k[i]);
        }
    }
}
