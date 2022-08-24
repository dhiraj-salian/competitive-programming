// Problem: https://leetcode.com/problems/clone-graph/

package com.dhirajsalian.cp.leetcode.problemPatterns.cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

    // BFS Solution
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> visited = new HashMap<>();
        queue.add(node);
        visited.put(node.val, new Node(node.val));
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            Node clonedNode = visited.get(currNode.val);
            for (Node neighbor : currNode.neighbors) {
                Node clonedNeighbor = visited.containsKey(neighbor.val) ?
                        visited.get(neighbor.val) : new Node(neighbor.val);
                clonedNode.neighbors.add(clonedNeighbor);
                if (!visited.containsKey(neighbor.val)) {
                    queue.add(neighbor);
                    visited.put(neighbor.val, clonedNeighbor);
                }
            }
        }
        return visited.get(1);
    }


    /*
    DFS Solution
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        return cloneGraph(node, new HashMap<>());
    }

    private Node cloneGraph(Node node, Map<Integer, Node> visited) {
        if (visited.containsKey(node.val))
            return visited.get(node.val);
        Node clonedNode = new Node(node.val);
        visited.put(node.val, clonedNode);
        for (Node neighbor : node.neighbors) {
            Node clonedNeighbor = cloneGraph(neighbor, visited);
            clonedNode.neighbors.add(clonedNeighbor);
        }
        return clonedNode;
    }

    */
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
