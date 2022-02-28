package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a linked list, a position and a value. Insert value at given position in linked list.

Examples:

Input 1: 10->30->50->70->NULL, pos = 2, val = 20
Output 1: 10->20->30->50->70->NULL

Input 2: 5->15->25->35->NULL, pos = 5, val = 10
Output 2: 5->15->25->35->10->NULL

Input 3: 10->20->NULL, pos = 4, val = 5
Output 3: 10->20->NULL

Source: geeksforgeeks.org
 */
public class InsertAtPositionLL {

    static LLNode insertBeginning(LLNode head, int pos, int val) {
        if (pos < 1) return head;
        int currentPos = 1;
        LLNode curr = head, prev = null;
        while (currentPos < pos && curr != null) {
            prev = curr;
            curr = curr.next;
            currentPos++;
        }
        if (curr == null && currentPos < pos) return head;
        if (prev == null) {
            return new LLNode(val, curr);
        } else {
            prev.next = new LLNode(val, curr);
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] inputLL = {{10, 30, 50, 70}, {5, 15, 25, 35}, {10, 20}};
        int[] inputPos = {2, 5, 4};
        int[] inputVal = {20, 10, 5};
        for (int i = 0; i < inputLL.length; i++) {
            LLNode head = CustomUtil.createLinkedList(inputLL[i]);
            LLNode newHead = insertBeginning(head, inputPos[i], inputVal[i]);
            CustomUtil.printLinkedList(newHead);
        }
    }
}
