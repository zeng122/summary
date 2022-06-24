package zzm.java.leetcode.practise0;

import java.util.Arrays;

public class Practise64 {


    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1}
        };
       System.out.println(new Practise64().minPathSum(grid));
    }

    int[][] minPath;
    public int minPathSum(int[][] grid) {
        minPath = new int[grid.length][grid[0].length];
        for(int i = 0;i<minPath.length;i++){
            Arrays.fill(minPath[i],-1);
        }
        return minPathSum(grid,grid[0].length-1,grid.length-1);
    }


    public int minPathSum(int[][] grid,int x,int y){
        if(minPath[y][x] != -1 ){
            return minPath[y][x];
        }
        if(x == 0 && y == 0){
            return grid[0][0];
        }
        int minLeft = 200, minRight = 200;
        if(x!=0){
            minLeft  = minPathSum(grid,x-1,y);
        }
        if(y!=0){
            minRight = minPathSum(grid,x,y-1);
        }
        minPath[y][x] = Math.min(minLeft,minRight)+grid[y][x];
        return minPath[y][x];
    }
}
