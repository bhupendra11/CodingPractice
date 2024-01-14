package com.bhupendra.prep2023.arrays.binarySearch;

public class _8_IndexOfFirst1InInfiniteBinaryArray {

    //same as _7_
    /**
     *  Find high by progressively doubling high till we are not getting 1
     *
     *  while(arr[high] != 1){
     *      low = high
     *      high = high*2
     *  }
     *
     *
     *
     */

    public static void main(String[] args) {
        int arr[] = {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(findFirst1(arr)); //12
    }

    private static  int findFirst1(int arr[]){
        int low =0;
        int high =1;
        int res =-1;
        //high can't be n-1 , assume we do not know the end

        while(arr[high] != 1){
            low = high;
            high = high*2;
        }
        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid] ==1){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }
}
