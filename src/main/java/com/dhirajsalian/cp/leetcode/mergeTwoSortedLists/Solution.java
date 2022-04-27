// Problem: https://leetcode.com/problems/merge-two-sorted-lists/

package com.dhirajsalian.cp.leetcode.mergeTwoSortedLists;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;
        ListNode sortedList = null, curr = null;
        ListNode curr1 = list1, curr2 = list2;
        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                if (curr == null) {
                    curr = curr1;
                    sortedList = curr;
                } else {
                    curr.next = curr1;
                    curr = curr.next;
                }
                curr1=curr1.next;
            } else {
                if(curr==null) {
                    curr = curr2;
                    sortedList = curr;
                } else {
                    curr.next = curr2;
                    curr = curr.next;
                }
                curr2 = curr2.next;
            }
        }
        if(curr1!=null) curr.next = curr1;
        if(curr2!=null) curr.next = curr2;
        return sortedList;
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
