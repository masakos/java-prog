package chapter16.sampleiterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Sample01 {
    public static void main(String[] args) {
        // List
        ArrayList<String> list = new ArrayList<String>();
        list.add("たなか");
        list.add("すずき");
        list.add("さいとう");

        // Set
        HashSet<String> set = new HashSet<String>();
        set.add("たなか");
        set.add("すずき");
        set.add("さいとう");

        // Map（キー：学生番号、値：学生名）
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(101, "たなか");
        map.put(102, "すずき");
        map.put(103, "さいとう");

        System.out.println("----List----");
        Iterator<String> it1 = list.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        System.out.println("----Set----");
        Iterator<String> it2 = set.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        // Map は keySet() でキーの集まりにしてから iterator() を使う
        // キーが Integer なので、Iterator<Integer> になる
        System.out.println("----Map----");
        Iterator<Integer> it3 = map.keySet().iterator();
        while (it3.hasNext()) {
            int id = it3.next();
            System.out.println(id + " : " + map.get(id));
        }
    }
}
