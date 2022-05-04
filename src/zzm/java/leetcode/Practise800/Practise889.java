package zzm.java.leetcode.Practise800;

import java.util.Arrays;
import java.util.HashMap;

public class Practise889 {
    class TreeNode {
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
        Practise889 practise889 = new Practise889();
        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        practise889.constructFromPrePost(preorder,postorder);
    }

    HashMap<Integer,Boolean> hashMap = new HashMap<>();


    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int N = preorder.length;
        if (N == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (N == 1) return root;

        int L = 0;
        for (int i = 0; i < N; ++i)
            if (postorder[i] == preorder[1])
                L = i+1;

        root.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, L+1),
                Arrays.copyOfRange(postorder, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(preorder, L+1, N),
                Arrays.copyOfRange(postorder, L, N-1));
        return root;
    }


}
