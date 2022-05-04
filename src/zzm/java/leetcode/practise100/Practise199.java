package zzm.java.leetcode.practise100;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Practise199 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
          return result;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            result.add(list.get(list.size()-1).val);
            for(TreeNode treeNode : list){
                if(treeNode.left!=null){
                    next.add(treeNode.left);
                }

                if(treeNode.right!=null){
                    next.add(treeNode.right);
                }
                list = new ArrayList<>();
                list.addAll(next);
            }
        }
        return result;
    }

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
}
