package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Segregate even value nodes and odd value nodes, such that all even value nodes occur before
odd value nodes. Also, the relative ordering of even/odd valued nodes must remain same.

Examples:

Input 1: 17->15->8->12->10->5->4->NULL
Output 1: 8->12->10->4->17->15->5->NULL

Input 2: 8->12->10->NULL
Output 2: 8->12->10->NULL

Input 3: 1->3->5->NULL
Output 3: 1->3->5->NULL

Source: geeksforgeeks.org
 */
public class SegregateEvenOddLL {

    static LLNode segregateEvenOdd(LLNode head) {
        LLNode evenHead = null, oddHead = null, evenTail = null, oddTail = null;
        LLNode curr = head;
        while (curr != null) {
            if (curr.value % 2 == 0) {
                if (evenHead == null) {
                    evenHead = curr;
                } else {
                    evenTail.next = curr;
                }
                evenTail = curr;
            } else {
                if (oddHead == null) {
                    oddHead = curr;
                } else {
                    oddTail.next = curr;
                }
                oddTail = curr;
            }
            curr = curr.next;
        }
        if (evenTail != null) evenTail.next = oddHead;
        if (oddTail != null) oddTail.next = null;
        if (evenHead == null) return oddHead;
        return evenHead;
    }

    public static void main(String[] args) {
        int[][] inputs = {{17, 15, 8, 12, 10, 5, 4}, {8, 12, 10}, {1, 3, 5}};
        for (int[] input : inputs) {
            LLNode head = CustomUtil.createLinkedList(input);
            CustomUtil.printLinkedList(segregateEvenOdd(head));
        }
    }
}
