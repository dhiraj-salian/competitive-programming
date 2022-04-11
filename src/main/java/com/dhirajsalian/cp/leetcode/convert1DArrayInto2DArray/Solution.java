// Problem: https://leetcode.com/problems/convert-1d-array-into-2d-array/

package com.dhirajsalian.cp.leetcode.convert1DArrayInto2DArray;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];
        int index = 0;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = original[index++];
            }
        }
        return arr;
    }
}
