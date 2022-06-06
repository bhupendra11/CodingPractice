package com.codingpractice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfSortedArrays {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>(Arrays.asList(1,4,5));
        List<Integer> b = new ArrayList<>(Arrays.asList(2,3));
        double result = findMedianSortedArrays(a,b);
        System.out.println(result);

         a = new ArrayList<>(Arrays.asList(1,4,5));
         b = new ArrayList<>(Arrays.asList(2,3,6));
        result = findMedianSortedArrays(a,b);
        System.out.println(result);

        a = new ArrayList<>(Arrays.asList(1,4,5,8,9,13));
        b = new ArrayList<>(Arrays.asList(2,3,6,7,11,17));
        result = findMedianSortedArrays(a,b);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int n = a.size() + b.size();
        int i = 0, j = 0, k = 0;
        int first =0;
        int second =0;

        List<Integer> merged = new ArrayList<>();
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                merged.add(a.get(i));
                if(k == n/2 -1){
                    first = a.get(i);
                }
                if(k==n/2){
                    second = a.get(i);
                }
                i++;
                k++;

            } else {
                merged.add(b.get(j));
                if(k == n/2 -1){
                    first = b.get(j);
                }
                if(k==n/2){
                    second = b.get(j);
                }
                j++;
                k++;

            }
        }

        while (i < a.size()) {
            merged.add(a.get(i));
            if(k == n/2 -1){
                first = a.get(i);
            }
            if(k==n/2){
                second = a.get(i);
            }
            i++;
            k++;

        }
        while (j < b.size()) {
            merged.add(b.get(j));
            if(k == n/2 -1){
                first = b.get(j);
            }
            if(k==n/2){
                second = b.get(j);
            }
            j++;
            k++;

        }

        if (n % 2 == 0) {
            return (double) (first + second) / 2;
        } else {
            return (double) second;
        }
    }
}
