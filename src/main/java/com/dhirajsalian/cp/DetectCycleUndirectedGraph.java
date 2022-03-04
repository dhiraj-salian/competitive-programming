package com.dhirajsalian.cp;

import java.util.ArrayList;

import static com.dhirajsalian.cp.util.CustomUtil.addUndirectedEdge;
import static com.dhirajsalian.cp.util.CustomUtil.yesOrNo;

/*
Given an undirected, detect cycle in the graph.

Examples:
Note: Inputs can be determined from code.

Output 1: Yes

Output 2: No

Output 3: Yes

Source: geeksforgeeks.org
 */
public class DetectCycleUndirectedGraph {

    static boolean detectCycle(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited, int parent) {
        visited[s] = true;
        for (int i = 0; i < graph.get(s).size(); i++) {
            int sibling = graph.get(s).get(i);
            if (!visited[sibling]) {
                if (detectCycle(graph, sibling, visited, s)) {
                    return true;
                }
            } else if (sibling != parent)
                return true;
        }
        return false;
    }

    static boolean detectCycle(ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        return detectCycle(graph, 0, visited, -1);
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
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 1, 2);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 2, 3);
        return graph;
    }

    static ArrayList<ArrayList<Integer>> input2() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 1, 2);
        addUndirectedEdge(graph, 1, 4);
        addUndirectedEdge(graph, 2, 3);
        return graph;
    }

    static ArrayList<ArrayList<Integer>> input3() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 3);
        addUndirectedEdge(graph, 1, 2);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 2, 3);
        return graph;
    }
}
