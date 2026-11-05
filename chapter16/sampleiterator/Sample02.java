package chapter16.sampleiterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Sample02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("たなか");
        list.add("すずき");
        list.add("さいとう");

        HashSet<String> set = new HashSet<String>();
        set.add("たなか");
        set.add("すずき");
        set.add("さいとう");

        // List でも Set でも、同じメソッドで表示できる
        printAll(list.iterator());
        System.out.println("----");
        printAll(set.iterator());
    }

    // 中身が List か Set かを知らなくても、Iterator なら同じ書き方で取り出せる
    public static void printAll(Iterator<String> it) {
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
