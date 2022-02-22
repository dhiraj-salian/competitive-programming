package com.dhirajsalian.cp;

/*
Given a sorted array arr, print the element and their frequencies.

Examples:

Input 1: arr = [ 10, 10, 10, 25, 30, 30 ]
Output 1: 10 3
          25 1
          30 2

Input 2: arr = [ 10, 10, 10, 10 ]
Output 2: 10 4

Input 3: arr = [ 10, 20, 30 ]
Output 3: 10 1
          20 1
          30 1

Source: geeksforgeeks.org
 */
public class FrequenciesInSortedArray {

    static void printFrequencies(int[] arr) {
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                System.out.printf("%s %s\n", arr[i - 1], count);
                count = 1;
            }
        }
        System.out.printf("%s %s\n\n", arr[arr.length - 1], count);
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 10, 10, 25, 30, 30}, {10, 10, 10, 10}, {10, 20, 30}};
        for (int[] input : inputs) {
            printFrequencies(input);
        }
    }
}
