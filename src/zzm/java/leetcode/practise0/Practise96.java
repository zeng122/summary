package zzm.java.leetcode.practise0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的
 * 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * 输入：n = 3
 * 输出：5
 */

public class Practise96 {


    /**
     * 求左右两个分支的
     * @param args
     */
    public static void main(String [] args){
        Practise96 practise96 = new Practise96();
        System.out.println(practise96.numTrees(4));

    }

    public Map<Integer,Integer> map  = new HashMap<>();


    /**
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        //2个节点 2个树
        map.put(0,1);
        map.put(1,1);
        for(int i = 2;i<= n;i++){
            map.put(i,getNodes(i));
        }
        return map.get(n);
    }



    public int  getNodes(int m){
        int sum = 0;
        for(int i = 0 ;i< m ;i++){
            sum = sum + map.get(i) * map.get(m-i-1);
        }
        return sum;
    }



}
