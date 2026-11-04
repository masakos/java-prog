package chapter18.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

// データベースにテーブルを作って、ArrayListの本を登録する
public class Sample01 {
    public static void main(String[] args) throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Java入門", 3000));
        books.add(new Book("はじめてのSQL", 2500));
        books.add(new Book("ネットワークの基本", 2800));

        // ① データベースに接続する（ファイルがなければ新しく作られる）
        Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/books.db");

        // ② テーブルを作り直す（何回実行しても同じ結果になるように、一度消してから作る）
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS books");
        stmt.executeUpdate("CREATE TABLE books (title TEXT, price INTEGER)");
        stmt.close();

        // ③ 1冊ずつ INSERT する（? のところに値が入る）
        PreparedStatement ps = conn.prepareStatement("INSERT INTO books (title, price) VALUES (?, ?)");
        for (Book book : books) {
            ps.setString(1, book.getTitle()); // 1つ目の ? に タイトル
            ps.setInt(2, book.getPrice());    // 2つ目の ? に 価格
            ps.executeUpdate();
        }
        ps.close();

        // ④ 接続を閉じる
        conn.close();

        System.out.println(books.size() + "冊 登録しました");
    }
}
