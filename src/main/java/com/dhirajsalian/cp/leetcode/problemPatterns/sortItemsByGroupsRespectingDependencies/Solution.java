// Problem: https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/

package com.dhirajsalian.cp.leetcode.problemPatterns.sortItemsByGroupsRespectingDependencies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = m++;
        }
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        for (int i = 0; i < n; i++) itemGraph.computeIfAbsent(i, ArrayList::new);
        for (int i = 0; i < m; i++) groupGraph.computeIfAbsent(i, ArrayList::new);
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int j : beforeItems.get(i)) {
                itemGraph.get(j).add(i);
                if (group[j] != group[i]) {
                    List<Integer> currGroupNexts = groupGraph.get(group[j]);
                    if (!currGroupNexts.contains(group[i])) currGroupNexts.add(group[i]);
                }
            }
        }
        List<Integer> sortedItems = new ArrayList<>();
        if (!topologicalSort(n, itemGraph, sortedItems)) return new int[0];
        List<Integer> sortedGroups = new ArrayList<>();
        if (!topologicalSort(m, groupGraph, sortedGroups)) return new int[0];
        Map<Integer, List<Integer>> groupItems = new HashMap<>();
        for (int currItem : sortedItems) {
            groupItems.putIfAbsent(group[currItem], new ArrayList<>());
            groupItems.get(group[currItem]).add(currItem);
        }
        int[] res = new int[n];
        int index = 0;
        for (int currGroup : sortedGroups) {
            if (groupItems.containsKey(currGroup)) {
                for (int item : groupItems.get(currGroup))
                    res[index++] = item;
            }
        }
        return res;
    }

    private boolean topologicalSort(int n, Map<Integer, List<Integer>> graph, List<Integer> sortedOrder) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j : graph.get(i)) {
                inDegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (inDegree[i] == 0) q.add(i);
        while (!q.isEmpty()) {
            int currItem = q.poll();
            sortedOrder.add(currItem);
            for (int neighbor : graph.get(currItem)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) q.add(neighbor);
            }
        }
        return sortedOrder.size() == n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ans = sol.sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, List.of(Collections.emptyList(),
                List.of(6), List.of(5), List.of(6), List.of(3, 6), Collections.emptyList(),
                Collections.emptyList(), Collections.emptyList()));
    }
}
