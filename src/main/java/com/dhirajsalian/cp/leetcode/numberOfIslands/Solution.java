// Problem: https://leetcode.com/problems/number-of-islands/

package com.dhirajsalian.cp.leetcode.numberOfIslands;

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, m, n, grid);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, int m, int n, char[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '2';
        dfs(i, j - 1, m, n, grid);
        dfs(i, j + 1, m, n, grid);
        dfs(i - 1, j, m, n, grid);
        dfs(i + 1, j, m, n, grid);
    }
}
