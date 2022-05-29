package zzm.java.leetcode.practise100;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Practise146 {
    HashMap<Integer,Node> hashMap = new HashMap<>();
    int capacity = 0;
    int size = 0;
    Node first = new Node();
    Node end = new Node();
    class Node{
        public int key;
        public int value;
        public Node after;
        public Node before;

        Node(){}

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Practise146 practise146 = new Practise146(2);
        practise146.put(2,1);
        practise146.put(2,2);
        practise146.get(2);
        practise146.put(1,1);
        System.out.println("1111");
    }

    public Practise146(int capacity) {
       this.capacity = capacity;
       first.after = end;
       end.before = first;
    }

    public int get(int key) {
       Node node = hashMap.get(key);
       if(node == null){
           return  -1;
       }
       if(node.before != first){
           node.before.after = node.after;
           node.after.before = node.before;
           first.after.before = node;
           node.after = first.after;
           first.after = node;
           node.before = first;
       }

       return node.value;
    }

    public void put(int key, int value) {
        Node node;
        if(!hashMap.containsKey(key)){
            node = new Node(key,value);
            if(size == capacity){
                //移除节点
                hashMap.remove(end.before.key);
                end.before.before.after = end;
                end.before = end.before.before;
            }else{
                size++;
            }
            hashMap.put(key, node);
        }else{
            node = hashMap.get(key);
            node.value = value;
            node.before.after = node.after;
            node.after.before = node.before;
        }
        first.after.before = node;
        node.after = first.after;
        first.after = node;
        node.before = first;
    }

}
