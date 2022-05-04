package zzm.java.leetcode.practise600;
import java.util.*;

public class Practise629 {

    public static void main(String[] args) {
        Practise629 practise629 = new Practise629();
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        practise629.topKFrequent(words,4);
    }


    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word :words){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else{
                map.put(word,1);
            }
        }
        //比较大小
        List<String> temp = new ArrayList<>();
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            temp.add(entry.getKey());
        }
        Collections.sort(temp, (o1, o2) -> {
            if(map.get(o1)-map.get(o2)==0){
                return o1.compareTo(o2);
            }else{
                return map.get(o2)-map.get(o1);
            }
        });

        return temp.subList(0,k);
    }




    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }


}
