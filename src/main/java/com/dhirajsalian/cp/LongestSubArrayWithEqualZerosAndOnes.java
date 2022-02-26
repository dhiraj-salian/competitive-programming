package com.dhirajsalian.cp;

import java.util.HashMap;
import java.util.HashSet;

/*
Given a binary array, find the longest sub-array with equal zeros and ones.

Examples:

Input 1: arr = [ 1, 0, 1, 1, 1, 0, 0 ]
Output 1: 6

Input 2: arr = [ 1, 1, 1, 1 ]
Output 2: 0

Input 3: arr = [ 0, 0, 1, 1, 1, 1, 1, 0 ]
Output 3: 4

Input 4: arr = [ 0, 0, 1, 0, 1, 1 ]
Output 4: 6

Source: geeksforgeeks.org
 */
public class LongestSubArrayWithEqualZerosAndOnes {

    static int longestZerosOnes(int[] arr) {
        int prefixSum = 0;
        int res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += (arr[i] == 0 ? -1 : 1);
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
        int[][] inputs = {{1, 0, 1, 1, 1, 0, 0}, {1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 1, 1}};
        for (int[] input : inputs) {
            System.out.println(longestZerosOnes(input));
        }
    }
}
