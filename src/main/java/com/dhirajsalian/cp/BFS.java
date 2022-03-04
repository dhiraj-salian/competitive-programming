package com.dhirajsalian.cp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static com.dhirajsalian.cp.util.CustomUtil.addUndirectedEdge;

/*
Given an undirected graph and source s, print the BFS from source s.

Input 1:           0            , s = 0
                  /  \
                 1    2
                     /  \
                    3    4
Output 1: 0 1 2 3 4

Input 2:           1        , s = 0
                 / | \
                0--2--3
Output 2: 0 1 2 3

Input 3:              1--3     , s = 0
                     /    \
                    0------5
                     \    /
                      2--4
Output 3: 0 1 2 5 3 4

Source: geeksforgeeks.org
 */
public class BFS {

    static void bfs(ArrayList<ArrayList<Integer>> graph, int s) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int vertex = q.poll();
            System.out.printf("%s ", vertex);
            for (int i = 0; i < graph.get(vertex).size(); i++) {
                int sibling = graph.get(vertex).get(i);
                if (!visited[sibling]) {
                    q.add(sibling);
                    visited[sibling] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        bfs(input1(), 0);
        bfs(input2(), 0);
        bfs(input3(), 0);
    }

    static ArrayList<ArrayList<Integer>> input1() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 2, 3);
        addUndirectedEdge(graph, 2, 4);
        return graph;
    }

    static ArrayList<ArrayList<Integer>> input2() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 1, 2);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 2, 3);
        return graph;
    }

    static ArrayList<ArrayList<Integer>> input3() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 0, 5);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 2, 4);
        addUndirectedEdge(graph, 5, 3);
        addUndirectedEdge(graph, 5, 4);
        return graph;
    }
}
