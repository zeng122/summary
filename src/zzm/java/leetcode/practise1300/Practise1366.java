package zzm.java.leetcode.practise1300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入：votes = ["ABC","ACB","ABC","ACB","ACB"]
 * 输出："ACB"
 * 解释：A 队获得五票「排位第一」，没有其他队获得「排位第一」，所以 A 队排名第一。
 * B 队获得两票「排位第二」，三票「排位第三」。
 * C 队获得三票「排位第二」，两票「排位第三」。
 * 由于 C 队「排位第二」的票数较多，所以 C 队排第二，B 队排第三。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-teams-by-votes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practise1366 {

    public static  void main(String [] args){
        Practise1366 practise1366 = new Practise1366();
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        practise1366.rankTeams(votes);
    }


    /**
     * 思路很清晰，先比较所有的第一个字母，在比较第二个，
     * 这里用什么数据结构存储？
     * Map<Characher,Integer> map
     * 怎么排序
     * 直接插入排序
     * 取一个排一个，注意相同的按字母顺序
     * 循环遍历一次已排的数组，
     * 找到处理完的
     *
     *
     * 第一个排完了
     * 第二个怎么处理？
     * 创建一个新的Map,
     * 如何处理第一次已经排好的？
     * 判断上面是否已经处理完
     * 1
     *
     * @param votes
     * @return
     */
    public String rankTeams(String[] votes) {
        // 字母、第一个
        int[][] maps = new int[26][votes[0].length()];
        //以示例1为例：记录A，B, C分别在每个排位出现了几次
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char c = vote.charAt(i);
                maps[c - 'A'][i]++;
            }
        }
        //把每一行的数据（也就是每个队伍在排位中出现的次数还有他们的队伍的顺序）
        Pair[] arr = new Pair[26];
        for (int i = 0; i < maps.length; i++)
            arr[i] = new Pair(maps[i], i);

        Arrays.sort(arr, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                //挨个比较他们在排位中出现的次数
                for (int i = 0; i < p1.arr.length; i++) {
                    if (p1.arr[i] != p2.arr[i])
                        return p2.arr[i] - p1.arr[i];
                }
                //第二种情况，比较他们的字母顺序
                return p1.index - p2.index;
            }
        });

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < votes[0].length(); i++)
            ans.append((char)('A' + arr[i].index));
        return ans.toString();
    }
}

//相当于定义了一个类似于map的东西
class Pair {
    int[] arr;
    int index;
    public Pair(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }
}

