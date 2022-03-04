package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.dhirajsalian.cp.util.CustomUtil.addUndirectedEdge;

/*
Given an unweighted graph and source, find the shortest path from source to all other vertices.

Examples:
Note: Inputs can be determined from code.

Output 1: 0 1 1 2

Output 2: 0 1 1 2 1 2

Source: geeksforgeeks.org
 */
public class ShortestPathUnweightedGraph {

    static void printShortestPath(ArrayList<ArrayList<Integer>> graph, int source) {
        int[] path = new int[graph.size()];
        Arrays.fill(path, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        path[source] = 0;
        while (!q.isEmpty()) {
            int vertex = q.poll();
            for (int i = 0; i < graph.get(vertex).size(); i++) {
                int sibling = graph.get(vertex).get(i);
                if (path[sibling] < 0) {
                    q.add(sibling);
                    path[sibling] = path[vertex] + 1;
                }
            }
        }
        CustomUtil.print(path);
    }

    public static void main(String[] args) {
        printShortestPath(input1(), 0);
        printShortestPath(input2(), 0);
    }

    static ArrayList<ArrayList<Integer>> input1() {
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

    static ArrayList<ArrayList<Integer>> input2() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 0, 4);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 2, 3);
        addUndirectedEdge(graph, 2, 4);
        addUndirectedEdge(graph, 3, 5);
        addUndirectedEdge(graph, 4, 5);
        return graph;
    }
}
