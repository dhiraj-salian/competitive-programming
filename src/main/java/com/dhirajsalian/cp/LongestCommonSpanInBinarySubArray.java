package com.dhirajsalian.cp;

import java.util.HashMap;

/*
Given two binary arrays, find the longest common (same start and end indexes) sub-array with equal sum.

Examples:

Input 1: arr1 = [ 0, 1, 0, 0, 0, 0 ], arr2 = [ 1, 0, 1, 0, 0, 1 ]
Output 1: 4

Input 2: arr1 = [ 0, 1, 0, 1, 1, 1, 1 ], arr2 = [ 1, 1, 1, 1, 1, 0, 1 ]
Output 2: 6

Input 3: arr1 = [ 0, 0, 0 ], arr2 = [ 1, 1, 1 ]
Output 3: 0

Input 4: arr1 = [ 0, 0, 1, 0 ], arr2 = [ 1, 1, 1, 1 ]
Output 4: 1

Source: geeksforgeeks.org
 */
public class LongestCommonSpanInBinarySubArray {

    static int longestCommonSpanInBinarySubArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] - arr2[i];
        }
        int prefixSum = 0;
        int res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            prefixSum += arr1[i];
            if (prefixSum == 0) {
                res = Math.max(res, i + 1);
            }
            if (!m.containsKey(prefixSum)) {
                m.put(prefixSum, i);
            }
            if (m.containsKey(prefixSum)) {
                res = Math.max(res, i - m.get(prefixSum));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inputArr1 = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1}, {0, 0, 0}, {0, 0, 1, 0}};
        int[][] inputArr2 = {{1, 0, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 1}, {1, 1, 1}, {1, 1, 1, 1}};
        for (int i = 0; i < inputArr1.length; i++) {
            System.out.println(longestCommonSpanInBinarySubArray(inputArr1[i], inputArr2[i]));
        }
    }
}
