package com.dhirajsalian.cp.leetcode.oddEvenLinkedList;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = null, even = null, oddHead = null, evenHead = null;
        ListNode curr = head;
        int count = 1;
        while (curr != null) {
            if (count % 2 == 0) {
                if (even == null) {
                    even = curr;
                    evenHead = even;
                } else {
                    even.next = curr;
                    even = even.next;
                }
            } else {
                if (odd == null) {
                    odd = curr;
                    oddHead = odd;
                } else {
                    odd.next = curr;
                    odd = odd.next;
                }
            }
            curr = curr.next;
            count++;
        }
        odd.next = evenHead;
        if(even!=null) even.next = null;
        return oddHead;
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