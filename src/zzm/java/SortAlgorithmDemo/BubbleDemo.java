package zzm.java.SortAlgorithmDemo;

/**
 * 冒泡排序
 * 大的放到最后面
 * O(n) = n(n+1)/2 = O(n^2)
 * 最差和最好都是O(n^2)
 * 网上有人说最好是o(n)，是加了判断的，如果这次扫描有序，就不用在进行第二次扫描了。
 * 稳定性:稳定
 */
public class BubbleDemo {
    public static  void main(String [] args){
        int  [] a  = {5, 6 ,1 , 6 ,7 ,4, 3, 6, 7, 5, 9};
        BubbleDemo bubbleDemo = new BubbleDemo();
        bubbleDemo.sort(a);
        for(int index : a){
            System.out.print(index+" ");
        }
    }

    public void sort(int  [] a){
        int temp = 0;
        for(int i = 0; i< a.length;i++){
            //boolean flag = false;
            for(int j = 0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    //flag = true;
                }
            }

//            if(!flag){
//                return;
//            }
        }
    }
}
