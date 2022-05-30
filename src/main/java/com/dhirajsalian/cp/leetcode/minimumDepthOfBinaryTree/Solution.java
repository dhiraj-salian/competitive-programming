// Problem: https://leetcode.com/problems/minimum-depth-of-binary-tree/

package com.dhirajsalian.cp.leetcode.minimumDepthOfBinaryTree;

class Solution {

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