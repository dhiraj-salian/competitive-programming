// Problem: https://leetcode.com/problems/search-a-2d-matrix/

package com.dhirajsalian.cp.leetcode.searchA2DMatrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1, mid, midValue;
        while (start <= end) {
            mid = (start + end) / 2;
            midValue = matrix[mid / n][mid % n];
            if (target == midValue) {
                return true;
            }
            if (target < midValue) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
