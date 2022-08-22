// Problem: https://leetcode.com/problems/diameter-of-binary-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.diameterOfABinaryTree;

class Solution {
    int result = 0;

    public int diameterOfBinaryTreeRec(TreeNode root) {
        if (root == null) return 0;

        int left = diameterOfBinaryTreeRec(root.left);
        int right = diameterOfBinaryTreeRec(root.right);

        result = Math.max(left + right + 1, result);
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeRec(root);
        return result-1;
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
