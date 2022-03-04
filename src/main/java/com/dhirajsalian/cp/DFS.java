package com.dhirajsalian.cp;

import java.util.ArrayList;

import static com.dhirajsalian.cp.util.CustomUtil.addUndirectedEdge;

/*
Given an undirected graph and source s, print the DFS from source s.

Examples:

Input 1:              0     , s = 0
                     / \
                    1   4
                   /   / \
                  2   5---6
                 /
                3
Output 1: 0 1 2 3 4 5 6

Input 2:            0---1---4---5   , s = 0
                    |   |
                    2---3
Output 2: 0 1 3 2 4 5

Source: geeksforgeeks.org
 */
public class DFS {

    static void dfs(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited) {
        visited[s] = true;
        System.out.printf("%s ", s);
        for (int i = 0; i < graph.get(s).size(); i++) {
            Integer sibling = graph.get(s).get(i);
            if (!visited[sibling]) {
                dfs(graph, sibling, visited);
            }
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int s) {
        boolean[] visited = new boolean[graph.size()];
        dfs(graph, s, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        dfs(input1(), 0);
        dfs(input2(), 0);
    }

    static ArrayList<ArrayList<Integer>> input1() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<>());
        }
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 1, 2);
        addUndirectedEdge(graph, 2, 3);
        addUndirectedEdge(graph, 0, 4);
        addUndirectedEdge(graph, 4, 5);
        addUndirectedEdge(graph, 4, 6);
        addUndirectedEdge(graph, 5, 6);
        return graph;
    }

    static ArrayList<ArrayList<Integer>> input2() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 1, 4);
        addUndirectedEdge(graph, 2, 3);
        addUndirectedEdge(graph, 4, 5);
        return graph;
    }
}
