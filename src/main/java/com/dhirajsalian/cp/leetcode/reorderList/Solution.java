// Problem: https://leetcode.com/problems/reorder-list/

package com.dhirajsalian.cp.leetcode.reorderList;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode middle = head, fast = head, prevMid = null;
        while (fast != null && fast.next != null) {
            prevMid = middle;
            middle = middle.next;
            fast = fast.next.next;
        }
        middle = reverse(middle);
        prevMid.next = null;
        merge(head, middle);
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newTail = head.next;
        ListNode newHead = reverse(head.next);
        head.next = newTail.next;
        newTail.next = head;
        return newHead;
    }

    void merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return;
        ListNode curr = head1;
        head1 = head1.next;
        boolean second = true;
        while (head1 != null && head2 != null) {
            if (second) {
                curr.next = head2;
                head2 = head2.next;
            } else {
                curr.next = head1;
                head1 = head1.next;
            }
            curr = curr.next;
            second = !second;
        }
        curr.next = head1 == null ? head2 : head1;
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