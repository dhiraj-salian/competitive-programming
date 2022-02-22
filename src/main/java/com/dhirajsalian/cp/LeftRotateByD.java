package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomArrayUtil;

/*
Given an array A, left rotate an array by d positions.

Examples:

Input 1: A = [ 1, 2, 3, 4, 5 ], d = 1
Output 1: A = [2, 3, 4, 5, 1 ]

Input 2: A = [ 30, 5, 20 ], d = 1
Output 2: A = [ 5, 20, 30 ]

Input 3: A = [ 1, 2, 3, 4, 5 ], d = 2
Output 3: A = [ 3, 4, 5, 1, 2 ]

Source: geeksforgeeks.org
 */
public class LeftRotateByD {

    static void leftRotate(int[] a, int d) {
        reverse(a, 0, d - 1);
        reverse(a, d, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    static void reverse(int[] a, int start, int end) {
        while (start < end) {
            CustomArrayUtil.swap(a, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3, 4, 5}, {30, 5, 20}, {1, 2, 3, 4, 5}};
        int[] inputD = {1, 1, 2};
        for (int i = 0; i < inputD.length; i++) {
            leftRotate(inputs[i], inputD[i]);
            CustomArrayUtil.print(inputs[i]);
        }
    }
}
