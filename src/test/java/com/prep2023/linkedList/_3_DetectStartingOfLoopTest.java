package com.prep2023.linkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _3_DetectStartingOfLoopTest {
    private _3_DetectStartingOfLoop detectCycle;

    @Before
    public void setup() {
        detectCycle = new _3_DetectStartingOfLoop();
    }

    @Test
    public void testNoCycle() {
        // Create a linked list without a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        assertNull(detectCycle.detectCycle(head));
    }

    @Test
    public void testCycle() {
        // Create a linked list with a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; // Create a cycle

        ListNode result = detectCycle.detectCycle(head);

        assertNotNull(result);
        assertEquals(2, result.val);
    }
}
