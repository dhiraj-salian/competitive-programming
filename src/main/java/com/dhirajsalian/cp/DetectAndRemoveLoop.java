package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;
import com.dhirajsalian.cp.util.LLNode;

/*
Given a linked list, check if the linked list has loop. Remove the loop.

Examples:

Input 1: 10->15->5->20->15
Output 1: 10->15->5->20

Input 2: 10->10
Output 2: 10

Input 3: 10->15->20
Output 3: 10->15->20

Source: geeksforgeeks.org
 */
public class DetectAndRemoveLoop {

    static void detectAndRemoveLoop(LLNode head) {
        if (head == null) return;
        LLNode slow = head, fast = head;
        boolean loopDetected = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopDetected = true;
                break;
            }
        }
        if (loopDetected) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public static void main(String[] args) {
        LLNode[] heads = {input1(), input2(), input3()};
        for (LLNode head : heads) {
            detectAndRemoveLoop(head);
            CustomUtil.printLinkedList(head);
        }
    }

    static LLNode input1() {
        LLNode head = new LLNode(10);
        LLNode temp1 = new LLNode(15);
        LLNode temp2 = new LLNode(5);
        LLNode temp3 = new LLNode(20);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp1;
        return head;
    }

    static LLNode input2() {
        LLNode head = new LLNode(10);
        head.next = head;
        return head;
    }

    static LLNode input3() {
        return CustomUtil.createLinkedList(new int[]{10, 15, 20});
    }

}
