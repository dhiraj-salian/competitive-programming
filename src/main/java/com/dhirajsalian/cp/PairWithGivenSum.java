package com.dhirajsalian.cp;

import java.util.HashSet;

/*
Given an unsorted integer array, check if it contains a pair with given sum.

Examples:

Input 1: arr = [ 3, 2, 8, 15, -8 ], sum = 17
Output 1: true

Input 2: arr = [ 2, 1, 6, 3 ], sum = 6
Output 2: false

Input 3: arr = [ 5, 8, -3, 6 ], sum = 3
Output 3: true

Source: geeksforgeeks.org
 */
public class PairWithGivenSum {

    static boolean checkPairWithSumExists(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (set.contains(sum - j)) return true;
            set.add(j);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] inputArr = {{3, 2, 8, 15, -8}, {2, 1, 6, 3}, {5, 8, -3, 6}};
        int[] inputSum = {17, 6, 3};
        for (int i = 0; i < inputArr.length; i++) {
            System.out.println(checkPairWithSumExists(inputArr[i], inputSum[i]));
        }
    }

}
