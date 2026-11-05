package chapter16.samplemap;

import java.util.HashMap;

public class Sample03 {
    public static void main(String[] args) {
        // キー：学生番号、値：学生名
        HashMap<Integer, String> students = new HashMap<Integer, String>();

        students.put(101, "たなか");
        students.put(102, "すずき");
        students.put(103, "さいとう");

        // keySet() でキーを1つずつ取り出し、get() で値を取り出す
        for (int id : students.keySet()) {
            String name = students.get(id);
            System.out.println(id + " : " + name);
        }
    }
}
