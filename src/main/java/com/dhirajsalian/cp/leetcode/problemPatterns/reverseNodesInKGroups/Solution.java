// Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/

package com.dhirajsalian.cp.leetcode.problemPatterns.reverseNodesInKGroups;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode curr = head, newHead = null, prevTail = null, nextHead = null;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == k) {
                nextHead = curr.next;
                curr.next = null;
                ListNode reverseHead = reverse(head);
                if(prevTail!=null) prevTail.next = reverseHead;
                if(newHead == null) newHead = reverseHead;
                count = 0;
                prevTail = head;
                head = curr = nextHead;
            } else {
                curr = curr.next;
            }
        }
        if(count!=0 && prevTail!=null) prevTail.next = nextHead;
        return newHead;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newTail = head.next;
        ListNode newHead = reverse(head.next);
        head.next = newTail.next;
        newTail.next = head;
        return newHead;
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