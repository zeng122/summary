package zzm.java.SortAlgorithmDemo;

/**
 * 归并排序
 * 将两个数组不断二分，然后在进行排序
 * 多少层： log(2,n)层
 * 每层需要: n次排序
 * O(n)  = nlog(2,n)
 * 稳定性：
 */
public class GuiBingDemo {
    public static  void main(String [] args){
        int  [] a  = {5, 6 ,1 , 6 ,7 ,4, 3, 6, 7, 5, 9};
       GuiBingDemo guiBingDemo = new GuiBingDemo();
       guiBingDemo.mergeSort(a,0,a.length-1);
        for(int index : a){
            System.out.print(index+" ");
        }
    }
        //两路归并算法，两个排好序的子序列合并为一个子序列 ,mid为left
        public void merge(int []a,int left,int mid,int right){
            int []tmp=new int[a.length];//辅助数组
            int p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针

            while(p1<=mid && p2<=right){
                if(a[p1]<=a[p2])
                    tmp[k++]=a[p1++];
                else
                    tmp[k++]=a[p2++];
            }

            while(p1<=mid) tmp[k++]=a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
            while(p2<=right) tmp[k++]=a[p2++];//同上

            //复制回原素组
            for (int i = left; i <=right; i++)
                a[i]=tmp[i];
        }

        public void mergeSort(int [] a,int start,int end){
            if(start<end){//当子序列中只有一个元素时结束递归
                int mid=(start+end)/2;//划分子序列
                mergeSort(a, start, mid);//对左侧子序列进行递归排序
                mergeSort(a, mid+1, end);//对右侧子序列进行递归排序
                merge(a, start, mid, end);//合并
            }
        }

}
