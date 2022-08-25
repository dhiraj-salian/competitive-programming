// Problem: https://leetcode.com/problems/number-of-islands/

package com.dhirajsalian.cp.leetcode.problemPatterns.numberOfIslands;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(i, j, m, n, grid);
                    //dfs(i, j, m, n, grid);
                }
            }
        }
        return res;
    }

    private void bfs(int i, int j, int m, int n, char[][] grid) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(i, j));
        grid[i][j] = '2';
        while (!q.isEmpty()) {
            List<Integer> curr = q.poll();
            int ci = curr.get(0), cj = curr.get(1);
            visit(i - 1, j, m, n, grid, q);
            visit(i + 1, j, m, n, grid, q);
            visit(i, j - 1, m, n, grid, q);
            visit(i, j + 1, m, n, grid, q);
        }
    }

    private void visit(int i, int j, int m, int n, char[][] grid, Queue<List<Integer>> q) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != '2') {
            grid[i][j] = '2';
            q.add(Arrays.asList(i, j));
        }
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
