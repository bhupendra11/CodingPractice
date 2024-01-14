package com.bhupendra.prep2023.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int k = p.length();
        int n = s.length();

        if(k >n)return result;
        for(char c : p.toCharArray()){
            pMap.put(c, pMap.getOrDefault(c,0)+1);
        }

        //calculate the frequncies for first subtring from 0-k
        for(int i=0; i<k; i++){
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c,0)+1);
        }

        if(sMap.equals(pMap)){
            result.add(0);
        }

        for(int i=k;i<n;i++){
            if(i < n){
                //add cur character to window
                char charToAdd = s.charAt(i);
                sMap.put(charToAdd, sMap.getOrDefault(charToAdd,0)+1);

                //remove last character which moved out of window
                char charToRemove = s.charAt(i-k);
                sMap.put(charToRemove, sMap.get(charToRemove) -1);
                if(sMap.get(charToRemove) ==0){
                    sMap.remove(charToRemove);
                }

                //check Match
                if(sMap.equals(pMap)){
                    result.add(i-k+1);
                }
            }
        }
        return result;
    }
}

