package zzm.java.leetcode.practise100;

public class Practise165 {
    public static void main(String[] args) {
        Practise165 practise165 = new Practise165();
        String version1 = "1.0", version2 = "1.0.0.1";
        System.out.println(practise165.compareVersion(version1,version2));
    }


    public int compareVersion(String version1, String version2) {
        String[] subVersion1 = version1.split("\\.");
        String[] subVersion2 = version2.split("\\.");
        int index = 0;
        while (index<subVersion1.length && index<subVersion2.length){
            int num1 = stringToInt(subVersion1[index]);
            int num2 = stringToInt(subVersion2[index]);
            if(num1 != num2){
                return num1>num2?1:-1;
            }
            index++;
        }
        while (index <subVersion1.length){
            int num1 = stringToInt(subVersion1[index]);
            if(num1>0){
                return 1;
            }
            index++;
        }
        while (index <subVersion2.length){
            int num2 = stringToInt(subVersion2[index]);
            if(num2>0){
                return -1;
            }
            index++;
        }
        return 0;
    }



    public int stringToInt(String input){
        int result = 0;
        for(int i = 0;i<input.length();i++){
            char c = input.charAt(i);
            result = result * 10 + (c - '0');
        }
        return  result;
    }
}
