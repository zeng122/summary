package zzm.java.leetcode.practise1200;

/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，
 * 请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class Practise1277 {

    public static void main(String []args){
        Practise1277 practise1277 = new Practise1277();
        int [][] matrix = {{1,1,0,0,1},{1,0,1,1,1},{1,1,1,1,1},{1,0,1,0,1},{0,0,1,0,1}};
        System.out.println(practise1277.countSquares(matrix));
    }

    public int countSquares(int[][] matrix) {
        int[][] values = new int[matrix.length][matrix[0].length];
        for(int i = 0 ;i< matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(i == 0 || j == 0){
                    if(matrix[i][j] == 1){
                        values[i][j] = 1;
                    }else{
                        values[i][j] = 0;
                    }
                }else{
                    if(matrix[i][j] == 0){
                        values[i][j] = 0;
                        continue;
                    }
                    for(int k = 0;k<=values[i-1][j-1];k++){
                        if(matrix[i-k][j] == 1 && matrix[i][j-k] == 1){
                            values[i][j]++;
                        }else {
                            break;
                        }
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0 ;i< values.length;i++){
            for(int j = 0;j<values[i].length;j++){
                result = result + values[i][j];
            }
        }
        return result;
    }


}
