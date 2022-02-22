package com.dhirajsalian.cp;

/*
Given an array A, check if it is sorted in non-decreasing order.

Examples:

Input 1: A = [ 8, 12, 15 ]
Output 1: yes

Input 2: A = [ 8, 10, 10, 12 ]
Output 2: yes

Input 3: A = [ 100 ]
Output 3: yes

Input 4: A = [ 100, 20, 200 ]
Output 4: no

Source: geeksforgeeks.org
 */
public class CheckSortedArray {

    static boolean checkSorted(int[] a) {
        if (a.length < 2) return true;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] inputs = {{8, 12, 15}, {8, 10, 10, 12}, {100}, {100, 20, 200}};
        for (int[] input : inputs) {
            System.out.println(checkSorted(input) ? "yes" : "no");
        }
    }
}
