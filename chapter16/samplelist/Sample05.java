package chapter16.samplelist;

import java.util.*;

public class Sample05 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();

        names.add("たなか");
        names.add("すずき");
        names.add("さいとう");

        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String e = it.next();
            System.out.println(e);
        }
    }
}
