package zzm.java.leetcode.Practise900;

import java.util.Map;
import java.util.Stack;

public class Practise901 {

    Stack<Integer> stack;
    Stack<Integer> prices;
    int i = 0;
    public static void main(String[] args) {

    }

    public Practise901 (){
        stack = new Stack<>();
        prices = new Stack<>();
    }

    public int next(int price) {
        System.out.println(stack);
        if (!prices.empty() && prices.peek() <= price){
            prices.pop();
            stack.pop();
        }
        int temp;
        if(prices.empty()){
            temp = 0;
        }else{
            temp = stack.peek();
        }
        i++;

        stack.push(i);
        prices.push(price);
        if(price == 75) System.out.println(i+"-----"+temp);
        return i - temp;
    }
}
