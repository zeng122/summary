package zzm.java.leetcode.practise0;


import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积
 *
 * heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 */
public class Practise84 {


    public static void main(String[] args){

        int [] heights = {3,6,5,7,4,8,1,0};
        Practise84 practise84 = new Practise84();
        System.out.println(practise84.largestRectangleArea(heights));
    }

    //方法1，暴力破解,根据每个矩形算

    //方法2，单调栈+哨兵
    //4 2 3 5 4
    public int largestRectangleArea(int[] heights) {

        //存下标
        Stack<Integer> stack = new Stack<>();
        int maxSize = 0;
        int[] newHeights = new int[heights.length+2];
        for(int i = 0;i<heights.length;i++){
            newHeights[i+1] = heights[i];
        }
        heights = newHeights;
        stack.push(0);
        for(int i = 1;i<heights.length;i++){
            while (!stack.empty() && heights[stack.peek()]>heights[i]){
                int height = heights[stack.pop()];
                int width =  i - 1- stack.peek();;
                if(height * width>maxSize){
                    maxSize =height*width;
                }
            }
            stack.push(i);
        }
        while (!stack.empty()){
            int height = heights[stack.pop()];
            int width;
            if(stack.empty()){
                width = heights.length;
            }else{
                width =  heights.length - 1 - stack.peek();
            }
            if(height * width>maxSize){
                maxSize =height*width;
            }
        }

        return maxSize;
    }
}
