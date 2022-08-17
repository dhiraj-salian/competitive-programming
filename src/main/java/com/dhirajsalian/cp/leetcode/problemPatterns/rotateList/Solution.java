// Problem: https://leetcode.com/problems/rotate-list/

package com.dhirajsalian.cp.leetcode.problemPatterns.rotateList;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int rotateBy = k%count;
        if(rotateBy==0) return head;
        curr = head;
        for (int i = 0; i < rotateBy; i++) {
            curr = curr.next;
        }
        ListNode prevK = null, kth = head, tail = null;
        while (curr != null) {
            prevK = kth;
            kth = kth.next;
            if (curr.next == null) tail = curr;
            curr = curr.next;
        }
        if (prevK != null) prevK.next = null;
        if (tail != null) tail.next = head;
        return kth;
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
