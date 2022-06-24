package zzm.java.leetcode.practise0;

import java.util.ArrayList;
import java.util.List;

public class Practise39 {
    public static void main(String[] args) {

        Practise39 practise39 = new Practise39();
        int[] candidates = {2,3,5};
        practise39.combinationSum(candidates,8);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates,target,0);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target,int start) {
        List<List<Integer>> result = new ArrayList<>();
        if(start >= candidates.length){
            return result;
        }
        for(int i = start;i<candidates.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            if(candidates[i] == target){
                result.add(list);
            }else if(candidates[i]<target){
                List<List<Integer>> subList = combinationSum(candidates,target-candidates[i],i);
                if(!subList.isEmpty()){
                    for(List<Integer> temp : subList){
                        temp.addAll(list);
                        result.add(temp);
                    }
                }
            }

        }
        return result;
    }

}
