// Problem: https://leetcode.com/problems/course-schedule/

package com.dhirajsalian.cp.leetcode.problemPatterns.courseSchedule;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = getGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursionStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclic(i, graph, visited, inRecursionStack))
                return false;
        }
        return true;
    }

    private List<List<Integer>> getGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return graph;
    }

    private boolean isCyclic(int vertex, List<List<Integer>> graph, boolean[] visited, boolean[] inRecursionStack) {
        if (visited[vertex]) return false;
        boolean isCyclePresent = false;
        visited[vertex] = true;
        inRecursionStack[vertex] = true;
        for (int neighbour : graph.get(vertex)) {
            if (inRecursionStack[neighbour])
                return true;
            else
                isCyclePresent |= isCyclic(neighbour, graph, visited, inRecursionStack);
        }
        inRecursionStack[vertex] = false;
        return isCyclePresent;
    }

}
