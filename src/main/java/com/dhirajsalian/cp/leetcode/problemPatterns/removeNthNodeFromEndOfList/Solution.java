// Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

package com.dhirajsalian.cp.leetcode.problemPatterns.removeNthNodeFromEndOfList;

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


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode curr = head, nthNodePrev = null;
        while (curr != null) {
            if (nthNodePrev != null) nthNodePrev = nthNodePrev.next;
            curr = curr.next;
            n--;
            if (n == -1) nthNodePrev = head;
        }
        if (nthNodePrev == null) head = head.next;
        else nthNodePrev.next = nthNodePrev.next.next;
        return head;
    }
}
