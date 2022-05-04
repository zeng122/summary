package zzm.java.leetcode.practise700;

/**
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 求乘积
 */
public class Practise740 {

    public static void main(String []args){
        Practise740 practise740 = new Practise740();
        System.out.println(practise740.multiply("0","0"));
    }

    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        //结果最长也只有chars1.length+chars2.length
        int[] total = new int[chars1.length+chars2.length];

        for(int i = 0;i<total.length-1;i++){
            total[i] = 0;
        }
        char[] chars4 = new char[chars1.length+chars2.length];
        for(int i = chars1.length-1; i >= 0;i--){

            //进位
            int temp1 = 0;
            for(int j = chars2.length-1;j >= 0 ; j--){
                //乘积
                int temp2 = charToInt(chars1[i]) *charToInt(chars2[j]) + temp1 + total[i+j+1];
                temp1 = temp2 / 10;
                total[i+j+1] = temp2 % 10;
            }

            //处理最后的进位
            int temp3 = 1;
            while(temp1>0){
                int temp4 =  total[i+1-temp3]+temp1;
                temp1 = temp4 / 10;
                total[i+1-temp3] = temp4 % 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        boolean canOutPut = false;
        for(int i = 0 ;i<total.length;i++){
            if(total[i] != 0){
                canOutPut = true;
            }
            if(canOutPut){
                stringBuilder.append(total[i]);
            }
        }
        return stringBuilder.toString().length() == 0? "0":stringBuilder.toString();
    }

    //字符串转数字
    int charToInt(char c){
        return c-'0';
    }
}
