// Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.lowestCommonAncestorOfABinarySearchTree;

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val <= root.val && q.val <= root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val >= root.val && q.val >= root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
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