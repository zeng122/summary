package zzm.java.leetcode.practise200;

public class Practise200 {

    int[][] haveUsed;
    public static void main(String[] args) {
        Practise200 practise200 = new Practise200();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };
        System.out.println(practise200.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        haveUsed = new int[grid.length][grid[0].length];
        int result = 0;
        for(int i = 0;i< grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == '1' && haveUsed[i][j] == 0){
                    findIslands(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }


    public void findIslands(char[][] grid,int x,int y){
        if(x>= grid.length || x<0){
            return;
        }
        if(y>=grid[0].length || y<0){
            return;
        }
        if(grid[x][y] == '0'){
            return;
        }
        if(haveUsed[x][y] == 1){
            return;
        }
        if(grid[x][y] == '1'){
            haveUsed[x][y] = 1;
        }
        //上
        findIslands(grid,x-1,y);
        //下
        findIslands(grid,x+1,y);
        //左
        findIslands(grid,x,y-1);
        //右
        findIslands(grid,x,y+1);
    }

}
