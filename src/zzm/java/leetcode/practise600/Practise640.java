package zzm.java.leetcode.practise600;

/**
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回“No solution”。
 *
 * 如果方程有无限解，则返回“Infinite solutions”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/solve-the-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。4
 *
 * 输入: "x+5-3+x=6+x-2"
 * 输出: "x=2"
 */
public class Practise640 {

    public static  void main(String []args){
        Practise640 practise640 = new Practise640();
        System.out.println(practise640.solveEquation("0x=0"));
    }


    public String solveEquation(String equation) {
        char[] chars = equation.toCharArray();
        int a = 0;   //系数
        int b = 0;   //值
        boolean isAdd  = true;
        boolean isLeft = true;
        for(int i = 0 ; i< chars.length;i++){
            int temp = 0;
            //处理系数等于0
            boolean hasXiShu = false;
            while(i<chars.length && chars[i]>= '0' && chars[i]<='9'){
                temp  = 10*temp+chars[i]-'0';
                hasXiShu = true;
                i++;
            }
            //终点处理
            if(i == chars.length){
                if((isAdd && !isLeft) || (!isAdd && isLeft)){
                    b = b + temp;
                }else{
                    b = b - temp;
                }
                break;
            }

            if(chars[i] == 'x'){
                if(temp==0 && !hasXiShu){
                    temp = 1;
                }
                if((isAdd && isLeft) || (!isAdd && !isLeft) ){
                    a = a+temp;
                }else{
                    a = a-temp;
                }
            }else if(chars[i] == '+'){
                if((isAdd && !isLeft) || (!isAdd && isLeft)){
                    b = b + temp;
                }else{
                    b = b - temp;
                }
                isAdd = true;
            }else if(chars[i] == '-'){
                if((isAdd && !isLeft) || (!isAdd && isLeft)){
                    b = b + temp;
                }else{
                    b = b - temp;
                }
                isAdd = false;
            }else if(chars[i] == '='){
                if((isAdd && !isLeft) || (!isAdd && isLeft)){
                    b = b + temp;
                }else{
                    b = b - temp;
                }
                isLeft = false;
                isAdd = true;
            }
        }

        //无解
        if(a == 0 && b != 0){
            return "No solution";
        }else if(a == 0 && b == 0){
            return "Infinite solutions";
        }else{
            return "x="+String.valueOf(b/a);
        }
    }
}
