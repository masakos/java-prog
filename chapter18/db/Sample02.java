package chapter18.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// データベースから本を取り出して、ArrayListに入れて一覧表示する
public class Sample02 {
    public static void main(String[] args) throws Exception {
        ArrayList<Book> books = new ArrayList<Book>();

        // ① データベースに接続する
        Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/books.db");

        // ② SELECT文を実行する
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT title, price FROM books");

        // ③ 結果を1行ずつ取り出す（次の行がなくなると false になる）
        while (rs.next()) {
            String title = rs.getString("title");
            int price = rs.getInt("price");
            books.add(new Book(title, price));
        }

        // ④ 閉じる
        rs.close();
        stmt.close();
        conn.close();

        System.out.println("----本の一覧（データベースから取得）----");
        for (Book book : books) {
            System.out.println(book.getTitle() + " : " + book.getPrice() + "円");
        }
    }
}
