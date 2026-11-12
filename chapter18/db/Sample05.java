package chapter18.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 複数のテーブル（tasks と users）を続けて読み込んで表示する
public class Sample05 {
    public static void main(String[] args) throws Exception {
        // ① データベースに接続する（接続は1回だけでよい）
        Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/todo.db");

        // ② Statementを作る（同じStatementを使い回して、何回でもSQLを実行できる）
        Statement stmt = conn.createStatement();

        // ③ 1つ目：tasks テーブルを表示する
        System.out.println("=== tasks ===");
        ResultSet rs = stmt.executeQuery("SELECT id, title, deadline FROM tasks");
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String deadline = rs.getString("deadline");
            System.out.println(id + " : " + title + "（期限 " + deadline + "）");
        }
        rs.close(); // 次のSQLを実行する前に、使い終わった結果を閉じる

        // ④ 2つ目：users テーブルを表示する
        System.out.println("=== users ===");
        rs = stmt.executeQuery("SELECT id, name FROM users");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id + " : " + name);
        }
        rs.close();

        // ⑤ 閉じる
        stmt.close();
        conn.close();
    }
}
