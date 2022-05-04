package zzm.java.SortAlgorithmDemo;

/**
 * 希尔排序
 * 思路:改变增量，一个增量队列,直接插入排序的改进，减少了复制次数
 * o
 */
public class ShellDemo {
    public static  void main(String [] args){
        int  [] a  = {5, 6 ,1 , 6 ,7 ,4, 3, 6, 7, 5, 9};
        ShellDemo shellDemo = new ShellDemo();
        shellDemo.sort(a);
        for(int index : a){
            System.out.print(index+" ");
        }
    }

    public void sort(int  [] a){
        int gap = a.length;
        for(gap = gap /3  ; gap>0; gap = gap /3){
            System.out.println(gap);
            //其实可以看到，当gap = 1时 就是一个直接插入排序
            for(int i=gap;i<a.length;i++){
                int j = i;
                int temp = a[j];
                if(a[j]<a[j-gap]){
                    while(j-gap>=0 && temp<a[j-gap]){
                        //移动法
                        a[j] = a[j-gap];
                        j-=gap;
                    }
                    a[j] = temp;
                }
            }

        }
    }
}
