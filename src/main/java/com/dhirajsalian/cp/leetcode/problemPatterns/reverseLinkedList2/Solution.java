package com.dhirajsalian.cp.leetcode.problemPatterns.reverseLinkedList2;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 0;
        ListNode start = null, end = null, startPrev = null, endNext = null, curr = head;
        while (count <= right && curr != null) {
            count++;
            if (count == left - 1) startPrev = curr;
            if (count == left) start = curr;
            if (count == right) end = curr;
            if (count == right + 1) endNext = curr;
            curr = curr.next;
        }
        if (start != null && end != null) {
            end.next = null;
            reverse(start);
            if (startPrev != null) startPrev.next = end;
            start.next = endNext;
        }
        return left == 1 ? end : head;
    }


    ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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
