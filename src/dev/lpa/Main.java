package dev.lpa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for(Integer i : others){
            int val = five.compareTo(i);
//            System.out.printf("%d %s %d: compareTo = %d%n", five, (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        for (String s : fruit){
            int val = banana.compareTo(s);

            // doesn't just print -1, 0 or 1
//            System.out.printf("%s %s %s: compareTo = %d%n", banana, (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }

        Arrays.sort(fruit);
//        System.out.println(Arrays.toString(fruit));

//        System.out.println("A:" +(int)'A' + " " + "a:" + (int)'a');
//        System.out.println("B:" +(int)'B' + " " + "b:" + (int)'b');
//        System.out.println("P:" +(int)'P' + " " + "p:" + (int)'p');

        Student tim = new Student("Tim");
        Student[] students = {
                new Student("Zach"),
                new Student("Tim"),
                new Student("Ann"),
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

//         prints 32, the diff bw any uppercase ltr and its lowercase self
//        System.out.println("result: " + tim.compareTo(new Student("TIM")));

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        // Arrays.sort takes a comparator instance as a second arg
        // And we've overriden Comparator's compare() method
        Arrays.sort(students, gpaSorter);

    }
}

class StudentGPAComparator implements Comparator<Student>{
   @Override
    public int compare(Student o1, Student o2){
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static Random random = new Random();
    String name;
    private int id;
    protected double gpa;



    public Student(String name) {
        this.name = name;
        // Any new instance increments this. Cool
        id=LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public int compareTo(Student s) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(s.id));
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }
}




// For `sort` to work on a list the items have to implement Comparable

// public interface Comparable <T>{
//    int compareTo(T o);
//}
// resulting values:
// 0: o == this
// negative value: this < o
// pos value: this > 0