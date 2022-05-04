package zzm.java.SortAlgorithmDemo;

/**
 * 选择最大的放到队尾
 * O(n) = n(n+1)/2 = O(n^2)
 * 最差和最好都是O(n^2)
 * 稳定性:不稳定，很简单，第一个数最大，在排序时放到了最后面
 */
public class SelectionSort {

    public static  void main(String [] args){
        int  [] a  = {5, 6 ,1 , 6 ,7 ,4, 3, 6, 7, 5, 9};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);
        for(int index : a){
            System.out.print(index+" ");
        }
    }


    public void sort(int  [] a){
        for(int i = 0 ; i<a.length; i++){
            int max = 0;
            for(int j = 0; j< a.length-i;j++){
                if(a[max] < a[j]){
                    max = j;
                }
            }
            //交换
            int temp = a[max];
            a[max] = a[a.length-i-1];
            a[a.length-i-1] = temp;
        }
    }

}
