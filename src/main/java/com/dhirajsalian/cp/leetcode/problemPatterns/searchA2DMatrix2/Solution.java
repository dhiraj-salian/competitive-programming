// Problem: https://leetcode.com/problems/search-a-2d-matrix-ii/

package com.dhirajsalian.cp.leetcode.problemPatterns.searchA2DMatrix2;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = matrix[0].length - 1;
        while (r < m && c > -1) {
            if (target == matrix[r][c]) return true;
            if (target < matrix[r][c]) c--;
            else r++;
        }
        return false;
    }
}
