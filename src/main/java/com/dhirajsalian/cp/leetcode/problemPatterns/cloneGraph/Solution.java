// Problem: https://leetcode.com/problems/clone-graph/

package com.dhirajsalian.cp.leetcode.problemPatterns.cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
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
