// Problem: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

package com.dhirajsalian.cp.leetcode.minTimeToCollectAllApplesInTree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> tree = createTree(n, edges);
        boolean[] visited = new boolean[n];
        return Math.max(minTime(0, tree, hasApple, visited), 0);
    }

    private ArrayList<ArrayList<Integer>> createTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    private int minTime(int vertex, ArrayList<ArrayList<Integer>> tree, List<Boolean> hasApple, boolean[] visited) {
        int res = 0;
        visited[vertex]=true;
        for (int child : tree.get(vertex)) {
            if (!visited[child]) {
                int temp = minTime(child, tree, hasApple, visited);
                if (temp >= 0) res += (temp + 2);
            }
        }
        if (res > 0) return res;
        return hasApple.get(vertex) ? 0 : -1;
    }
}
