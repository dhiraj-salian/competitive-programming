package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a singly linked list, insert at beginning of singly linked list.

Examples:

Input 1: 10->20->30->NULL, x = 5
Output 1: 5->10->20->30->NULL

Input 2: 10->NULL, x = 5
Output 2: 5->10->NULL

Input 3: NULL, x = 5
Output 3: 5->NULL

Source: geeksforgeeks.org
 */
public class InsertBeginningSLL {

    static LLNode insertBeginning(LLNode head, int x) {
        return new LLNode(x, head);
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 30}, {10}, {}};
        int[] inputX = {5, 5, 5};
        for (int i = 0; i < inputs.length; i++) {
            LLNode head = CustomUtil.createLinkedList(inputs[i]);
            LLNode newHead = insertBeginning(head, inputX[i]);
            CustomUtil.printLinkedList(newHead);
        }
    }
}
