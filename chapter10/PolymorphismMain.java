package chapter10;

import java.util.*;

public class PolymorphismMain {

    public static void main(String[] args) {

        // Book型のArrayListを作成
        ArrayList<Book> books = new ArrayList<>();

        // 異なる種類のオブジェクトを追加
        books.add(new PaperBook("Java入門", "山田太郎", 2800, 300));

        books.add(new EBook("SQL入門", "佐藤花子", 1800, 15));

        // 拡張for文で取り出して表示
        for (Book book : books) {
            book.display();
            System.out.println();
        }
    }
}
