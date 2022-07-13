package zzm.java.leetcode.practise200;

public class Practise221 {
    public static void main(String[] args) {


    }

    public int maximalSquare(char[][] matrix) {
        int maxLength = 0;
        int[][] maxLengths = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                int leftLength;
                if(j == 0){
                    leftLength = 0;
                }else{
                    leftLength = maxLengths[i][j-1];
                }
                int upLength;
                if(i == 0){
                    upLength = 0;
                }else{
                    upLength = maxLengths[i-1][j];
                }
                int leftUpLength ;
                if(i != 0 && j !=0 ){
                    leftUpLength = maxLengths[i-1][j-1];
                }else{
                    leftUpLength = 0;
                }
                int min = Math.min(Math.min(upLength,leftLength),leftUpLength)+1;
                maxLengths[i][j]  = min;
                if(min > maxLength){
                    maxLength = min;
                }
            }
        }
        return maxLength*maxLength;
    }
}
