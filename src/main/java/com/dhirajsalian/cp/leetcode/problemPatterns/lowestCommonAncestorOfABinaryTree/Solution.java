// Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.lowestCommonAncestorOfABinaryTree;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null) return left;
        else if (right != null) return right;
        else return root;
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
