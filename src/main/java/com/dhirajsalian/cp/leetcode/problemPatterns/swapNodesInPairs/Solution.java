// Problem: https://leetcode.com/problems/swap-nodes-in-pairs/

package com.dhirajsalian.cp.leetcode.problemPatterns.swapNodesInPairs;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head, prev = null;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next;
            if (prev != null) prev.next = temp;
            curr.next = curr.next.next;
            temp.next = curr;
            if (prev == null) head = temp;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
