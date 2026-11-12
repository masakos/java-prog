package chapter18.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sample02 {
        public static void main(String[] args) throws Exception {
        // ① データベースに接続する
        Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/todo.db");

        // ② SELECT文を実行する
        // Statement: SQL文を文字列として作成し、そのまま実行する方法
        Statement stmt = conn.createStatement();

        // SQLインジェクションの例 
        String userId = "' OR '1'='1";
        String sql = "SELECT * FROM tasks WHERE id = '" + userId + "'";

        ResultSet rs = stmt.executeQuery(sql);


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
