package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a linked list and a reference to any node. Remove the given node.
Note: The given reference won't be a last node.

Examples:

Input 1: 10->20->30->40->25->NULL, curr = 30
Output 1: 10->20->40->25->NULL

Source: geeksforgeeks.org
 */
public class DeleteNodeWithOnlyPointerGiven {

    static void deleteNode(LLNode curr) {
        if (curr == null || curr.next == null) return; // Not a valid input
        curr.value = curr.next.value;
        curr.next = curr.next.next;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 30, 40, 25}};
        int[] nodePosition = {3};
        for (int i = 0; i < nodePosition.length; i++) {
            LLNode head = CustomUtil.createLinkedList(inputs[i]);
            LLNode curr = head;
            while (nodePosition[i] > 1) {
                curr = curr.next;
                nodePosition[i]--;
            }
            System.out.print("Linked List: ");
            CustomUtil.printLinkedList(head);
            System.out.println("Input: " + curr);
            deleteNode(curr);
            CustomUtil.printLinkedList(head);
        }
    }
}
