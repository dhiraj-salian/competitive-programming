// Problem: https://leetcode.com/problems/pacific-atlantic-water-flow/

package com.dhirajsalian.cp.leetcode.problemPatterns.pacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] flowsAtl = new boolean[m][n];
        boolean[][] flowsPac = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            flows(i, 0, heights[i][0], flowsPac, m, n, heights);
            flows(i, n - 1, heights[i][n - 1], flowsAtl, m, n, heights);
        }
        for (int i = 0; i < n; i++) {
            flows(0, i, heights[0][i], flowsPac, m, n, heights);
            flows(m - 1, i, heights[m - 1][i], flowsAtl, m, n, heights);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flowsAtl[i][j] && flowsPac[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    private void flows(int i, int j, int previousHeight, boolean[][] visited, int m, int n, int[][] height) {
        if (i < 0 || i >= m || j < 0 || j >= n || previousHeight > height[i][j] || visited[i][j]) return;
        visited[i][j] = true;
        flows(i, j + 1, height[i][j], visited, m, n, height);
        flows(i, j - 1, height[i][j], visited, m, n, height);
        flows(i - 1, j, height[i][j], visited, m, n, height);
        flows(i + 1, j, height[i][j], visited, m, n, height);
    }
}

