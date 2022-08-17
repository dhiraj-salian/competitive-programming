// Problem: https://leetcode.com/problems/minimum-height-trees/

package com.dhirajsalian.cp.leetcode.problemPatterns.minimumHeightTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            inDegree[edges[i][0]]++;
            inDegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) if (inDegree[i] == 1) q.add(i);
        int totalNodes = n;
        while (totalNodes > 2) {
            int leaves = q.size();
            totalNodes -= leaves;
            for (int i = 0; i < leaves; i++) {
                int vertex = q.poll();
                for (int neighbor : graph.get(vertex)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 1) q.add(neighbor);
                }
            }
        }
        return new ArrayList<>(q);
    }
}
