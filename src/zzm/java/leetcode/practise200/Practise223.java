package zzm.java.leetcode.practise200;

/**
 * 给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Practise223 {


    public static void main(String [] args){
        Practise223 practise223 = new Practise223();
        System.out.println(practise223.computeArea(-3 ,-3,-1 ,3,-2
                        ,-2
                ,2,
                2));


    }
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //第一种：两个不相交
        if(ax2<=bx1 || bx2<=ax1 || ay1>=by2 || by1>=ay2){
            return (ax2-ax1)*(ay2-ay1)+(bx2-bx1)*(by2-by1);
        }//第二种：两个相交，并且覆盖,a小
        else if(ax1>=bx1 && ax2<=bx2 && ay1>=by1 && ay2<=by2){
            return (bx2-bx1)*(by2-by1);
        }
        //第三种：两个相交，并且覆盖,b小
        else if(ax1<=bx1 && ax2>=bx2 && ay1<=by1 && ay2>=by2){
            return (ax2-ax1)*(ay2-ay1);
        }
        //第四种：两个相交
        else {
            int minx = Math.min(ax1,bx1);
            int maxx = Math.max(ax2,bx2);
            int miny = Math.min(ay1,by1);
            int maxy = Math.max(ay2,by2);
            //求交点正方形：
            int width = (ax2-ax1)+(bx2-bx1)-(maxx-minx);
            int hight = (ay2-ay1)+(by2-by1)-(maxy-miny);

            return (ax2-ax1)*(ay2-ay1)+(bx2-bx1)*(by2-by1)-width*hight;
        }

    }
}
