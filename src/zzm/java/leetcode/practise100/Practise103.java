package zzm.java.leetcode.practise100;

public class Practise103 {

    public static void main(String[] args) {

        int[] nums = {3,1};
        System.out.println(new Practise103().search(nums,1));
    }


    public int search(int[] nums, int target) {
        if(nums.length == 2){

        }
        return searchNum(nums,target,0,nums.length-1);
    }

    public int searchNum(int[] nums,int target,int begin,int end){
        if(begin == end){
            if(nums[begin] == target){
                return begin;
            }else{
                return -1;
            }
        }else if(begin>end){
            return -1;
        }
        int mid = (begin+end)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[begin]<=nums[mid]){
            if(nums[mid]>target && nums[begin]<= target){
                return  searchNum(nums,target,begin,mid-1);
            }else{
                return  searchNum(nums,target,mid+1,end);
            }
        }else{
            if(nums[mid]<target && nums[end] >= target){
                return  searchNum(nums,target,mid+1,end);
            }else{
                return  searchNum(nums,target,begin,mid-1);
            }
        }
    }
}
