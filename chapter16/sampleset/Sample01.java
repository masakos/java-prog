package chapter16.sampleset;

import java.util.HashSet;

public class Sample01 {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<String>();

        names.add("たなか");
        names.add("すずき");
        names.add("さいとう");
        names.add("たなか"); // 同じ値は追加されない

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println(names.size());
    }
}
