// Problem: https://leetcode.com/problems/same-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.sameTree;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
