// Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/

package com.dhirajsalian.cp.leetcode.problemPatterns.binaryTreeMaximumPathSum;

class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int rootMax = maxPathSumRec(root);
        return Math.max(max, rootMax);
    }

    public int maxPathSumRec(TreeNode root) {
        if (root == null) return 0;
        int left = maxPathSumRec(root.left);
        int right = maxPathSumRec(root.right);
        if(root.left!=null) max = Math.max(max, left);
        if(root.right!=null) max = Math.max(max, right);
        max = Math.max(max, root.val + left + right);
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
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