package com.codingpractice.array;
public class KthSmallestTwo	 {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while(true) {
            while(i < hi && a[++i] < v) {
                if(i == hi)
                    break;
            }
            while(v < a[--j]) {
                if(j == lo)
                    break;
            }
            if(i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }
    
    public static int findKthSmallest(int[] a, int k) {
        return findKthSmallestHelper(a, k, 0, a.length - 1);
    }
    public static int findKthSmallestHelper(int[] a, int k, int lo, int hi) {
        if(k > 0 && k <= hi - lo + 1) {
            int pos = partition(a, lo, hi);
            if(pos - lo == k - 1) {
                return a[pos];
            }
            if(pos - lo  > k - 1) {
                return findKthSmallestHelper(a, k, lo, pos - 1);
            }
            else {
                return findKthSmallestHelper(a, k - pos + lo - 1, pos + 1, hi);
            }       
        }
        return Integer.MAX_VALUE;
    }
    
    public static void main(String[] args) {
        int[] a = {68, 60, 92, 36, 12, 61, 80, 39, 53, 39, 25, 6, 87, 65, 6, 88, 80, 6, 75, 97, 4, 76, 75, 73, 96, 73, 32, 6, 81, 50, 43, 40, 49, 3, 9, 74, 29, 15, 40 };
        int k =39;
        System.out.println(findKthSmallest(a, k));
        
    }
}