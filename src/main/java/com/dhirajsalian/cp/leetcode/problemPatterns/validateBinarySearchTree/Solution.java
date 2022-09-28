// Problem: https://leetcode.com/problems/validate-binary-search-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.validateBinarySearchTree;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int minVal, int maxVal) {
        if (root == null) return true;
        return root.val > minVal && root.val < maxVal
                && isValidBST(root.left, minVal, root.val)
                && isValidBST(root.right, root.val, maxVal);
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
