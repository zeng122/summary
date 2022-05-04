package zzm.java.leetcode.practise0;

/**
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 *每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Practise70 {

    static long  j = 0;
    public static void main(String[] args){
        Practise70 practise70 = new Practise70();
        System.out.println(practise70.climbStairs(45));
        System.out.println(j);
    }
    /**
     * f(n) = f(n-2)+f(n-1)
     * 终点：
     * f(1) = 1
     * f(2) = 2
     * 思路很清晰，但是超时，为什么超时，如f(9) = f(8) + f(7) = f(7)+f(6)+f(6)+f(5)
     * 可以看到它其实求了很多无用值
     * 这个时间复杂度怎么求？
     * f(n) = f(n-1)+f(n-2)+1
     * f(n-1) = f(n-2)+f(n-3)+1
     * f(n)-f(n-1) = f(n-1)-f(n-3)
     * f(1)= 1
     * f(2)= 1
     * 求f(n)
     * 上面的计算比较复杂
     *
     * 典型的二叉树，一共有多少节点(调用)？
     * 可以大致估下多少层：n/2层
     * 1.4n次方，这是一个大致的估计，但是n次方
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        j++;
        if(n== 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * O(n) = n
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int small = 1 ;
        int big = 2;
        int temp = 0;
        if(n== 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        for(int i = 3; i <= n ;i++){
            temp = big;
            big = small+big;
            small = temp;
        }
        return big;
    }

}
