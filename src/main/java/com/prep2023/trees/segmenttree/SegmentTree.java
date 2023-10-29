package com.prep2023.trees.segmenttree;

public class SegmentTree {

    static int segTree[];
    public static void main(String[] args) {
        int arr[] = new int[]{1,3,2,-2,4,5};
        int n = arr.length;

        //segment tree will have max of 4n letters
        segTree = new int[4*n+1];
        //creating a 1 based index seg tree
        int stIndex = 1;   //segmentTreeIndex

        int start =0;
        int end = n-1;

        buildSegTree(stIndex, arr, start,end);

        for(int i: segTree){
            System.out.print(i+" ");
        }
        System.out.println();

        //query
        System.out.println(query(2,4,stIndex,start,end)); //
        System.out.println(query(1,4,stIndex,start,end));
        System.out.println(query(3,3,stIndex,start,end));

        //update
        updateNode(stIndex,start,end,2,100);
        for(int i: segTree){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(query(2,4,stIndex,start,end)); //
        System.out.println(query(1,4,stIndex,start,end));

    }

    private static void buildSegTree(int stIndex,int arr[], int start, int end) {
        if(start > end)return;
        if(start == end){ //LeafNode
            segTree[stIndex] = arr[start];
            return;
        }

        int mid = start + (end-start)/2;

        buildSegTree(2*stIndex, arr, start, mid);
        buildSegTree(2*stIndex+1,arr,mid+1,end);

        segTree[stIndex] = segTree[2*stIndex] + segTree[2*stIndex+1];
    }

    /**
     *
     * @param qs query start
     * @param qe query end
     * @param stIndex segmentTree Index
     * @param start
     * @param end
     * @return
     */
    private static int query(int qs, int qe, int stIndex, int start, int end){
        if(qs > end || qe < start) //No overlap
            return 0;

        if(start >= qs &&  end <= qe ){ //Total overlap
            return segTree[stIndex];
        }

        //Partial Overlap
        int mid = start + (end-start)/2;
        int lsum = query(qs,qe,2*stIndex,start,mid);
        int rsum = query(qs,qe, 2*stIndex+1, mid+1, end);
        return lsum+rsum;
    }


    private static void updateNode(int stIndex, int start, int end, int pos, int newValue) {
        if(start > pos || end < pos)return;
        if(start == end){ //Total overlap
            segTree[stIndex] = newValue;
            return;
        }

        int mid = start + (end-start)/2;

        updateNode(2*stIndex, start,mid, pos, newValue);
        updateNode(2*stIndex+1,  mid+1,end, pos, newValue);

        segTree[stIndex] = segTree[2*stIndex] + segTree[2*stIndex+1];
    }

}
