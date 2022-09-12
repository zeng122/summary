package zzm.java.leetcode.practise600;

public class Practise695 {

    public static void main(String[] args) {
        int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        new Practise695().maxAreaOfIsland(grid);
    }

    int[][] hasUsed;
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        hasUsed = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
               result = Math.max(result,dfs(i,j,0,grid));
            }
        }
        return result;
    }


    public int dfs(int i,int j,int area,int [][] grid){
        if(grid[i][j] == 0 || hasUsed[i][j] == 1){
            return area;
        }
        hasUsed[i][j] = 1;
        if(i>0){
            area = dfs(i-1,j,area,grid);
        }
        if(j>0){
            area = dfs(i,j-1,area,grid);
        }
        if(i<grid.length-1){
            area = dfs(i+1,j,area,grid);
        }
        if(j<grid[0].length-1){
            area = dfs(i,j+1,area,grid);
        }
        area = area + 1;
        return area;
    }
}
