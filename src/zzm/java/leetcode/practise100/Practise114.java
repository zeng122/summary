package zzm.java.leetcode.practise100;

public class Practise114 {
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

    public void init(){
        TreeNode treeNode1 = new TreeNode(2,null,null);
        TreeNode treeNode2 = new TreeNode(3,null,null);
        TreeNode treeNode3 = new TreeNode(1,treeNode1,treeNode2);
        flatten(treeNode3);
    }
    public static void main(String[] args) {
        Practise114 practise114 = new Practise114();
        practise114.init();
    }

    TreeNode nextNode = new TreeNode();
    public void flatten(TreeNode root) {
      TreeNode newRoot = nextNode;
      firstList(root);
      root = newRoot;
      System.out.println("!111");
    }

    public void firstList(TreeNode root){
        if(root == null){
            return ;
        }
        nextNode.val = root.val;
        nextNode.left = null;
        nextNode.right = new TreeNode();
        nextNode = nextNode.right;
        firstList(root.left);
        firstList(root.right);
    }

}
