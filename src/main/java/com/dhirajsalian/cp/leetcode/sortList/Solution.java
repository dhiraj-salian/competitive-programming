// Problem: https://leetcode.com/problems/sort-list/

package com.dhirajsalian.cp.leetcode.sortList;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode tail = head;
        while (tail.next != null) tail = tail.next;
        return mergeSort(head, tail);
    }

    ListNode mergeSort(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode middle = head, fast = head;
            while (fast != tail && fast.next != tail) {
                middle = middle.next;
                fast = fast.next.next;
            }
            ListNode anotherHead = middle.next;
            middle.next = null;
            ListNode head1 = mergeSort(head, middle);
            ListNode head2 = mergeSort(anotherHead, tail);
            return merge(head1, head2);
        }
        return head;
    }

    ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;
        ListNode curr = null, head = null;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                if (curr == null) {
                    curr = head1;
                    head1 = head1.next;
                    head = curr;
                } else {
                    curr.next = head1;
                    head1 = head1.next;
                    curr = curr.next;
                }
            } else {
                if (curr == null) {
                    curr = head2;
                    head2 = head2.next;
                    head = curr;
                } else {
                    curr.next = head2;
                    head2 = head2.next;
                    curr = curr.next;
                }
            }
        }
        curr.next = head1 == null ? head2 : head1;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode next3 = new ListNode(1);
        ListNode next2 = new ListNode(3, next3);
        ListNode next1 = new ListNode(2, next2);
        ListNode head = new ListNode(4, next1);
        head = solution.sortList(head);
        while (head.next != null) {
            System.out.printf("%s->", head.val);
            head = head.next;
        }
        System.out.println(head.val);
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