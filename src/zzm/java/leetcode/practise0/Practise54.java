package zzm.java.leetcode.practise0;

import java.util.ArrayList;
import java.util.List;

public class Practise54 {
    int[][] haveUsed;
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        new Practise54().spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        haveUsed = new int[matrix.length+2][matrix[0].length+2];
        for(int i = 0;i<matrix.length+2;i++){
            haveUsed[i][0] = 1;
            haveUsed[i][matrix[0].length+1] =1;
        }
        for(int i = 0;i<matrix[0].length+2;i++){
            haveUsed[0][i] = 1;
            haveUsed[matrix.length+1][i] =1;
        }

        int currentState = 0;
        int x = 1 ,y = 1;
        boolean isEnd = false;
        while (!isEnd){
            result.add(matrix[x-1][y-1]);
            haveUsed[x][y] = 1;
            switch (currentState){
                //向右
                case 0:
                    if(haveUsed[x][y+1]== 0){
                        y++;
                    }else{
                        if(haveUsed[x+1][y] == 0){
                            currentState = 1;
                            x++;
                        }else{
                            isEnd = true;
                        }
                    }
                    break;
                //向下
                case 1:
                    if(haveUsed[x+1][y]== 0){
                        x++;
                    }else{
                        if(haveUsed[x][y-1] == 0){
                            currentState = 2;
                            y--;
                        }else{
                            isEnd = true;
                        }
                    }
                    break;
                //向左
                case 2:
                    if(haveUsed[x][y-1]== 0){
                        y--;
                    }else{
                        if(haveUsed[x-1][y] == 0){
                            currentState = 3;
                            x--;
                        }else{
                            isEnd = true;
                        }
                    }
                    break;
                //向上
                case 3:
                    if(haveUsed[x-1][y]== 0){
                        x--;
                    }else{
                        if(haveUsed[x][y+1] == 0){
                            currentState = 0;
                            y++;
                        }else{
                            isEnd = true;
                        }
                    }
                    break;
            }
        }
        return result;
    }
}
