package zzm.java.leetcode.practise0;

public class Practise8 {


    public static void main(String[] args) {

        Practise8 practise8 = new Practise8();
        practise8.myAtoi("9223372036854775808");

    }

    public int myAtoi(String s) {
        int index = 0;
        int state = 0;  //初始化状态
        int isOverZero = 1;
        boolean canContinue = true;
        long result = 0;
        while (index<s.length() && canContinue){
            char c = s.charAt(index);
            switch (state){
                case 0:
                    if(c == '-'){
                        isOverZero = -1;
                        state = 1;
                    }else if(c == '+'){
                        state = 1;
                    }else if(c>='0' && c<='9'){
                        state = 1;
                        result = result*10+(int)(c-'0');
                    }else if(c == ' '){
                        break;
                    }else{
                        canContinue = false;
                    }
                    break;
                case 1:
                    if(c>='0' && c<='9'){
                        result = result*10+(int)(c-'0');
                        if(result >Integer.MAX_VALUE){
                            canContinue = false;
                            break;
                        }
                    }else{
                        canContinue = false;
                        break;
                    }
                    break;
            }
            index++;
        }
        if(result >Integer.MAX_VALUE){
            if(isOverZero == 1){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }else{
            return (int) result*isOverZero;
        }
    }

}
