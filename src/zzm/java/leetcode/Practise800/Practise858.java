package zzm.java.leetcode.Practise800;

/**
 * 镜面反射
 *
 *
 * 不好描述直接看原题
 */
public class Practise858 {
    public static void main(String[] args){
        Practise858 practise858 = new Practise858();
        System.out.println(practise858.mirrorReflection(2,1));
    }



    /**
     *
     * @param p :边长
     * @param q ：长度
     * 则水平方向速度 V1 = p/q  V2
     *
     * 什么时候到边界呢， v1 * t % p = 0
     * 什么时候到角落呢， v2 * t % p = 0
     * v1 * t / p  等于偶数时 左上
     * v2 * t / p  等于奇数时  右上 ，右下
     *
     * 还有何时满足呢？
     *
     * @return
     */
    public int mirrorReflection(int p, int q) {
        int result = -1;
        int time = 1;
        do{
            result = getResult(p,q,time);
            time ++;
        }while (result == -1);
        return result;
    }


    public int getResult(int p, int q ,int time){
        int s1 = time * p;
        int s2 = time * q;
        if(s2 % p != 0){
            return -1;
        }

        int index1 = s1 / p;
        int index2 = s2 / p;

        if(index1 % 2 == 0){
            if(index2 % 2 == 1){
                return 2;
            }else{
                return -1;
            }
        }else{
            if(index2 % 2 == 1){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
