package com.bhupendra.prep2023.heaps;

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class MergeKsortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        for(ListNode node : lists){
            if(node != null)
                pq.add(node);
        }

        if(pq.size() ==0)return null;
        ListNode result = pq.remove();
        if(result != null && result.next != null)
            pq.add(result.next);
        ListNode head = result;

        while(!pq.isEmpty()){
            ListNode node = pq.remove();
            ListNode next = node.next;
            if(next != null){
                pq.add(next);
            }
            result.next = node;
            result = result.next;
        }
        return head;

    }

    public static void main(String[] args) {
        // Sample ListNode lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        // Merge the lists
        ListNode[] lists = {list1, list2, list3};
        ListNode mergedList = mergeKLists(lists);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
        System.out.println("null");
    }

}
