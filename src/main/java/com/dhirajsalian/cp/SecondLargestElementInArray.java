package com.dhirajsalian.cp;

/*
Given an array A, find the second largest element index in array.

Examples:

Input 1: A = [ 10, 5, 8, 20 ]
Output 1: 0

Input 2: A = [ 20, 10, 20, 8, 12 ]
Output 2: 4

Input 3: A = [ 10, 10, 10 ]
Output 3: -1

Source: geeksforgeeks.org
 */
public class SecondLargestElementInArray {

    static int secondLargestElementIndex(int[] a) {
        int largest = 0, secondLargest = -1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (a[i] != a[largest] && (secondLargest == -1 || a[i] > a[secondLargest])) {
                secondLargest = i;
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 5, 8, 20}, {20, 10, 20, 8, 12}, {10, 10, 10}};
        for (int[] input : inputs) {
            System.out.println(secondLargestElementIndex(input));
        }
    }
}
