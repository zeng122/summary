package zzm.java.leetcode.practise100;

/**
 *
 */
public class Practise112 {
    Boolean result = false;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String [] args){
        Practise112 practise112 = new Practise112();
        TreeNode root = practise112.init();
        System.out.println(practise112.hasPathSum(root,22));
    }

    public TreeNode init(){
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(4,null,treeNode9);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode4 = new TreeNode(11,treeNode7,treeNode8);
        TreeNode treeNode3 = new TreeNode(8,treeNode5,treeNode6);
        TreeNode treeNode2 = new TreeNode(4,treeNode4,null);
        TreeNode treeNode1 = new TreeNode(5,treeNode2,treeNode3);
        return treeNode1;

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        isRightNode(root,targetSum,0);
        return result;
    }

    public void isRightNode(TreeNode root, int targetSum,int currentSum){
        if(root == null)
            return;
        if(result){
            return;
        }
        currentSum = root.val + currentSum;
        //根节点
        if(root.left == null && root.right == null){
            if(currentSum == targetSum){
                result = true;
                return;
            }
        }
        if(root.left != null){
            isRightNode(root.left,targetSum,currentSum);
        }
        if(root.right!=null){
            isRightNode(root.right,targetSum,currentSum);
        }
    }
}
