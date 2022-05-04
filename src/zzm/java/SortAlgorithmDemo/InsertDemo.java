package zzm.java.SortAlgorithmDemo;

/**
 * 插入排序
 * 在有序队列的基础上插入一个数进行排序
 * O(n) = n(n+1)/2 = O(n^2)
 * 最好都是O(n),有序情况下
 * 稳定性:稳定
 */
public class InsertDemo {

    public static  void main(String [] args){
        int  [] a  = {5, 6 ,1 , 6 ,7 ,4, 3, 6, 7, 5, 9};
        InsertDemo insertDemo = new InsertDemo();
        insertDemo.sort(a);
        for(int index : a){
            System.out.print(index+" ");
        }
    }

    public void sort(int  [] a){
        for(int i = 0 ;i< a.length;i++){
            int preIndex = i - 1;
            int current = a[i];
            int j = 0;
            for(j = i-1;j>=0;j--){
                if(a[j]>current){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = current;
//            while(preIndex >= 0 && a[preIndex] > current) {
//                a[preIndex + 1] = a[preIndex];
//                preIndex--;
//            }
//            a[preIndex + 1] = current;
        }
    }
}
