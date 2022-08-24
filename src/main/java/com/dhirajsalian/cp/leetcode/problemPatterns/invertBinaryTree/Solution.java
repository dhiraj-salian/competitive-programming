// Problem: https://leetcode.com/problems/invert-binary-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.invertBinaryTree;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
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
