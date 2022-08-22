// Problem: https://leetcode.com/problems/path-sum/

package com.dhirajsalian.cp.leetcode.problemPatterns.pathSum;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int currentSum = targetSum - root.val;
        if (root.left == null && root.right == null) return currentSum == 0;
        return hasPathSum(root.left, currentSum) || hasPathSum(root.right, currentSum);
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
