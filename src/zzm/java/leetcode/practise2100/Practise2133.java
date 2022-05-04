package zzm.java.leetcode.practise2100;

public class Practise2133 {

    public static void main(String []args){
        Practise2133 practise2133 = new Practise2133();
        int[][] matrix = {{1,2,3},{3,1,2},{2,3,1}};
        practise2133.checkValid2(matrix);
    }

    /**
     * 穷举法该怎么做
     * @param matrix
     * @return
     */
    public boolean checkValid(int[][] matrix) {

        //扫描行
        for(int i = 0;i<matrix.length;i++){
            int [] hasUsed = new int[matrix.length];
            for(int j = 0;j<matrix[i].length;j++){
                if(hasUsed[matrix[i][j]-1] == 0){
                    hasUsed[matrix[i][j]-1]++;
                }else{
                    return false;
                }
            }
        }

        //扫描列
        for(int i = 0;i<matrix.length;i++){
            int [] hasUsed = new int[matrix.length];
            for(int j = 0;j<matrix[i].length;j++){
                if(hasUsed[matrix[j][i]-1] == 0){
                    hasUsed[matrix[j][i]-1]++;
                }else{
                    return false;
                }
            }
        }

        return true;
    }



    public boolean checkValid2(int[][] matrix) {
        int [] hasUsedOnRow = new int[matrix.length];
        int [] hasUsedOnColumn = new int[matrix.length];

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                if(hasUsedOnRow[matrix[i][j]-1] != i){
                    return false;
                }
                if(hasUsedOnColumn[matrix[j][i]-1] != i){
                    return false;
                }
                hasUsedOnRow[matrix[i][j]-1]++;
                hasUsedOnColumn[matrix[j][i]-1]++;
            }
        }
        return true;
    }
}
