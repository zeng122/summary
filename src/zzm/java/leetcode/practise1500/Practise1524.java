package zzm.java.leetcode.practise1500;

public class Practise1524 {
    public static void main(String[] args) {
        Practise1524 practise1524 = new Practise1524();
        int[] arr = {1,3,5};
        System.out.println(practise1524.numOfSubarrays2(arr));
    }

    public int numOfSubarrays2(int[] arr) {
        final int MODULO = 1000000007;
        int odd = 0, even = 1;
        int subarrays = 0;
        int sum = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            subarrays = (subarrays + (sum % 2 == 0 ? odd : even)) % MODULO;
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return subarrays;
    }


    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int ji = 0;
        int ou = 0;
        //刚开始和为偶数
        boolean b = false;
        for(int i = 0;i<arr.length;i++){
            if(!b){
                if(arr[i] % 2 == 0){
                    ou++;
                    b = false;
                }else{
                    ji++;
                    b = true;
                }
            }else{
                if(arr[i] % 2 == 1){
                    ou++;
                    b = false;
                }else{
                    ji++;
                    b = true;
                }
            }
        }
        long result = ji;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] % 2 == 0){
                ji = ji;
                ou = ou -1;
            }else{
                int temp = ji;
                ji = ou;
                ou = temp - 1;
            }
            result = result + ji;
            if(result >= mod){
                result = result -mod;
            }
        }
        return (int)result;
    }
}
