package com.dhirajsalian.cp;

/*
Given a matrix M, traverse the matrix in spiral order.

Examples:

Input 1: [ 1 2 3 4
           5 6 7 8
           9 10 11 12
           13 14 15 16 ]
Output 1: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

Input 2: [ 1 2 3
           4 5 6 ]
Output 2: 1 2 3 6 5 4

Input 3: [ 10 20 30 ]
Output 3: 10 20 30

Input 4: [ 10
           20
           30 ]
Output 4: 10 20 30

Source: geeksforgeeks.org
 */
public class MatrixSpiralTraversal {

    static void spiralRotate(int[][] m) {
        int rs, re, cs, ce;
        rs = cs = 0;
        re = m.length - 1;
        ce = m[0].length - 1;
        while (re >= rs && ce >= cs) {
            if (re == rs) {
                for (int i = cs; i <= ce; i++) System.out.print(m[re][i] + " ");
                rs++;
            } else if (ce == cs) {
                for (int i = rs; i <= re; i++) System.out.print(m[i][ce] + " ");
                cs++;
            } else {
                for (int i = cs; i <= ce; i++) System.out.print(m[rs][i] + " ");
                rs++;
                for (int i = rs; i <= re; i++) System.out.print(m[i][ce] + " ");
                ce--;
                for (int i = ce; i >= cs; i--) System.out.print(m[re][i] + " ");
                re--;
                for (int i = re; i >= rs; i--) System.out.print(m[i][cs] + " ");
                cs++;
            }
        }
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                {{1, 2, 3}, {4, 5, 6}},
                {{10}, {20}, {30}},
                {{10, 20, 30}}
        };
        for (int[][] input : inputs) {
            spiralRotate(input);
            System.out.println();
        }
    }
}
