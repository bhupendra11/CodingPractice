package com.codingpractice.binarysearch;

import java.util.ArrayList;
import java.lang.Integer;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Tut : https://www.youtube.com/watch?v=VS0BcOiKaGI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=20
 * Problem : https://www.interviewbit.com/problems/matrix-search/
 *
 * Given a matrix of integers A of size N x M and an integer B.
 *
 * Write an efficient algorithm that searches for integar B in matrix A.
 *
 * This matrix A has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Return 1 if B is present in A, else return 0.
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer matrix A.
 * The second argument given is the integer B.
 * Output Format
 *
 * Return 1 if B is present in A, else return 0.
 * Constraints
 *
 * 1 <= N, M <= 1000
 * 1 <= A[i][j], B <= 10^6
 * For Example
 *
 * Input 1:
 *     A =
 *     [ [1,   3,  5,  7],
 *       [10, 11, 16, 20],
 *       [23, 30, 34, 50]  ]
 *     B = 3
 * Output 1:
 *     1
 *
 * Input 2:
 *     A = [   [5, 17, 100, 111]
 *             [119, 120,  127,   131]    ]
 *     B = 3
 * Output 2:
 *     0
 */

public class XIII_SearchInRowWiseColumnWiseSortedMatrix {

    private static ArrayList<ArrayList<Integer>> twoDArrayToListMatrix(int[][] twoDArray) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] array : twoDArray) {

            list.addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));
            res.add(list);
            list = new ArrayList<>();
        }
        return res;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>  mat1 = twoDArrayToListMatrix(new int[][]{{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}});


        ArrayList<ArrayList<Integer>>  mat2  = twoDArrayToListMatrix(new int[][]{{5, 17, 100, 111},
                {119, 120, 127, 131}});

        System.out.println(searchMatrix(mat1,3));
        System.out.println(searchMatrix(mat2,3));
    }
    //return 1 if element is found else return 0;

    private static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {

        int row = findRow(A,B);
        if(row==-1)return 0;
        int col = findCol(A,B,row);
        // System.out.println("row =" +row + "col = "+col);
        return col>-1 ? 1: 0;


    }

    private static int findRow(ArrayList<ArrayList<Integer>> A, int target){
        int m = A.size(); //rows
        int n = A.get(0).size(); //cols

        int low =0;
        int high = m-1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(target >= A.get(mid).get(0) && target <= A.get(mid).get(n-1)){
                return mid;
            }
            else if(target > A.get(mid).get(n-1)){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

    private static int findCol(ArrayList<ArrayList<Integer>> A, int target, int row){
        int m = A.size(); //rows
        int n = A.get(0).size(); //cols

        int low =0;
        int high = n-1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(target == A.get(row).get(mid)){
                return mid;
            }
            else if(target > A.get(row).get(mid)){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;

    }
}
