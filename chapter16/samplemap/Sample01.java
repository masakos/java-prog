package chapter16.samplemap;

import java.util.HashMap;

public class Sample01 {
    public static void main(String[] args) {
        // キー：学生番号、値：学生名
        HashMap<Integer, String> students = new HashMap<Integer, String>();

        students.put(101, "たなか");
        students.put(102, "すずき");
        students.put(103, "さいとう");

        System.out.println(students.get(101));
        System.out.println(students.get(102));
        System.out.println(students.get(103));
    }
}
