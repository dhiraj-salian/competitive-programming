// Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

package com.dhirajsalian.cp.leetcode.problemPatterns.binaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Stack<List<Integer>> stack = new Stack<>();
        while (!q.isEmpty()) {
            List<Integer> currResult = new ArrayList<>();
            int currSize = q.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode curr = q.poll();
                currResult.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            stack.push(currResult);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!stack.isEmpty()) result.add(stack.pop());
        return result;
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
