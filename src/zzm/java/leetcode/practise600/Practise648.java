package zzm.java.leetcode.practise600;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入: edges = [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 */

/**
 * //并查集
 */
public class Practise648 {




    public static void main(String[] args){
        int[][]  edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        Practise648 practise648 = new Practise648();
        System.out.println(practise648.findRedundantConnection(edges));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * 联通的
     * @param parent
     * @param index
     * @return
     */
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
