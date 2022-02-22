package com.dhirajsalian.cp;

/*
Given an array A, find the largest element index in array.

Examples:

Input 1: [10, 5, 20, 8]
Output 1: 2

Input 2: [40, 80, 50, 100];
Output 2: 3

Source: geeksforgeeks.org
 */
public class LargestElementInArray {

    static int largestElementIndex(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            max = arr[i] > arr[max] ? i : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 5, 20, 8}, {40, 80, 50, 100}};
        for (int[] input : inputs) {
            System.out.println(largestElementIndex(input));
        }
    }
}
