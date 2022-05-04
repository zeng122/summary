package zzm.java.leetcode.practise0;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：m = 3, n = 7
 * 输出：28
 */
public class Practise62 {

    int [][] result;
    public static void main(String [] args){
        Practise62 practise62 = new Practise62();
        System.out.println(practise62.uniquePaths(3,7));
    }

    //标准回溯法解题
    public int uniquePaths(int m, int n) {
        result  = new int[m+1][n+1];
        return doScanPath(m,n);
    }


    public int doScanPath(int m,int n){
        if(result[m][n] != 0){
            return result[m][n];
        }
        if( 1 == m || 1 == n){
            return 1;
        }

        result[m][n]= doScanPath(m-1,n)+doScanPath(m,n-1);
        return result[m][n];
    }
}
