package chapter16.sampleiterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Sample03 {
    public static void main(String[] args) {
        ArrayList<Integer> points = new ArrayList<Integer>();
        points.add(80);
        points.add(45);
        points.add(90);
        points.add(30);

        // 拡張for文の中で points.remove() を使うと、エラー（ConcurrentModificationException）になる
        // for (Integer point : points) {
        //     if (point < 50) {
        //         points.remove(point);
        //     }
        // }

        // Iterator なら、50点未満を取り出しながら削除できる
        Iterator<Integer> it = points.iterator();
        while (it.hasNext()) {
            int point = it.next();
            if (point < 50) {
                it.remove(); // 今取り出した要素を削除する
            }
        }

        System.out.println(points);
    }
}
