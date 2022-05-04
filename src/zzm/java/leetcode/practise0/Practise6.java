package zzm.java.leetcode.practise0;

import java.util.Arrays;

/**
 *
 */
public class Practise6 {
    public static  void main(String []args){
        Practise6 practise6 = new Practise6();
        System.out.println(practise6.convert("PAYPALISHIRING",1));

    }

    public String convert(String s, int numRows) {
        char result[][] = new char[numRows][s.length()];
        //Arrays.fill(result,);
        if(numRows == 1){
            return s;
        }
        int x = 0;
        int y = 0;
        boolean isDown = true;
        for(int i = 0;i<s.length();i++){
            result[y][x] = s.charAt(i);
            if(isDown){
                y++;
                if(y == numRows){
                    isDown  = false;
                    x++;
                    y = y - 2;
                }
            }else{
                y--;
                if(y == -1){
                    isDown = true;
                    x++;
                    y = y + 2;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[i].length;j++){
                if(result[i][j] != '\u0000')
                stringBuilder.append(result[i][j]);
            }
        }

        return stringBuilder.toString();
    }
}
