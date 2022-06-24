package zzm.java.leetcode.practise100;

public class Practise129 {

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
        new Practise129().init();
    }

    public void init(){

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1,treeNode2,treeNode3);
        sumNumbers(treeNode1);
    }

    int result = 0;
    public int sumNumbers(TreeNode root) {
        fun(root,0);
        return result;
    }


    public void fun(TreeNode node,int sum){
        sum = sum *10+node.val;
        //左右都为空,叶子节点
        if(node.left == null && node.right == null){
            result = sum+result;
            return;
        }
        if(node.left!=null){
            fun(node.left,sum);
        }
        if(node.right!=null){
            fun(node.right,sum);
        }
    }
}
