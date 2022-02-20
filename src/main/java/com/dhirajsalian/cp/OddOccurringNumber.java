package com.dhirajsalian.cp;

/*
Given an array of numbers, find the only odd occurring number.

Examples:

Input 1: arr[] = { 4, 3, 4, 4, 4, 5, 5 }
Output 1: 3

Input 2: arr[] = { 8, 7, 7 , 8 , 8 }

Source: geeksforgeeks.org
 */
public class OddOccurringNumber {

    static int findOnlyOddOccurringNumber(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inputs = {{4, 3, 4, 4, 4, 5, 5}, {8, 7, 7, 8, 8}};
        for (int[] input : inputs) {
            System.out.println(findOnlyOddOccurringNumber(input));
        }
    }
}
