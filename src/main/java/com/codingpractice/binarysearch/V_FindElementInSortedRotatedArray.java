package com.codingpractice.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class V_FindElementInSortedRotatedArray {

    public static void main(String[] args) {
        int arr[] = {66, 72, 79, 86, 95, 104, 106, 110, 119, 123, 124, 129, 132, 136, 137, 142, 150, 2, 12, 14, 17, 26, 30, 36, 38, 46, 52, 60};

        int ans1 = search(Arrays.stream(arr).boxed().collect(Collectors.toList()), 36);
        System.out.println(ans1);
    }

    private static int search(final List<Integer> A, int B) {

        int minIndex = findMinIndex(A);

        int binarySearch1 = binarySearch(A,0,minIndex-1,B);
        if(binarySearch1 != -1)return binarySearch1;

        int binarySearch2 = binarySearch(A,minIndex,A.size()-1,B);
        return binarySearch2;
    }

    private static int binarySearch(final List<Integer> A, int low, int high, int target){

        while(low<=high){
            int mid = low +(high-low)/2;

            if(A.get(mid)==target){return mid;}
            else if(A.get(mid) >target ){
                high =mid-1;
            }
            else{
                low =mid+1;
            }
        }
        return -1;

    }

    private static int findMinIndex(final List<Integer> A){
        int n = A.size();;
        int low =0;
        int high = n-1;
        int mid=0, prev =0, next=0;

        while(low<=high){
            mid = low +(high-low)/2;
            //check if sorted
            if(A.get(low)<=A.get(high))return low;

            prev = (n+mid-1)%n;
            next = (mid+1)%n;

            if(A.get(mid) <= A.get(prev)&& A.get(mid) <= A.get(next)){
                return mid;
            }
            if(A.get(low) <= A.get(mid)){
                low = mid+1;
            }
            else if(A.get(mid) <= A.get(high)){
                high = mid-1;
            }
        }
        return 0;
    }

}
