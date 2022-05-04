package zzm.java.leetcode.practise100;

/*
// Definition for a Node.

*/

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 */
public class Practise117 {
    public static void main(String []args){
        Practise117 practise117 = new Practise117();
        practise117.init();
    }

    void init(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = node7;
        fun3(node1);
    }



    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if(root == null)
            return root;
        List<Node> listUp = new ArrayList<>();
        List<Node> listDown = new ArrayList<>();
        listUp.add(root);
        while(listUp.size()!=0){
            for(int i = 0; i< listUp.size();i++){
                //最好一个节点不赋值，为null
                if(i != listUp.size()-1){
                    listUp.get(i).next = listUp.get(i+1);
                }
                if(listUp.get(i).left != null){
                    listDown.add(listUp.get(i).left);
                }
                if(listUp.get(i).right != null){
                    listDown.add(listUp.get(i).right);
                }
            }
            // 调整
            listUp = listDown;
            listDown = new ArrayList<>();
        }
        return root;
    }


    // 先序遍历
    void fun(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        fun(node.left);
        fun(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    void fun2(Node node){
        if(node == null){
            return;
        }
        fun2(node.left);
        System.out.println(node.val);
        fun2(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    void fun3(Node node){
        if(node == null){
            return;
        }
        fun3(node.left);
        fun3(node.right);
        System.out.println(node.val);
    }

    /**
     * 后序遍历
     * @param node
     */
    void fun4(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        fun4(node.left);
        fun4(node.right);

    }


}
