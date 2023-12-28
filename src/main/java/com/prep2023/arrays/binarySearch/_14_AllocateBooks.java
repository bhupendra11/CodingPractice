package com.prep2023.arrays.binarySearch;

/**
 * Author: Bhupendra Shekhawat
 * Date: 28/12/23
 * Topic: com.prep2023.arrays.binarySearch
 * Question : <a href="https://www.interviewbit.com/problems/allocate-books/">Allocate Books</a>
 * YouTube : <a href="https://www.youtube.com/watch?v=2JSQIhPcHQg">Link to YouTube</a>
 *
 * Very interesting and Importatnt
 */
public class _14_AllocateBooks {

    public int books(int[] A, int B) {

        //Each student has to be allocated at least one book.
        //Allotment should be in contiguous order,

        if(A.length < B)return -1;

        int min = Integer.MAX_VALUE;
        int sum =0;

        for(int i : A){
            if(i < min) min =i;
            sum +=i;
        }

        int low = min;
        int high = sum;
        int res =-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(isValid(A,B,mid)){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return res;


    }

    private boolean isValid(int[] arr, int students, int max){
        int count = 0;

        int curStudentpages =0;
        int i=0;
        while(count < students && i< arr.length){
            if(curStudentpages + arr[i] > max){
                count++;
                curStudentpages =0;
            }
            else{
                curStudentpages += arr[i];
                i++;
            }
        }

        return i >= arr.length;
    }
}
