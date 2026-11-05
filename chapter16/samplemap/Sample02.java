package chapter16.samplemap;

import java.util.HashMap;

public class Sample02 {
    public static void main(String[] args) {
        // キー：学生番号、値：学生名
        HashMap<Integer, String> students = new HashMap<Integer, String>();

        students.put(101, "たなか");
        students.put(102, "すずき");
        students.put(103, "さいとう");

        students.put(102, "やまだ"); // 同じキーで put すると、値が上書きされる
        System.out.println(students.get(102));

        boolean result = students.containsKey(101);
        System.out.println(result);

        students.remove(101);
        System.out.println(students.containsKey(101));

        System.out.println(students.size());
    }
}
