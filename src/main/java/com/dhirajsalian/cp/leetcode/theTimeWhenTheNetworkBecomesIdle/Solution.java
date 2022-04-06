// Problem: https://leetcode.com/problems/the-time-when-the-network-becomes-idle/

package com.dhirajsalian.cp.leetcode.theTimeWhenTheNetworkBecomesIdle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        ArrayList<ArrayList<Integer>> graph = getGraph(n, edges);
        int[] shortestPath = new int[n];
        boolean[] visited = new boolean[n];
        shortestPath[0] = 0;
        Arrays.fill(shortestPath, 1, n, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int vertex = q.poll();
            for (int i = 0; i < graph.get(vertex).size(); i++) {
                int sibling = graph.get(vertex).get(i);
                if (!visited[sibling]) {
                    q.add(sibling);
                    visited[sibling] = true;
                    if (shortestPath[sibling] == -1) {
                        shortestPath[sibling] = shortestPath[vertex] + 1;
                    } else
                        shortestPath[sibling] = Math.min(shortestPath[sibling], shortestPath[vertex] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, getTimeToComplete(shortestPath[i], patience[i]));
        }
        return res;
    }

    private int getTimeToComplete(int path, int patience) {
        return (patience >= (path * 2) ? (path * 2) : ((2 * path) % patience == 0 ? (4 * path - patience) : (4 * path - (2 * path) % patience))) + 1;
    }

    private ArrayList<ArrayList<Integer>> getGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }

}