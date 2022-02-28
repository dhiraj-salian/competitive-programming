package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a singly linked list, insert at end of singly linked list.

Examples:

Input 1: 10->20->30->NULL, x = 40
Output 1: 10->20->30->40->NULL

Input 2: 10->NULL, x = 20
Output 2: 10->20->NULL

Input 3: NULL, x = 10
Output 3: 10->NULL

Source: geeksforgeeks.org
 */
public class InsertEndSLL {
    static LLNode insertEnd(LLNode head, int x) {
        LLNode end = new LLNode(x, null);
        if (head == null) return end;
        LLNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = end;
        return head;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 30}, {10}, {}};
        int[] inputX = {40, 20, 10};
        for (int i = 0; i < inputs.length; i++) {
            LLNode head = CustomUtil.createLinkedList(inputs[i]);
            LLNode newHead = insertEnd(head, inputX[i]);
            CustomUtil.printLinkedList(newHead);
        }
    }
}
