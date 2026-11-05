package chapter18.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

// CSVファイルを1行ずつ読み込んで、Bookのインスタンスにして表示する
public class Sample04 {
    public static void main(String[] args) throws Exception {
        // ① ファイルを開く（FileReaderをBufferedReaderで包むと、1行ずつ読めるようになる）
        BufferedReader reader = new BufferedReader(
                new FileReader("chapter18/data/books.csv", StandardCharsets.UTF_8));

        System.out.println("----本の一覧----");

        // ② 1行ずつ読む（読む行がなくなると null が返ってくる）
        String line = reader.readLine();
        while (line != null) {
            // "Java入門,3000" を "," で分ける → ["Java入門", "3000"]
            String[] items = line.split(",");
            String title = items[0];
            int price = Integer.parseInt(items[1]); // 文字列 "3000" を 数値 3000 に変換

            Book book = new Book(title, price);
            System.out.println(book.getTitle() + " : " + book.getPrice() + "円");

            line = reader.readLine();
        }

        // ③ ファイルを閉じる
        reader.close();
    }
}
