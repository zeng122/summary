package zzm.java.leetcode.practise100;

import java.util.Arrays;

public class Practise105 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public static void main(String[] args) {
        int[] preorder = {2,1};
        int[] inorder = {1,2};
        new Practise105().buildTree(preorder,inorder);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root  = new TreeNode();
        root.val = preorder[0];
        if(preorder.length == 1){
            root.left = null;
            root.right = null;
            return root;
        }
        int index = 0;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }

        int[] subLeftPreorder = Arrays.copyOfRange(preorder,1,1+index);
        int[] subLeftInorder = Arrays.copyOfRange(inorder,0,index);
        root.left = buildTree(subLeftPreorder,subLeftInorder);
        int[] subRightPreorder = Arrays.copyOfRange(preorder,1+index,preorder.length);
        int[] subRightInorder = Arrays.copyOfRange(inorder,index+1,inorder.length);
        root.right = buildTree(subRightPreorder,subRightInorder);
        return root;

    }

}
