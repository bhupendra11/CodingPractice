package com.bhupendra.prep2023.linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _5_SortLinkedListTest {

    @Test
    public void testSortListWithSortedInput() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        _5_SortLinkedList solution = new _5_SortLinkedList();
        ListNode result = solution.sortList(head);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(null, result.next.next.next.next);
    }

    @Test
    public void testSortListWithReverseSortedInput() {
        ListNode head = new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))));
        _5_SortLinkedList solution = new _5_SortLinkedList();
        ListNode result = solution.sortList(head);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(null, result.next.next.next.next);
    }

    @Test
    public void testSortListWithRandomOrderInput() {
        ListNode head = new ListNode(3, new ListNode(1, new ListNode(4, new ListNode(2))));
        _5_SortLinkedList solution = new _5_SortLinkedList();
        ListNode result = solution.sortList(head);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(null, result.next.next.next.next);
    }

    @Test
    public void testSortListWithSingleElement() {
        ListNode head = new ListNode(1);
        _5_SortLinkedList solution = new _5_SortLinkedList();
        ListNode result = solution.sortList(head);
        assertEquals(1, result.val);
        assertEquals(null, result.next);
    }

    @Test
    public void testSortListWithEmptyList() {
        ListNode head = null;
        _5_SortLinkedList solution = new _5_SortLinkedList();
        ListNode result = solution.sortList(head);
        assertEquals(null, result);
    }
}
