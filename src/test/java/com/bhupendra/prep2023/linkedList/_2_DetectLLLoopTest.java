package com.bhupendra.prep2023.linkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _2_DetectLLLoopTest {
    private _2_DetectLLLoop detectLLLoop;

    @Before
    public void setup() {
        detectLLLoop = new _2_DetectLLLoop();
    }

    @Test
    public void testNoCycle() {
        // Create a linked list without a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        assertFalse(detectLLLoop.hasCycle(head));
    }

    @Test
    public void testCycle() {
        // Create a linked list with a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head; // Create a cycle

        assertTrue(detectLLLoop.hasCycle(head));
    }
}
