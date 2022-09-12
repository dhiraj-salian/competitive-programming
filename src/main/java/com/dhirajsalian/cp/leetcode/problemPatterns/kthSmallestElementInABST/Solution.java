// Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

package com.dhirajsalian.cp.leetcode.problemPatterns.kthSmallestElementInABST;

class Solution {

    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        int res = kthSmallest(root.left, k);
        if (res != -1) return res;
        count++;
        if (count == k) return root.val;
        res = kthSmallest(root.right, k);
        return res;
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