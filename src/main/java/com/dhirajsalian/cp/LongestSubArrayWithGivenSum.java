package com.dhirajsalian.cp;

import java.util.HashMap;

/*
Given an array and sum, find the longest sub-array with given sum.

Examples:

Input 1: arr = [ 5, 8, -4, -4, 9, -2, 2 ], sum = 0
Output 1: 3

Input 2: arr = [ 3, 1, 0, 1, 8, 2, 3, 6 ], sum = 5
Output 2: 4

Input 3: arr = [ 8, 3, 7 ], sum = 15
Output 3: 0

Source: geeksforgeeks.org
 */
public class LongestSubArrayWithGivenSum {

    static int longestSubArrayCountWithGivenSum(int[] arr, int sum) {
        int prefixSum = 0, maxLengthPrefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == sum) {
                maxLengthPrefixSum = Math.max(maxLengthPrefixSum, i + 1);
            }
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);
            if (map.containsKey(prefixSum - sum)) {
                maxLengthPrefixSum = Math.max(maxLengthPrefixSum, i - map.get(prefixSum - sum));
            }
        }
        return maxLengthPrefixSum;
    }

    public static void main(String[] args) {
        int[][] inputArr = {{5, 8, -4, -4, 9, -2, 2}, {3, 1, 0, 1, 8, 2, 3, 6}, {8, 3, 7}};
        int[] inputSum = {0, 5, 15};
        for (int i = 0; i < inputArr.length; i++) {
            System.out.println(longestSubArrayCountWithGivenSum(inputArr[i], inputSum[i]));
        }
    }
}
