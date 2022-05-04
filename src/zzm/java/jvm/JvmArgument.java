package zzm.java.jvm;

import zzm.java.extendsDemo.Student;

import java.util.ArrayList;
import java.util.List;

public class JvmArgument {

    public static void main(String[] args){
        List<Student>  students = new ArrayList<>();
        while(true){
            Student student = new Student("zzm","sadsad");
            students.add(student);
            System.out.println(students.size());
        }

    }

    static class Student {
        private String name;
        private String password;

        public Student(String name,String password){
            this.name = name;
            this.password = password;
        }
    }
}
