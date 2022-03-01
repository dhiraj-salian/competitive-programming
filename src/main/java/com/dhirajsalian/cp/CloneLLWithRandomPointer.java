package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.LLNode;

/*
Given a LL with normal and random pointers, clone the linked list.

Examples:

Input 1: normal - 10->5->20->15->20->NULL, random - 10->20, 5->15, 20->10, 15->20, 20->15
Output 1: normal - 10->5->20->15->20->NULL, random - 10->20, 5->15, 20->10, 15->20, 20->15

Source: geeksforgeeks.org
 */
public class CloneLLWithRandomPointer {

    static LLRandomNode clone(LLRandomNode head) {
        if (head == null) return null;
        LLRandomNode curr = head;
        while (curr != null) {
            LLRandomNode temp = curr.next;
            curr.next = new LLRandomNode(curr.value);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        LLRandomNode clone = curr.next;
        while (curr != null) {
            clone.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
            if (curr != null)
                clone = curr.next;
        }
        curr = head;
        clone = curr.next;
        LLRandomNode cloneHead = clone;
        while (clone != null) {
            curr.next = clone.next;
            if (clone.next == null)
                break;
            clone.next = curr.next.next;
            curr = curr.next;
            clone = clone.next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        LLRandomNode curr = clone(input1());
        while (curr != null) {
            System.out.printf("%s->", curr.value);
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    static LLRandomNode input1() {
        LLRandomNode head = new LLRandomNode(10);
        LLRandomNode temp1 = new LLRandomNode(5);
        LLRandomNode temp2 = new LLRandomNode(20);
        LLRandomNode temp3 = new LLRandomNode(15);
        LLRandomNode temp4 = new LLRandomNode(20);
        head.next = temp1;
        head.random = temp2;
        temp1.next = temp2;
        temp1.random = temp3;
        temp2.next = temp3;
        temp2.random = head;
        temp3.next = temp4;
        temp3.random = temp2;
        temp4.random = temp3;
        return head;
    }

}

class LLRandomNode {

    int value;

    LLRandomNode next;

    LLRandomNode random;

    public LLRandomNode(int value) {
        this.value = value;
    }

    public LLRandomNode(int value, LLRandomNode next, LLRandomNode random) {
        this.value = value;
        this.next = next;
        this.random = random;
    }

}
