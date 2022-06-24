package zzm.java.leetcode.practise400;

public class Practise470 {

    public static void main(String[] args) {

    }

    public int rand10() {
        while (true){
            int num1 = rand7();
            int num2 = rand7();
            int num = num1 * 10 + num2;
            if(num<= 14){
                return 1;
            }
            if(num<= 21){
                return 2;
            }
            if(num<= 25){
                return 3;
            }
            if(num<= 32){
                return 4;
            }
            if(num<= 36){
                return 5;
            }
            if(num<= 43){
                return 6;
            }
            if(num<= 47){
                return 7;
            }
            if(num<= 54){
                return 8;
            }
            if(num<= 61){
                return 9;
            }
            if(num<= 65){
                return 10;
            }
        }
    }


    public int rand7(){
        return 0;
    }
}
