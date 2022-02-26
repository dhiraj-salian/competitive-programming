package com.dhirajsalian.cp;

import java.util.HashSet;

/*
Given an array and sum, check if the sub-arrays contain the given sum.

Examples:

Input 1: arr = [ 5, 8, 6, 13, 3, -1 ], sum = 22
Output 1: true

Input 2: arr = [ 15, 2, 8, 10, -5, -8, 6 ], sum = 3
Output 2: true

Input 3: arr = [ 3, 2, 5, 6 ], sum = 10
Output 3: true

Source: geeksforgeeks.org
 */
public class SubArrayWithGivenSumHashing {

    static boolean isSubArrayWithGivenSumPresent(int[] arr, int sum) {
        int prefixSum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            prefixSum += j;
            if (prefixSum == sum || set.contains(prefixSum - sum)) return true;
            set.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] inputArr = {{5, 8, 6, 13, 3, -1}, {15, 2, 8, 10, -5, -8, 6}, {3, 2, 5, 6}};
        int[] inputSum = {22, 3, 10};
        for (int i = 0; i < inputArr.length; i++) {
            System.out.println(isSubArrayWithGivenSumPresent(inputArr[i], inputSum[i]));
        }
    }
}
