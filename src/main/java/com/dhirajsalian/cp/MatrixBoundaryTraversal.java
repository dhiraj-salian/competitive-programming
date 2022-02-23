package com.dhirajsalian.cp;

/*
Given an integer matrix M, print the boundary elements of the matrix.

Examples:

Input 1: M = [ 1 2 3 4
               5 6 7 8
               9 10 11 12
               13 14 15 16 ]
Output 1: 1 2 3 4 8 12 16 15 14 13 9 5

Input 2: M = [ 1 2 3 4
               5 6 7 8 ]
Output 2: 1 2 3 4 8 7 6 5

Input 3: M = [ 1 2 3 4 ]
Output 3: 1 2 3 4

Input 4: M = [ 1
               2
               3 ]
Output 4: 1 2 3

Input 5: M = [ 1 2
               3 4
               5 6 ]
Output 5: 1 2 4 6 5 3

Source: geeksforgeeks.org
 */
public class MatrixBoundaryTraversal {

    static void printBoundaries(int[][] m) {
        int r = m.length, c = m[0].length;
        if (r == 1) {
            for (int i = 0; i < c; i++) System.out.print(m[0][i] + " ");
        } else if (c == 1) {
            for (int i = 0; i < r; i++) System.out.print(m[i][0] + " ");
        } else {
            for (int i = 0; i < c; i++) System.out.print(m[0][i] + " ");
            for (int i = 1; i < r; i++) System.out.print(m[i][c - 1] + " ");
            for (int i = c - 2; i >= 0; i--) System.out.print(m[r - 1][i] + " ");
            for (int i = r - 2; i >= 1; i--) System.out.print(m[i][0] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                {{1, 2, 3, 4}, {5, 6, 7, 8}},
                {{1, 2, 3, 4}},
                {{1}, {2}, {3}},
                {{1, 2}, {3, 4}, {5, 6}}
        };
        for (int[][] input : inputs) {
            printBoundaries(input);
        }
    }
}
