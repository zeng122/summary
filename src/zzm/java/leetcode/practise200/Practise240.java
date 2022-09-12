package zzm.java.leetcode.practise200;

public class Practise240 {
    public static void main(String[] args) {

        int [][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},{18,21,23,26,30}
        };
        new Practise240().searchMatrix(matrix,5);
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int x = matrix[0].length-1;
        int y = 0;
        while (x>=0 && y<matrix.length){
            if(matrix[y][x] == target){
                return true;
            }else if(matrix[y][x]>target){
                x--;
            }else{
                y++;
            }
        }
        return false;
    }
}
