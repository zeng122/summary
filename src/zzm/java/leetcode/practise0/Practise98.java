package zzm.java.leetcode.practise0;

import zzm.java.leetcode.practise100.Practise105;

public class Practise98 {
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

    public boolean isValidBST(TreeNode root) {
       return isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root,long max,long min) {
        if(root == null){
            return true;
        }
        if(root.val<=min || root.val>=max){
            return false;
        }
        if(!isValidBST(root.left,root.val,min)){
            return false;
        }
        if(!isValidBST(root.right,max,root.val)){
            return false;
        };

        return true;

    }
}
