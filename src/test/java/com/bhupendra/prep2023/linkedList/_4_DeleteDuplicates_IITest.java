package com.bhupendra.prep2023.linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _4_DeleteDuplicates_IITest {

    @Test
    public void testDeleteDuplicatesWithNoDuplicates() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        _4_DeleteDuplicates_II solution = new _4_DeleteDuplicates_II();
        ListNode result = solution.deleteDuplicates(head);
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(null, result.next.next.next);
    }

    @Test
    public void testDeleteDuplicatesWithDuplicates() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3)))));
        _4_DeleteDuplicates_II solution = new _4_DeleteDuplicates_II();
        ListNode result = solution.deleteDuplicates(head);
        assertEquals(1, result.val);
        assertEquals(null, result.next);

    }

    @Test
    public void testDeleteDuplicatesWithAllDuplicates() {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));
        _4_DeleteDuplicates_II solution = new _4_DeleteDuplicates_II();
        ListNode result = solution.deleteDuplicates(head);
        assertEquals(null, result);
    }

    @Test
    public void testDeleteDuplicatesWithEmptyList() {
        ListNode head = null;
        _4_DeleteDuplicates_II solution = new _4_DeleteDuplicates_II();
        ListNode result = solution.deleteDuplicates(head);
        assertEquals(null, result);
    }
}
