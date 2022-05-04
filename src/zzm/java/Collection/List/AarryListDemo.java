package zzm.java.Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
* */
public class AarryListDemo {
    public  static  void main(String[] args){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("ssss") ;
        System.out.println(strings.get(0));
        String [] strings1 ={ "1111","2222","dsada","sadsad","1111dd","123","124",
        "125","126","127","128","129","130"};
        subList(Arrays.asList(strings1.clone()));
    }


    public static  void subList(List<String> list){
        int start = 0;
        int end = 0;
        while(start<list.size()){
            end = end + 3;
            if(end > list.size()){
                end = list.size();
            }
            List<String> subDtos = list.subList(start,end);
            subDtos.forEach(item->System.out.println(item));
            start = end;
        }
    }
}
