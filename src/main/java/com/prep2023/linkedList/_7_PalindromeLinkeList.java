package com.prep2023.linkedList;

public class _7_PalindromeLinkeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode first = head;

        ListNode second = findMiddle(head);
        second = reverseList(second);

        while (first != null && second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

