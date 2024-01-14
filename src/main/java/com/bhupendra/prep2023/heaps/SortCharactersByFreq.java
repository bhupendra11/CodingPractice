package com.bhupendra.prep2023.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Author: Bhupendra Shekhawat
 * Date: 24/11/23
 * Topic: com.prep2023.heaps
 * Question : <a href="https://leetcode.com/problems/sort-characters-by-frequency/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class SortCharactersByFreq {

    //Approach 3 Heap
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);

        for(char c : freqMap.keySet()){
            pq.add(new Pair(c, freqMap.get(c)));
        }

        char arr[] = new char[s.length()];
        int i=0;
        while(!pq.isEmpty()){
            Pair pair  = pq.remove();
            char c = pair.c;
            int freq = pair.freq;
            for(int j=0;j<freq;j++){
                arr[i] = c;
                i++;
            }
        }

        return new String(arr);
    }

    class Pair{
        char c;
        int freq;
        Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }


    /*
    // Approach 2 Bucket Sort O(n) solution
     public String frequencySort(String s) {
         if (s == null || s.isEmpty()) return s;
         //lets make buckets based on the frequency count
         // so every character with same frequncy will land in same bucket

        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
            maxFrequency = Math.max(maxFrequency, map.get(c));
        }

        //just need to create buckets till max frequency
        List<List<Character>> buckets = new ArrayList<>();
        for(int i=0;i<=maxFrequency ;i++){
            buckets.add(new ArrayList<>());
        }

        //fill buckets
        for(char c: map.keySet()){
            int freq = map.get(c);
            buckets.get(freq).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=maxFrequency ;i>=0 ;i--){
            for(char c :  buckets.get(i)){
                for(int j=0; j<i; j++)
                    sb.append(c);
            }
        }
        return sb.toString();

     }


    */
    /*
    O(nlogn)
    Approach 1 : Lets store frequency data with Hashmap
    and finally sort based on frequency
    */
    // public String frequencySort(String s) {

    //     Map<Character, Integer> map = new HashMap<>();

    //     for(char c : s.toCharArray()){
    //         map.put(c, map.getOrDefault(c,0)+1);
    //     }

    //     List<Character> list = new ArrayList<>(map.keySet());
    //     Collections.sort(list, (x,y) -> map.get(y)- map.get(x));  //O(nlogn)

    //     StringBuilder sb = new StringBuilder();
    //     for(char c: list){
    //         int count = map.get(c);

    //         for(int i=0;i<count;i++){
    //             sb.append(String.valueOf(c));
    //         }
    //     }
    //     return sb.toString();
    // }



}
