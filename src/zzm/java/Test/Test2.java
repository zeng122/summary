package zzm.java.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test2 {
    private static Student student1;
    private static Student student2;


    /**
     * this is a block of code,so the variable will not validate in the other
     * place , do not define the variable in the static block. It is not meaningful
     * at all
     *
     * the best usage of this is to initialize static variable
     */
    static {
        student1 = new Student("小红","123");
        student2 = new Student("小明","321");
    }

    public static void main(String []args){
        Test2 test2 = new Test2();
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Optional<List<Student>> optional = Optional.of(students);
        optional.ifPresent(item->item.forEach(Test2::getALL));
        test2.changeDemo(student1,student2);
        System.out.println(student1.getName());
        System.out.println(student2.getName());
    }

    public void changeDemo(Student st1, Student st2){
        Student temp =new Student("小狗","231");
        temp = st1;
        st1 =st2;
        st2 = temp;
        System.out.println(st1.getName());
        System.out.println(st2.getName());
    }

    public static void  getALL(Student student){
        System.out.println(student.toString());
    }
}


class Student{
    private String name;
    private String pass;

    public Student(String name,String pass){
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}