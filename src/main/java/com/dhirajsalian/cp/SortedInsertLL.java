package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a sorted linked list and a value, insert the value in linked list such that the linked list remains sorted.

Examples:

Input 1: 10->20->30->40->NULL, val = 25
Output 1: 10->20->25->30->40->NULL

Input 2: 10->25->NULL, val = 5
Output 2: 5->10->25->NULL

Input 3: 10->20->NULL, val = 30
Output 3: 10->20->30->NULL

Input 4: NULL, val = 10
Output 4: 10->NULL

Source: geeksforgeeks.org
 */
public class SortedInsertLL {

    static LLNode sortedInsert(LLNode head, int value) {
        LLNode valNode = new LLNode(value);
        if (head == null) {
            return valNode;
        }
        LLNode curr = head, prev = null;
        while (curr != null && curr.value < value) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            valNode.next = head;
            return valNode;
        }
        valNode.next = prev.next;
        prev.next = valNode;
        return head;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 30, 40}, {10, 25}, {10, 20}, {}};
        int[] inputVal = {25, 5, 30, 10};
        for (int i = 0; i < inputs.length; i++) {
            LLNode head = CustomUtil.createLinkedList(inputs[i]);
            CustomUtil.printLinkedList(sortedInsert(head, inputVal[i]));
        }
    }
}
