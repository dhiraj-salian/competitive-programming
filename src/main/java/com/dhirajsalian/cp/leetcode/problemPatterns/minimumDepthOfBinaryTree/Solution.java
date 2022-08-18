// Problem: https://leetcode.com/problems/minimum-depth-of-binary-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.minimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // BFS Approach
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null && curr.left == null && curr.right == null) return level;
            if (curr == null) {
                level++;
                q.add(null);
            } else {
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return level;
    }


    /* DFS Approach

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepthRecur(root);
    }

    private int minDepthRecur(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        if (root.left != null && root.right != null)
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        return 1 + (root.left == null ? minDepth(root.right) : minDepth(root.left));
    }

    */
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}