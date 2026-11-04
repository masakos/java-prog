package chapter18.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

// CSVファイルを読み込んで、Bookのインスタンスにして一覧表示する
public class Sample03 {
    public static void main(String[] args) throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();

        BufferedReader reader = new BufferedReader(
                new FileReader("chapter18/data/books.csv", StandardCharsets.UTF_8));

        String line = reader.readLine();
        while (line != null) {
            // "Java入門,3000" を "," で分ける → ["Java入門", "3000"]
            String[] items = line.split(",");
            String title = items[0];
            int price = Integer.parseInt(items[1]); // 文字列 "3000" を 数値 3000 に変換

            books.add(new Book(title, price));
            line = reader.readLine();
        }
        reader.close();

        System.out.println("----本の一覧----");
        for (Book book : books) {
            System.out.println(book.getTitle() + " : " + book.getPrice() + "円");
        }
    }
}
