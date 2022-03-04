package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.GraphWeightedNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.dhirajsalian.cp.util.CustomUtil.addDirectedWeightedEdge;

/*
Given a directed acyclic graph and a source, print the shortest path from source to vertices.

Examples:
Note: Inputs can be determined from code.

Output 1: 0 2 3 6 1 5

Output 2: -1 0 3 2

Source: geeksforgeeks.org
 */
public class ShortestPathDAG {

    static void shortestPath(ArrayList<ArrayList<GraphWeightedNode>> graph, int source) {
        int[] inDegree = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                inDegree[graph.get(i).get(j).value]++;
            }
        }
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int vertex = q.poll();
            inDegree[vertex] = -1;
            for (int i = 0; i < graph.get(vertex).size(); i++) {
                GraphWeightedNode sibling = graph.get(vertex).get(i);
                if (distance[vertex] != Integer.MAX_VALUE)
                    distance[sibling.value] = Math.min(distance[sibling.value], distance[vertex] + sibling.weight);
                inDegree[sibling.value]--;
                if (inDegree[sibling.value] == 0)
                    q.add(sibling.value);
            }
        }
        CustomUtil.print(distance);
    }

    public static void main(String[] args) {
        shortestPath(input1(), 0);
        shortestPath(input2(), 1);
    }

    static ArrayList<ArrayList<GraphWeightedNode>> input1() {
        ArrayList<ArrayList<GraphWeightedNode>> graph = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        addDirectedWeightedEdge(graph, 0, 1, 2);
        addDirectedWeightedEdge(graph, 0, 4, 1);
        addDirectedWeightedEdge(graph, 1, 2, 3);
        addDirectedWeightedEdge(graph, 2, 3, 6);
        addDirectedWeightedEdge(graph, 4, 2, 2);
        addDirectedWeightedEdge(graph, 4, 5, 4);
        addDirectedWeightedEdge(graph, 5, 3, 1);
        return graph;
    }

    static ArrayList<ArrayList<GraphWeightedNode>> input2() {
        ArrayList<ArrayList<GraphWeightedNode>> graph = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        addDirectedWeightedEdge(graph, 0, 1, 1);
        addDirectedWeightedEdge(graph, 1, 2, 3);
        addDirectedWeightedEdge(graph, 1, 3, 2);
        addDirectedWeightedEdge(graph, 2, 3, 4);
        return graph;
    }
}
