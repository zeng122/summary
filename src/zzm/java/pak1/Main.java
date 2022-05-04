package zzm.java.pak1;

public class Main {

    public static void main(String[] args){
        int[] num1 = {};
        System.out.println(num1.length);
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }


    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int start1 = 0;
        int start2 = 0;
        int [] allNums = new int[n1+n2];
        while(start1<n1 && start2<n2){
            if(nums1[start1] <= nums2[start2]){
                allNums[start1+start2] = nums1[start1];
                start1++;
            }else{
                allNums[start1+start2] = nums2[start2];
                start2++;
            }
        }
        while(start1<n1){
            allNums[start1+start2] = nums1[start1];
            start1++;
        }

        while(start2<n2){
            allNums[start1+start2] = nums2[start2];
            start2++;
        }

        if((n1+n2)%2 == 0){
            return (allNums[(n1+n2)/2]+allNums[(n1+n2)/2+1])/(double)2;
        }else{
            return (double)(allNums[(n1+n2)/2]);
        }
    }

    public int totalNQueens(int n) {
        int[][] queens = new int[n-1][n-1];
        for(int i = 0; i< n;i++){
            for(int j = 0 ;j<n;j++){
                queens[i][j] = 0;
            }
        }
        return 0;
    }

}
