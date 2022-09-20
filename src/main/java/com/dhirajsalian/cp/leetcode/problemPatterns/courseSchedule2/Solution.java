// Problem: https://leetcode.com/problems/course-schedule-ii/

package com.dhirajsalian.cp.leetcode.problemPatterns.courseSchedule2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    /*

    Topological Sort BFS

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

    */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            inDegree[prereq[0]]++;
        }
        int completedCourses = 0;
        int[] result = new int[numCourses];
        while (completedCourses < numCourses) {
            int vertex = getNonDependentVertex(inDegree);
            if(vertex==-1) return new int[]{};
            for (int[] prereq : prerequisites) if (vertex == prereq[1]) inDegree[prereq[0]]--;
            inDegree[vertex] = -1;
            result[completedCourses] = vertex;
            completedCourses++;
        }
        for (int i = 0; i < inDegree.length; i++) if (inDegree[i] != -1) return new int[]{};
        return result;
    }

    public int getNonDependentVertex(int[] inDegree) {
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) return i;
        }
        return -1;
    }
}
