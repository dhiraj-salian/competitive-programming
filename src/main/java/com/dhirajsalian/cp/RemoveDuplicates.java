package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given sorted singly linked list, remove duplicates from linked list.

Examples:

Input 1: 10->20->20->30->30->30->NULL
Output 1: 10->20->30->NULL

Input 2: 5->10->15->20->NULL
Output 2: 5->10->15->20->NULL

Input 3: NULL
Output 3: NULL

Source: geeksforgeeks.org
 */
public class RemoveDuplicates {

    static void removeDuplicates(LLNode head) {
        if (head == null) return;
        LLNode curr = head;
        while (curr != null) {
            LLNode temp = curr.next;
            while (temp != null && temp.value == curr.value) temp = temp.next;
            curr.next = temp;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 20, 30, 30, 30}, {5, 10, 15, 20}, {}};
        for (int[] input : inputs) {
            LLNode head = CustomUtil.createLinkedList(input);
            removeDuplicates(head);
            CustomUtil.printLinkedList(head);
        }
    }
}
