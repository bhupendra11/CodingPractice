package com.bhupendra.prep2023.arrays;

import java.util.ArrayList;
import java.util.List;

public class _3_CountInversions {
    long inversions = 0;

    public long countInversions(List<Integer> arr) {
        // Write your code here
        inversions = 0;

        List<Integer> res = mergeSort(arr);
        //System.out.println("res= "+res);
        return inversions;
    }

    private List<Integer> mergeSort(List<Integer> arr) {
        int n = arr.size();
        if (n <= 1) return arr;

        int mid = n / 2;

        List<Integer> left = new ArrayList<>(arr.subList(0, mid));
        List<Integer> right = new ArrayList<>(arr.subList(mid, n));
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                inversions += left.size() - i;
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
