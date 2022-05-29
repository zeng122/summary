package zzm.java.leetcode.practise1900;

public class Practise1975 {
    public static void main(String[] args) {

    }

    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        boolean haveZero = false;
        long time = 0;
        long min = Integer.MAX_VALUE;
        for(int i = 0 ;i< matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                if(matrix[i][j] < 0){
                    time++;
                }else if(matrix[i][j] == 0){
                    haveZero = true;
                }
                if(Math.abs(matrix[i][j])<min){
                    min = Math.abs(matrix[i][j]);
                }
                sum = sum + Math.abs(matrix[i][j]);
            }
        }

        if(haveZero){
            return sum;
        }else{
            if(time % 2 == 0){
                return sum;
            }else{
                return sum - 2*min;
            }
        }
    }
}
