package com.dhirajsalian.cp;

import java.util.ArrayList;

import static com.dhirajsalian.cp.util.CustomUtil.addDirectedEdge;
import static com.dhirajsalian.cp.util.CustomUtil.yesOrNo;

/*
Given a directed graph, detect cycle in the graph.

Examples:
Note: Inputs can be determined from code.

Output 1: Yes

Output 2: No

Output 3: Yes

Source: geeksforgeeks.org
 */
public class DetectCycleDirectedGraph {

    static boolean detectCycle(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited, boolean[] inRecursion) {
        visited[vertex] = true;
        inRecursion[vertex] = true;
        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int sibling = graph.get(vertex).get(i);
            if (!visited[sibling]) {
                if (detectCycle(graph, sibling, visited, inRecursion)) {
                    return true;
                }
            } else if (inRecursion[sibling]) {
                return true;
            }
        }
        inRecursion[vertex] = false;
        return false;
    }

    static boolean detectCycle(ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        boolean[] inRecursion = new boolean[graph.size()];
        boolean cycleDetected = false;
        for (int i = 0; i < graph.size(); i++)
            if (!visited[i])
                cycleDetected |= detectCycle(graph, 0, visited, inRecursion);
        return cycleDetected;
    }

    public static void main(String[] args) {
        System.out.println(yesOrNo(detectCycle(input1())));
        System.out.println(yesOrNo(detectCycle(input2())));
        System.out.println(yesOrNo(detectCycle(input3())));
    }

    static ArrayList<ArrayList<Integer>> input1() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        addDirectedEdge(graph, 0, 1);
        addDirectedEdge(graph, 1, 2);
        addDirectedEdge(graph, 2, 3);
        addDirectedEdge(graph, 3, 1);
        return graph;
    }

    static ArrayList<ArrayList<Integer>> input2() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        addDirectedEdge(graph, 0, 1);
        addDirectedEdge(graph, 2, 1);
        addDirectedEdge(graph, 1, 3);
        addDirectedEdge(graph, 2, 3);
        return graph;
    }

    static ArrayList<ArrayList<Integer>> input3() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<>());
        }
        addDirectedEdge(graph, 0, 1);
        addDirectedEdge(graph, 1, 2);
        addDirectedEdge(graph, 2, 3);
        addDirectedEdge(graph, 3, 4);
        addDirectedEdge(graph, 4, 5);
        addDirectedEdge(graph, 5, 2);
        addDirectedEdge(graph, 5, 3);
        return graph;
    }
}
