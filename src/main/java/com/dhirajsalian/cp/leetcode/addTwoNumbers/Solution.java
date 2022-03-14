// Problem: https://leetcode.com/problems/add-two-numbers/

package com.dhirajsalian.cp.leetcode.addTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = null, head = null;
        int carryForward = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryForward;
            if (prev == null) {
                prev = new ListNode(sum % 10);
                head = prev;
            } else {
                prev.next = new ListNode(sum % 10);
                prev = prev.next;
            }
            carryForward = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carryForward;
            prev.next = new ListNode(sum % 10);
            carryForward = sum / 10;
            l1 = l1.next;
            prev = prev.next;
        }
        while (l2 != null) {
            int sum = l2.val + carryForward;
            prev.next = new ListNode(sum % 10);
            carryForward = sum / 10;
            l2 = l2.next;
            prev = prev.next;
        }
        if (l1 == null && l2 == null && carryForward != 0)
            prev.next = new ListNode(carryForward);
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
