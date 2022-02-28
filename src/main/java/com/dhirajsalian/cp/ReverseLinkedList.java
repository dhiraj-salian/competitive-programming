package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a linked list, reverse the linked list.

Examples:

Input 1: 10->20->30->40->NULL
Output 1: 40->30->20->10->NULL

Input 2: 10->20->30->NULL
Output 2: 30->20->10->NULL

Input 3: 10->NULL
Output 3: 10->NULL

Input 4: NULL
Output 4: NULL

Source: geeksforgeeks.org
 */
public class ReverseLinkedList {

    static LLNode reverse(LLNode head) {
        if (head == null) return null;
        LLNode curr = head, prev = null;
        while (curr != null) {
            LLNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    static LLNode reverse(LLNode curr, LLNode prev) {
        if (curr == null) return prev;
        LLNode temp = curr.next;
        curr.next = prev;
        return reverse(temp, curr);
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 30, 40}, {10, 20, 30}, {10}, {}};
        for (int[] input : inputs) {
            LLNode head = CustomUtil.createLinkedList(input);
            CustomUtil.printLinkedList(reverse(head,null));
        }
    }
}
