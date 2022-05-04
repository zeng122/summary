package zzm.java.leetcode.practise0;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入参数 ： n对
 * 输出：所有的组合
 *
 * 例如 ：2
 * ["()","(())"]
 */
public class Practise22 {

    public static void main(String []  args){
        Practise22 practise22 = new Practise22();
        List<String> res = practise22.generateParenthesis(3);
        System.out.print("[");
        int temp  = 0;
        for(String index : res){
            temp++;
            System.out.print("\"");
            System.out.print(index);
            System.out.print("\"");
            if(temp != res.size()){
                System.out.print(",");
            }
        }
        System.out.print("]");

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        caculate(res,"",0,0,n);
        return res;
    }

    //递归+回溯
    public void caculate(List<String> res,String index ,int left ,int right,int n){
        //递归终点
        if(left>n || right>n) return;

        //什么时候可以+1,全部使用时
        if(left == n && right == n){
            res.add(index);
            return;
        }

        //思考例如n = 5,left = 4，right = 1
        //它有两种2种场景：添加左边，添加右边
        if(left>=right){
            caculate(res,index+"(",left+1,right,n);
            caculate(res,index+")",left,right+1,n);
        }
    }

    //思考，为什么下面执行效率要高
    //主要是判断时间，
    public void caculate2(List<String> res,String index ,int left ,int right,int n){
        //递归终点
        if(left>n || right>n || right > left) return;

        //什么时候可以+1,全部使用时
        if(left == n && right == n){
            res.add(index);
            return;
        }

        //思考例如n = 5,left = 4，right = 1
        //它有两种2种场景：添加左边，添加右边
        caculate2(res,index+"(",left+1,right,n);
        caculate2(res,index+")",left,right+1,n);
    }
}
