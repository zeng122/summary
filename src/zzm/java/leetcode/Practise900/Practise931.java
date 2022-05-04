package zzm.java.leetcode.Practise900;

public class Practise931 {

    public static void main(String[] args) {
        Practise931 practise931 = new Practise931();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(practise931.minFallingPathSum(matrix));
    }

    int [][] min;
    int [][] haveFind;
    //对于一个节点
    public int minFallingPathSum(int[][] matrix) {
        min = new int[matrix.length][matrix.length];
        haveFind = new int[matrix.length][matrix.length];
        int result = Integer.MAX_VALUE;
        for(int i = 0 ;i < matrix.length;i++){
            int temp = minFallingPathSumItem(matrix,i,0);
            if(result > temp){
                result = temp;
            }
        }
        return result;
    }

    //(x,y)到最下层的最小距离
    public int minFallingPathSumItem(int[][] matrix,int x,int y) {
        if(haveFind[y][x] == 1){
            return min[y][x];
        }
        if(y == matrix.length-1){
            return matrix[y][x];
        }
        int num1 = Integer.MAX_VALUE,num2 = Integer.MAX_VALUE ,num3 = Integer.MAX_VALUE;
        if(x != 0){
            num1 = minFallingPathSumItem(matrix,x-1,y+1);
        }
        num2 = minFallingPathSumItem(matrix,x,y+1);
        if(x != matrix.length-1){
            num3 = minFallingPathSumItem(matrix,x+1,y+1);
        }
        haveFind[y][x] = 1;
        min[y][x] = Math.min(Math.min(num1,num2),num3)+matrix[y][x];
        return min[y][x];
    }

}
