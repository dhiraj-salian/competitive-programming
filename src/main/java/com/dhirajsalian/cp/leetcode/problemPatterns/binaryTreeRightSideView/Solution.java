// Problem: https://leetcode.com/problems/binary-tree-right-side-view/

package com.dhirajsalian.cp.leetcode.problemPatterns.binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    /*

    BFS Approach

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                if (i == qSize - 1) result.add(curr.val);
            }
        }
        return result;
    }

    */

    // DFS Approach

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, 0, result);
        return result;
    }

    private void rightSideView(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;
        if (result.size() == level) result.add(root.val);
        rightSideView(root.right, level + 1, result);
        rightSideView(root.left, level + 1, result);
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