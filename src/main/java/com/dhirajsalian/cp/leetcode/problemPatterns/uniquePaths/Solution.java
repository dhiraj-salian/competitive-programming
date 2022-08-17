// Problem: https://leetcode.com/problems/unique-paths/

package com.dhirajsalian.cp.leetcode.problemPatterns.uniquePaths;

class Solution {

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for (int i = 1; i < m; i++) {
            paths[i][0] = paths[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            paths[0][i] = paths[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }
}
