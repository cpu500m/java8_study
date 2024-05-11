package functionalInterface;

import java.util.Arrays;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name : " + name + ", age : " + age;
    }
}
// Comparator는 함수형 인터페이스. Comparable은 현재 객체와 다른 객체를 비교하는 용도 (함수형 인터페이스 X)
public class ComparatorEx {

    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("a",3);
        students[1] = new Student("b",2);
        students[2] = new Student("c",6);
        students[3] = new Student("d",11);
        students[4] = new Student("d",1);

        for (Student student : students) {
            System.out.print(student + " ");
        }
        System.out.println();
        System.out.println();
        Arrays.sort(students, (s1, s2) -> s2.age - s1.age);
        for (Student student : students) {
            System.out.print(student + " ");
        }

    }
}
