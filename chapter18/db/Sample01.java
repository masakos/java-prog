package chapter18.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// データベースからタスクを読み込んで表示する
public class Sample01 {
    public static void main(String[] args) throws Exception {
        // ① データベースに接続する
        Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/todo.db");

        // ② SELECT文を実行する
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, title, deadline FROM tasks");

        // ③ 結果を1行ずつ取り出す（次の行がなくなると false になる）
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String deadline = rs.getString("deadline");
            System.out.println(id + " : " + title + "（期限 " + deadline + "）");
        }

        // ④ 閉じる
        rs.close();
        stmt.close();
        conn.close();
    }
}
