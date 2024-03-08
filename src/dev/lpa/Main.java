package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for(Integer i : others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo = %d%n", five, (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        for (String s : fruit){
            int val = banana.compareTo(s);

            // doesn't just print -1, 0 or 1
            System.out.printf("%s %s %s: compareTo = %d%n", banana, (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

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