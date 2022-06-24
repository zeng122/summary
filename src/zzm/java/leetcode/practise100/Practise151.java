package zzm.java.leetcode.practise100;

public class Practise151 {

    public static void main(String[] args) {
        Practise151 practise151 = new Practise151();
        practise151.reverseWords("a good   example");
    }

    //采用直接插入排序
    public String reverseWords(String s) {
        //
        s = s+" ";
        String result = "";
        int index = 0;
        String word = "";
        while (index < s.length()){
            char c = s.charAt(index);
            if(c == ' '){
                if(!word.equals("")){
                    result = word+' '+result;
                    word = "";
                }
            }else{
                word = word+c;
            }
            index++;
        }
        return result.substring(result.length()-1);
    }


}
