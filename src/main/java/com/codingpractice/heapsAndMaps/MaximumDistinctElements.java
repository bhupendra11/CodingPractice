package com.codingpractice.heapsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {
    public static int findMaximumDistinctElements(int[] nums, int k) {
        // TODO: Write your code here
        int count = nums.length;
        int maxPossible = count -k;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y)-> x.count-y.count);
        for(int key : map.keySet()){
            pq.add(new Node(key, map.get(key)));
        }

        int max =0;
        while(k>0 && !pq.isEmpty()){
            Node node = pq.remove();
            if(node.count ==1){
                max +=1;
                continue;
            }
            else{
                if(k+1 >=node.count){
                    k-= node.count -1;
                    max+=1;
                }
                else if(k >=0){

                    break;
                }
            }
        }

        return Math.min(maxPossible,max);

    }

    private static class Node{
        int num;
        int count;

        Node(int num, int count){
            this.num = num;
            this.count =count;
        }
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
