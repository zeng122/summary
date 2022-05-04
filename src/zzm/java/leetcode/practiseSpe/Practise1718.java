package zzm.java.leetcode.practiseSpe;


import java.util.*;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 *
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-supersequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 */
public class Practise1718 {

    public static void main(String [] args){
        Practise1718 practise1718 = new Practise1718();
        int big[] = {521704, 897261, 279103, 381783, 668374, 934085, 254258, 726184, 496153, 804155};
        int small[] = {897261, 9385, 381783, 496153};
        practise1718.shortestSeq(big,small);
    }

    /**
     * 1  5  5  1  5  5  9
     * 就是一个滑动窗口
     * @param big
     * @param small
     * @return
     */
    public int[] shortestSeq(int[] big, int[] small) {
        List<Integer> list = new ArrayList<>();

        if(small.length>big.length){
            return new int[]{};
        }
        //small set 便于快速判断是否是small里面的
        Set<Integer> set1 = new HashSet<>();
        //便于判断滑动窗口是否满足，set3为空就满足了
        Set<Integer> set3 = new HashSet<>();
        for (int j : small) {
            set1.add(j);
            set3.add(j);
        }
        Set<Integer> set2 = new HashSet<>();
        int[] result =  new int[2];
        Arrays.fill(result,-1);
        //移除首位
        int left = -1;
        int right = -1;
        int length = Integer.MAX_VALUE;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0 ;i<big.length;i++){
            if(set1.contains(big[i])){
                hashMap.put(big[i],hashMap.get(big[i])==null?1:hashMap.get(big[i])+1);
                list.add(i);
                if(set2.contains(big[i])){
                    //移动
                    if(big[list.get(0)] == big[i]){
                        Iterator iterator = list.iterator();
                        while (iterator.hasNext()){
                            int tempNum = (Integer) iterator.next();
                            if(hashMap.containsKey(big[tempNum]) && hashMap.get(big[tempNum])>1){
                                iterator.remove();
                                hashMap.put(big[tempNum],hashMap.get(big[tempNum])-1);
                            }else{
                                break;
                            }
                        }
                    }

                }else{
                    set2.add(big[i]);
                    set3.remove(big[i]);
                }

                //空了，满足，计算长度
                if(set3.isEmpty()){
                    left = list.get(0);
                    right = list.get(list.size()-1);
                    if((right-left)<length){
                        length = right-left;
                        result[0] = left;
                        result[1] = right;
                    }
                }
            }
        }

        if(result[0] == result[1]){
            if(result[0] == -1)
                return new int[]{};
        }
       return result;

    }

}
