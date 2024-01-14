package com.bhupendra.prep2023.linkedList;

public class _5_SortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head == null)return null;

        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode mid = findMid(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left,right);
    }

    private ListNode merge(ListNode headA, ListNode headB){
        if(headA == null && headB == null){
            return null;
        }
        if(headA == null)return headB;
        if(headB == null)return headA;

        //iteratively merge
        ListNode sentinal = new ListNode(Integer.MIN_VALUE);

        ListNode cur = sentinal;
        while(headA != null && headB != null){
            if(headA.val <= headB.val){
                cur.next = headA;
                headA = headA.next;
            }
            else{
                cur.next = headB;
                headB = headB.next;
            }
            cur = cur.next;
        }

        cur.next = (headA == null) ? headB : headA;

        return sentinal.next;
    }



    private ListNode findMid(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // break the linked list
        return slow;
    }
}