package zzm.java.leetcode.practise700;

/**
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-adjacent-in-lr-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 看不到明显规律的题！！
 * 仔细分析，
 */
public class Practise777 {

    public static void main(String [] args){
        Practise777 practise777 = new Practise777();
        System.out.println(practise777.canTransform("RXXLRXRXL","XRLXXRRLX"));
    }

    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;

        char[] chars1 = start.toCharArray();
        char[] chars2 = end.toCharArray();


        for(int i = 0;i<end.length();i++){
            char c  = chars2[i];

            if(chars1[i] == c){
                continue;
            }else{
                if(c == 'X'){
                    for(int j = i;j<start.length();j++){
                        char c2 = chars1[j];
                        if(c2 =='R'){
                            continue;
                        }else if(c2 == 'L'){
                            return  false;
                        }else{
                            char temp = chars1[i];
                            chars1[i] = c2;
                            chars1[j] = temp;
                            break;
                        }
                    }
                }

                if(c == 'R'){
                    return false;
                }

                if(c == 'L'){
                    for(int j = i;j<start.length();j++){
                        char c2 = chars1[j];
                        if(c2 =='X'){
                            continue;
                        }else if(c2 == 'R'){
                            return  false;
                        }else{
                            char temp = chars1[i];
                            chars1[i] = c2;
                            chars1[j] = temp;
                            break;
                        }
                    }
                }
            }

        }

        return true;
    }


}
