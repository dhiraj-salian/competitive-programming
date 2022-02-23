package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;

/*
Given a matrix m, rotate matrix anti-clockwise by 90.

Examples:

Input 1: [ 1 2 3
           4 5 6
           7 8 9 ]
Output 1: [ 3 6 9
            2 5 8
            1 4 7 ]

Input 2: [ 1 2 3 4
           5 6 7 8
           9 10 11 12
           13 14 15 16 ]
Output 2: [ 4 8 12 16
            3 7 11 15
            2 6 10 14
            1 5 9 13 ]

Source: geeksforgeeks.org
 */
public class RotateMatrixAntiClockWise90 {

    static void rotateMatrixAntiClockWise90(int[][] m) {
        transposeMatrix(m);
        flipMatrix(m);
    }

    static void transposeMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = i + 1; j < m[i].length; j++) {
                CustomUtil.swap(m, i, j, j, i);
            }
        }
    }

    static void flipMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length / 2; j++) {
                CustomUtil.swap(m, j, i, m[i].length - j - 1, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
        };
        for (int[][] input : inputs) {
            rotateMatrixAntiClockWise90(input);
            CustomUtil.print(input);
            System.out.println();
        }
    }
}
