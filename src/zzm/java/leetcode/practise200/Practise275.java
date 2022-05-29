package zzm.java.leetcode.practise200;

public class Practise275 {
    public static void main(String[] args) {
        Practise275 practise275 = new Practise275();
        int[] citations = {0,1,3,5,6};
        practise275.hIndex(citations);
    }

    public int hIndex(int[] citations) {
        if(citations[0]>= citations.length){
            return citations.length;
        }
        if(citations[citations.length-1] == 0){
            return 0;
        }
        int result = citations.length-1;
        while (result>0){
            if(citations[citations.length-result] >= result  && citations[citations.length-result-1]<=result){

                return result;
            }
            result--;
        }
        return result;
//        int l = 0 , r = citations.length -1;
//        while(l <= r){
//            int mid = ((r-l)>>1) + l;
//            int dis = citations.length - mid;
//            if(citations[mid] >= dis){ // 大于等于
//                r = mid - 1;
//            }else { // 小了，就再移一位，就是大于等于，跟 if 里面的逻辑错位对应
//                l = mid + 1;
//            }
//        }
//        return citations.length - l;
    }
}
