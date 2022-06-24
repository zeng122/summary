package zzm.java.leetcode.practise0;

public class Practise48 {

    public static void main(String[] args) {
        int[][] matrix = {
                {2,29,20,26,16,28},
                {12,27,9,25,13,21},
                {32,33,32,2,28,14},
                {13,14,32,27,22,26},
                {33,1,20,7,21,7},
                {4,24,1,6,32,34}};
        Practise48 practise48 = new Practise48();
        practise48.rotate(matrix);
    }

    //层次旋转
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int left = 0;
        int right = length-1;
        while (left<right){
            for(int i = 0;i<(right-left);i++){
                int temp = matrix[left][left+i];
                matrix[left][left+i] = matrix[right-i][left];
                matrix[right-i][left] = matrix[right][right-i];
                matrix[right][right-i] = matrix[left+i][right];
                matrix[left+i][right] = temp;
            }
            left++;
            right--;
        }


    }
}
