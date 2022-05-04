package zzm.java.leetcode.Practise900;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Practise957 {

    public static void main(String [] args){
        int [] cells = {0,1,0,1,1,0,0,1};
        System.out.println(20/7*7);
        System.out.println(new Practise957().prisonAfterNDays(cells,100000000));

    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        if(n == 0){
            return cells;
        }
        HashSet hashSet = new HashSet<String>();

        for(int i = 0 ; i < n;i++){
            int [] cells2 = new int[cells.length];
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<cells.length;j++){
                if(j == 0 || j == cells.length-1){
                    cells2[j] = 0;
                }else{
                    if(cells[j-1] == cells[j+1]){
                        cells2[j] = 1;
                    }else{
                        cells2[j] = 0;
                    }

                }
                sb.append(cells2[j]);
            }
            //hashSet判断快
            if(hashSet.contains(sb.toString())){
                //快进到最后一个循环
                i = (n- 1 - i) / hashSet.size() * hashSet.size() + i;
                hashSet.clear();
            }
            hashSet.add(sb.toString());
            cells = cells2;
        }

        return cells;

    }

}
