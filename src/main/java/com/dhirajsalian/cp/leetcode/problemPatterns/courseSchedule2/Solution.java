// Problem: https://leetcode.com/problems/course-schedule-ii/

package com.dhirajsalian.cp.leetcode.problemPatterns.courseSchedule2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = getGraph(numCourses, prerequisites);
        int[] result = new int[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) inDegree[prerequisites[i][0]]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        int index = 0;
        while (!q.isEmpty()) {
            int vertex = q.poll();
            result[index++] = vertex;
            for (int neighbour : graph.get(vertex)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) q.add(neighbour);
            }
        }
        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] != 0)
                return new int[]{};
        return result;
    }

    private List<List<Integer>> getGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        return graph;
    }
}
