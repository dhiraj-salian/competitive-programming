// Problem: https://leetcode.com/problems/palindrome-linked-list/

package com.dhirajsalian.cp.leetcode.problemPatterns.palindromeLinkedList;

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

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        int count = 0;
        while(slow!=null) {
            count++;
            slow = slow.next;
        }
        slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (count % 2 == 1) slow = slow.next;
        slow = reverse(slow);
        ListNode temp = head;
        while (slow != null) {
            if (slow.val != temp.val) return false;
            slow = slow.next;
            temp = temp.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }
}
