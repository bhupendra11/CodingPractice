package com.bhupendra.prep2023.linkedList;

/**
 * Problem: "Josephus Circle Elimination"
 *
 * You are given a circle of n people, numbered from 1 to n. Starting from person 1, you count k people and eliminate the k-th person. The counting continues with the next person, and you repeat the process until only one person remains. Return the position (number) of the last person standing.
 *
 * Write a function:
 *
 * java

 * public int findLastPerson(int n, int k);
 * Input:
 *
 * n: The number of people in the circle (1 <= n <= 1000).
 * k: The counting interval for elimination (1 <= k <= 100).
 * Output:
 *
 * The position (number) of the last person standing.
 * Example:
 *

 * Input: n = 7, k = 3
 * Output: 4
 *
 * Explanation: In a circle of 7 people, you eliminate the 3rd person in each turn. The elimination order is 3, 6, 2, 7, 5, 1, and the last person standing is at position 4.
 * This problem is based on the same concept as the Josephus problem, and you can implement a solution using various approaches, including recursion, dynamic programming, or a mathematical formula.
 */
public class _6_Josephus_Circle_Elimination {

    public static int findLastPerson(int n, int k){
        //Lets use circular linked list
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i=2 ;i<= n;i++){
            ListNode next = new ListNode(i);
            head.next = next;
            head = head.next;
        }
        head.next = cur;  // make it circular

        //now lets keep eliminating kth person

        // 1->2->3->4->5->6->7
        // c                  p

        ListNode prev = head;  // starting prev = lastnode

        while(cur != cur.next){
            //2 nodes remaining
            for(int i =1;i <k;i++){
                prev = cur;
                cur = cur.next;
            }
            if(cur.next == prev){
                //reached 2 nodes , so eliminate next node
                // by making next node itself
                cur = cur.next;
                cur.next = cur;
            }
            else{
                cur = cur.next;
                prev.next = cur;
            }

        }
        return cur.val;
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int lastPerson = findLastPerson(n, k);
        System.out.println("The last person standing is at position: " + lastPerson);
    }

}
