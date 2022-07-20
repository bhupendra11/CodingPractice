package com.codingpractice.heapsAndMaps;

import java.util.*;

/**
 * Problem Statement#
 * Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.
 *
 * Example 1:
 *
 * Input: "aappp"
 * Output: "papap"
 * Explanation: In "papap", none of the repeating characters come next to each other.
 * Example 2:
 *
 * Input: "Programming"
 * Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.
 * Explanation: None of the repeating characters come next to each other.
 * Example 3:
 *
 * Input: "aapa"
 * Output: ""
 * Explanation: In all arrangements of "aapa", atleast two 'a' will come together e.g., "apaa", "paaa".
 */
public class RearrangeString {
    public static String rearrangeString(String str) {
        // TODO: Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((x,y)-> y.count-x.count);
        for(char key : map.keySet()){
            pq.add(new Node(key,map.get(key)));
        }

        List<Node> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            list.add(pq.remove());
        }

        //System.out.println("list size= "+list.size());
        int i=0;
        while(i<list.size()){
            Node node = list.get(i);
         //   System.out.println("i= "+i+" c= "+node.c+" count = "+node.count);
            if(node.count==0){
                //System.out.println("breaking 1");
                break;
            }
            char c = node.c;
            if(sb.length()>0 && sb.charAt(sb.length()-1)==c){
                //System.out.println("breaking 2");
                break;
            }
            sb.append(c);
            node.count = node.count -1;
            list.set(i,node);
            i++;
            if(i>=list.size()){
                i=0;
            }
        }

        if(sb.length()==str.length())return sb.toString();
        return "";
    }

    private static  class  Node{
        char c;
        int count;

        Node(char c, int count){
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
