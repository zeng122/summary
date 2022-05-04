package zzm.java.Collection.List;

import javax.print.DocFlavor;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListStreamDemo {

    public static  void main(String []args){

        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1L);
        user1.setAge("12");

        User user2 = new User();
        user2.setId(2L);
        user2.setAge("13");

        userList.add(user1);
        userList.add(user2);
        Map<Long, User> maps = userList.stream().collect(Collectors.toMap(User::getId, Function.identity(), (key1, key2) -> key2));

        ListStreamDemo listStreamDemo = new ListStreamDemo();
        listStreamDemo.fun();
    }



    public void fun(){
        List<Student> list = new ArrayList<>();


        List<String> cardNoInReport = new ArrayList<>();
        cardNoInReport.add("1111");
        cardNoInReport.add("1111");
        cardNoInReport.add("1112");
        cardNoInReport.add("1112");
        cardNoInReport.add("1113");
        Iterator<String> iter = cardNoInReport.iterator();
//        while(iter.hasNext()){
//            String next = iter.next();
//            if(next.equals("1111")){
//                iter.remove();
//            }
//        }

//        for(String str:cardNoInReport){
//            cardNoInReport.remove(str);
//        }
        //Map<String,Long> cardNoInReportMap = cardNoInReport.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        list.add(new Student("1234","sadad"));
        list.add(new Student("1234","1sadad"));
        list.add(new Student("1235","2sadad"));
        list.add(new Student("1111","3sadad"));
        List<Student> mmm= list.stream().filter(item->!item.getName().equals("1111")).map(item->{
            item.setPassword("bbbb");
            return item;
        }).collect(Collectors.toList());
       // List newList = list.subList(0,10);
//        Map<String , String> map1s  = list.stream().collect(Collectors.toMap(Student::getName, Student::getPassword, (key1, key2) -> key2));
//        Map<String , String> map2s  = list.stream().collect(Collectors.toMap(Student::getName, Student::getPassword, (key1, key2) -> key2));
//        Map<String , String> map3s = new HashMap<>();
//        map3s.put("1111","@222");
//        map1s.putAll(map3s);
//        String stt = map1s.get("Sadsadasd");
        Map<String,List<String>> map1 = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.mapping(Student::getPassword,Collectors.toList())));
       // Map<String,List<String>> map0 = list.stream().collect(Collectors.groupingBy(Student::getName,));

//        Map<String , Student> maps = list.stream().collect(Collectors.toMap(Student::getName, Function.identity(),
//               (v1, v2) -> (v1)));


        //Map<String , Student> maps  = list.stream().collect(Collectors.toMap(Student::getName, Function.identity(), (key1, key2) -> key2));
        //list.stream().collect(Collectors.groupingBy(Student::getName,));
        //
        Map<String,List<Student>> map2 = list.stream().collect(Collectors.groupingBy(Student::getName));
        Map<String,Long> map3 = list.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));

        //Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println("adasdad");
    }


    class Student{
        String name;
        String password;

        public Student( String name, String password){
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


    public static class User {
        private Long id;
        private String age;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
