package com.dhirajsalian.cp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static com.dhirajsalian.cp.util.CustomUtil.addDirectedEdge;

/*
Given a directed acyclic graph, find topological sorting of it.

Examples:
Note: Inputs can be determined from code.

Output 1: 0 1 2

Output 2: 0 1 2 3 4

Output 3: 0 1 2 3 4 5

Source: geeksforgeeks.org
 */
public class TopologicalSorting {

    // Also called Kahn's Algorithm
    static void topologicalSortBFS(ArrayList<ArrayList<Integer>> graph) {
        int[] inDegree = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                inDegree[graph.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int vertex = q.poll();
            inDegree[vertex] = -1;
            System.out.printf("%s ", vertex);
            for (int i = 0; i < graph.get(vertex).size(); i++) {
                int sibling = graph.get(vertex).get(i);
                inDegree[sibling]--;
                if (inDegree[sibling] == 0)
                    q.add(sibling);
            }
        }
        System.out.println();
    }

    static void topologicalSortDFS(ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++)
            if (!visited[i])
                dfs(graph, i, visited, s);
        while (!s.isEmpty()) {
            System.out.printf("%s ", s.pop());
        }
        System.out.println();
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited, Stack<Integer> s) {
        visited[vertex] = true;
        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int sibling = graph.get(vertex).get(i);
            if (!visited[sibling])
                dfs(graph, sibling, visited, s);
        }
        s.push(vertex);
    }

    public static void main(String[] args) {
        topologicalSortDFS(input1());
        topologicalSortDFS(input2());
        topologicalSortDFS(input3());
    }

    static ArrayList<ArrayList<Integer>> input1() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<>());
        }
        addDirectedEdge(graph, 0, 1);
        addDirectedEdge(graph, 0, 2);
        return graph;
    }

    static ArrayList<ArrayList<Integer>> input2() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        addDirectedEdge(graph, 0, 2);
        addDirectedEdge(graph, 0, 3);
        addDirectedEdge(graph, 1, 3);
        addDirectedEdge(graph, 1, 4);
        return graph;
    }

    static ArrayList<ArrayList<Integer>> input3() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        addDirectedEdge(graph, 0, 1);
        addDirectedEdge(graph, 0, 2);
        addDirectedEdge(graph, 1, 3);
        addDirectedEdge(graph, 2, 3);
        addDirectedEdge(graph, 3, 4);
        addDirectedEdge(graph, 3, 5);
        return graph;
    }
}
