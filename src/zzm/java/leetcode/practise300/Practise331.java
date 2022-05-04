package zzm.java.leetcode.practise300;

import java.util.Stack;

/**
 * 树的先序遍历
 * "9,3,4,#,#,1,#,#,2,#,6,#,#“
 * #为空节点，
 * 判断这个先序遍历是否为一颗树
 */
public class Practise331 {

    public static void main(String [] args){
        Practise331 practise331 = new Practise331();
        System.out.println(practise331.isValidSerialization("1,#,#,#,#"));

    }

    /**
     * 思路如何去分析
     * 由简变难
     * 一个节点
     * 1 # #
     * 1 isRight
     * 2 # 1 # #
     * 1可以替换成 #
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        String[] strings = preorder.split(",");
        Stack<String> stringStack = new Stack<>();
        try{
            for(int i = 0 ;i<strings.length;i++){
                if(!strings[i].equals("#")){
                    // 入栈
                    stringStack.push(strings[i]);
                }else{
                    if(stringStack.size() > 0 && stringStack.peek().equals("#")){
                        while(stringStack.size() > 0 && stringStack.peek().equals("#")){
                         stringStack.pop();
                         stringStack.pop();
                        }
                        stringStack.push("#");
                    }else{
                        stringStack.push("#");
                    }
                }
            }
            if(stringStack.size()== 1 && stringStack.peek().equals("#")){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public boolean isValidSerialization2(String preorder){
        String[] strings = preorder.split(",");
        Stack<String> stringStack = new Stack<>();
        for(int i = 0 ;i<strings.length;i++){
            stringStack.push(strings[i]);
            while (stringStack.size()>=3 && stringStack.get(stringStack.size()-1).equals("#") && stringStack.get(stringStack.size()-2).equals("#")
            && !stringStack.get(stringStack.size()-3).equals("#")){
                stringStack.pop();
                stringStack.pop();
                stringStack.pop();
                stringStack.push("#");
            }
        }
        if(stringStack.size() == 1 && stringStack.peek().equals("#")){
            return true;
        }
        return false;
    }

}
