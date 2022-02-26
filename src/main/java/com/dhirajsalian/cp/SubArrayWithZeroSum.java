package com.dhirajsalian.cp;

import java.util.HashSet;

/*
Given an array of integers, check if sub-array with zero-sum present.

Examples:

Input 1: arr = [ 1, 4, 13, -3, -10, 5 ]
Output 1: yes

Input 2: arr = [ -1, 4, -3, 5, 1 ]
Output 2: yes

Input 3: arr = [ 3, 1, -2, 5, 6 ]
Output 3: no

Input 4: arr = [ 5, 6, 0, 8 ]
Output 4: yes

Source: geekforgeeks.org
 */
public class SubArrayWithZeroSum {

    static boolean isSubArrayWithZeroSumPresent(int[] arr) {
        int prefixSum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            prefixSum += j;
            if (set.contains(prefixSum) || prefixSum == 0) return true;
            set.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] inputs = {{1, 4, 13, -3, -10, 5}, {-1, 4, -3, 5, 1}, {3, 1, -2, 5, 6}, {5, 6, 0, 8}};
        for (int[] input : inputs) {
            System.out.println(isSubArrayWithZeroSumPresent(input) ? "yes" : "no");
        }
    }

}
