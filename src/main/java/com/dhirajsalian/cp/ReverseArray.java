package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomArrayUtil;

/*
Given an array A, reverse the elements of the array.

Examples:

Input 1: A = [ 10, 5, 7, 30 ]
Output 1: A = [ 30, 7, 5, 10 ]

Input 2: A = [ 30, 20, 5 ]
Output 2: A = [ 5, 20, 30 ]

Source: geeksforgeeks.org
 */
public class ReverseArray {

    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            CustomArrayUtil.swap(a, i, a.length - i - 1);
        }
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 5, 7, 30}, {30, 20, 5}};
        for (int[] input : inputs) {
            reverse(input);
            CustomArrayUtil.print(input);
        }
    }

}
