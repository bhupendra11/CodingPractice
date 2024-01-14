package com.bhupendra.prep2023.arrays.binarySearch;

public class _6_NextAlphabeticalLetter {

    private static int findCeil(char arr[], char k){
        int low =0;
        int high = arr.length -1;
        int res =-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid] > k ) {
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }return res;
    }

    public static void main(String[] args) {
        char[] arr ={'a','c','f','h'};
        char[] arr2 ={'a','c','f','h', 'k','q'};
        System.out.println(findCeil(arr,'f'));
        System.out.println(findCeil(arr2,'g'));
        System.out.println(findCeil(arr2,'i'));
        System.out.println(findCeil(arr2,'r'));
    }
}
