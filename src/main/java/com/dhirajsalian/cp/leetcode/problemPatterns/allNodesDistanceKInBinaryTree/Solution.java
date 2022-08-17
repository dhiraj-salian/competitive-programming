// Problem: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.allNodesDistanceKInBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, null, parent);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        int distance = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = q.poll();
                if (distance == k) result.add(curr.val);
                if (curr.left != null && !seen.contains(curr.left)) {
                    q.add(curr.left);
                    seen.add(curr.left);
                }
                if (curr.right != null && !seen.contains(curr.right)) {
                    q.add(curr.right);
                    seen.add(curr.right);
                }
                if (parent.get(curr) != null && !seen.contains(parent.get(curr))) {
                    q.add(parent.get(curr));
                    seen.add(parent.get(curr));
                }
            }
            distance++;
        }
        return result;
    }

    void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) return;
        parentMap.put(root, parent);
        dfs(root.left, root, parentMap);
        dfs(root.right, root, parentMap);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}