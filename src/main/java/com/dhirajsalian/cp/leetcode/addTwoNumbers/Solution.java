// Problem: https://leetcode.com/problems/add-two-numbers/

package com.dhirajsalian.cp.leetcode.addTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = null, head = null;
        int carryForward = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carryForward;
            if (prev == null) {
                prev = new ListNode(sum % 10);
                head = prev;
            } else {
                prev.next = new ListNode(sum % 10);
                prev = prev.next;
            }
            carryForward = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carryForward > 0)
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
