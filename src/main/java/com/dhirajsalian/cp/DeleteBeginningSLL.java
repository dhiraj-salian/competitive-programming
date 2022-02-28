package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a singly linked list, delete at beginning of singly linked list.

Examples:

Input 1: 10->20->30->40->NULL
Output 1: 20->30->40->NULL

Input 2: 10->NULL
Output 2: NULL

Input 3: NULL
Output 3: NULL

Source: geeksforgeeks.org
 */
public class DeleteBeginningSLL {

    static LLNode deleteBeginning(LLNode head) {
        if (head == null) return null;
        return head.next;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 30, 40}, {10}, {}};
        for (int i = 0; i < inputs.length; i++) {
            LLNode head = CustomUtil.createLinkedList(inputs[i]);
            LLNode newHead = deleteBeginning(head);
            CustomUtil.printLinkedList(newHead);
        }
    }
}
