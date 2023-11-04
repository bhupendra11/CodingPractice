package com.prep2023.linkedList;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _1_ReverseLinkedListTest {

    _1_ReverseLinkedList reverseLinkedList = new _1_ReverseLinkedList();
    @Test
    public void testReverseListRecursive() {
        // Test case 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int[] result1 = convertListNodeToArray(reverseLinkedList.reverseListRecursive(head1));
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, result1);

        // Test case 2: null (empty list)
        ListNode head2 = null;
        int[] result2 = convertListNodeToArray(reverseLinkedList.reverseListRecursive(head2));
        assertArrayEquals(new int[]{}, result2);
    }

    @Test
    public void testReverseListIterative() {
        // Test case 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int[] result1 = convertListNodeToArray(reverseLinkedList.reverseListIterative(head1));
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, result1);

        // Test case 2: null (empty list)
        ListNode head2 = null;
        int[] result2 = convertListNodeToArray(reverseLinkedList.reverseListIterative(head2));
        assertArrayEquals(new int[]{}, result2);
    }

    // Utility method to convert ListNode to an array for testing
    private int[] convertListNodeToArray(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int[] result = new int[length];
        current = head;
        int index = 0;
        while (current != null) {
            result[index++] = current.val;
            current = current.next;
        }

        return result;
    }

}