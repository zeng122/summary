package zzm.java.leetcode.Practise800;

public class Practise845 {
    public static void main(String[] args) {
        Practise845 practise845 = new Practise845();
        int[] arr = {2,2,2};
        System.out.println(practise845.longestMountain(arr));
    }



    public int longestMountain(int[] arr) {
        int begin = 0;
        int end = 0;
        int result = 0;
        while (end < arr.length-1){
            //过滤掉相等的
            while (end<arr.length-1 && arr[end] == arr[end+1]){
                end++;
                begin++;
            }
            //升
            boolean up = false;
            boolean down = false;

            while (end<arr.length-1 && arr[end]<arr[end+1]){
                up = true;
                end++;
            }

            //降
            while (end<arr.length-1 && arr[end]>arr[end+1]){
                down = true;
                end++;
            }

            if(up && down){
                int width = end - begin+1;
                if(width > result) result = width;
            }

            begin = end;
        }
        return result;
    }
}
