package com.codingpractice.twopointers;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 *
 * Example 1:
 *
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * Example 2:
 *
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 */
public class SortedArraySquares {
    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int i,j;
        int mid =0;
        int res[] = new int[n];


        boolean first = true;
        for(int k=0;k<n;k++){
            arr[k]*= arr[k];
            if(k >0 && arr[k] > arr[k-1] && first) {
                mid = k-1;
                first = false;
            }
        }

        int p=0;
        res[p] = arr[mid];
        p++;

        i=mid-1;
        j = mid+1;
        while(i >=0  && j <n){
            if(arr[i]<arr[j]){
                res[p] = arr[i];
                p++;
                i--;
            }
            else{
                res[p] = arr[j];
                p++;
                j++;
            }
        }
        while(i>=0){
            res[p] = arr[i];
            p++;
            i--;

        }
        while(j<n){
            res[p] = arr[j];
            p++;
            j++;
        }
        return res;
    }

}
