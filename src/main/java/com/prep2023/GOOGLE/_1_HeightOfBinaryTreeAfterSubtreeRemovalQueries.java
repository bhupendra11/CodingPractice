package com.prep2023.GOOGLE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// Gives TLE for very large inputs like 3/40 only
public class _1_HeightOfBinaryTreeAfterSubtreeRemovalQueries {
    static  Map<Integer,TreeNode> parentMap;
    static Map<Integer,TreeNode> nodeMap;
    static  Map<TreeNode, Integer> heightMap;
    public static int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];

        parentMap = new HashMap<>();
        nodeMap = new HashMap<>();
        heightMap = new HashMap<>();

        //build parent map
        buildParentMap(root,null);
        //calcualte height of all nodes and store
        height(root);

        for(int i=0;i<n ;i++){
            int query = queries[i];
            TreeNode parent = parentMap.get(query);
            //TreeNode node = nodeMap.get(query);

            boolean leftChild = false;
            if(parent.left != null && query == parent.left.val){
                leftChild = true;
            }
            // else right child
            TreeNode curNode = parent;

            if(leftChild){
                heightMap.put(parent, 1+getHeight(parent.right));
            }
            else{
                heightMap.put(parent, 1+getHeight(parent.left));
            }
            curNode = parentMap.get(curNode.val);
            while(curNode != null){
                //reached root
                int height =1+ Math.max(getHeight(curNode.left),getHeight(curNode.right));
                heightMap.put(curNode, height);
                curNode = parentMap.get(curNode.val);
            }

            res[i] = getHeight(root);

            //restore tree
            curNode = parent;
            while(curNode != null ){

                int height =1+ Math.max(getHeight(curNode.left),getHeight(curNode.right));
                heightMap.put(curNode, height);
                curNode = parentMap.get(curNode.val);

            }
        }
        return res;
    }
    private static int getHeight(TreeNode node){
        if(node == null)return -1;
        return heightMap.get(node);
    }

    private static void buildParentMap(TreeNode root , TreeNode parent){
        if(root == null)return ;

        nodeMap.put(root.val, root);
        parentMap.put(root.val, parent);

        if(root.left != null)
            buildParentMap(root.left, root);
        if(root.right != null)
            buildParentMap(root.right, root);
    }

    private static  int height(TreeNode root){
        if(root == null)return -1;
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int curHeight = 1 + Math.max(lHeight, rHeight);
        heightMap.put(root, curHeight);
        return curHeight;
    }

    public static void main(String[] args) {
       /* TreeNode root = new TreeNode(5,
                new TreeNode(8,
                        new TreeNode(2, new TreeNode(4), new TreeNode(6))
                        , new TreeNode(1)),
                new TreeNode(9, new TreeNode(3), new TreeNode(7))
        );

        int queries[] ={3,2,3,2};*/

        TreeNode root = new TreeNode(1, null, new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),null));
        int queries[] = {3,5,4,2,4};
        int output[] = treeQueries(root, queries);
        System.out.println(Arrays.toString(Arrays.stream(output).toArray()));
    }



    //Brute force SOlution -> GIVES TLE for large inputs
    /*
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for(int i=0 ;i < n ;i++){
            res[i] = height(root,queries[i]);
        }
        return res;
    }

    private int height(TreeNode root, int query){
        if(root == null)return -1;

        if(root.val == query){
            return -1;
        }
        return 1 + Math.max(height(root.left,query), height(root.right,query));
    }
    */
}
