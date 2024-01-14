package com.bhupendra.prep2023.sorting;

import java.util.*;

/**
 * Author: Bhupendra Shekhawat
 * Date: 10/11/23
 * Topic: com.prep2023.map
 * Question : <a href="https://leetcode.com/problems/sort-characters-by-frequency/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _8_Bucket_Sort_use_SortCharacterByFrequency {

    //Approach 2:  Bucket Sort O(n) solution
    public String frequencySort_UsingBucketSort(String s) {

        if (s == null || s.isEmpty()) return s;
        //lets make buckets based on the frequency count
        // so every character with same frequncy will land in same bucket

        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));
        }

        //just need to create buckets till max frequency
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxFrequency; i++) {
            buckets.add(new ArrayList<>());
        }

        //fill buckets
        for (char c : map.keySet()) {
            int freq = map.get(c);
            buckets.get(freq).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxFrequency; i >= 0; i--) {
            for (char c : buckets.get(i)) {
                for (int j = 0; j < i; j++)
                    sb.append(c);
            }
        }
        return sb.toString();

    }

    /*
    Approach 1 : Using counting characters frequency and map
    This approach requires sorting or use of a heap, both can lead to
    O(nlogn) - which should be fine for interviews, but it can be one even better with
    bucketSort in O(n)
     */
    public String frequencySortUsingMap(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (x, y) -> map.get(y) - map.get(x));  //O(nlogn)

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            int count = map.get(c);

            for (int i = 0; i < count; i++) {
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}