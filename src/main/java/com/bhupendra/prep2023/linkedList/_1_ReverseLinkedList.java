package com.bhupendra.prep2023.linkedList;

public class _1_ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode reverseList(ListNode head) {

        //return reverseListIterative(head);
        return reverseListRecursive(head);
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode nextNode = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return nextNode;
    }

    public ListNode reverseListIterative(ListNode head) {

        //Iterative

        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}