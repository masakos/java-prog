package chapter18.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// データベースにタスクを1件書き込む
public class Sample04 {
    public static void main(String[] args) throws Exception {
        // ① データベースに接続する
        Connection conn = DriverManager.getConnection("jdbc:sqlite:chapter18/data/todo.db");

        // ② INSERT文を準備する（? のところにあとから値が入る）
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO tasks (title, description, deadline, user_id, category_id) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, "Javaの復習");      // 1つ目の ? に タイトル
        ps.setString(2, "18章を読み直す");   // 2つ目の ? に 説明
        ps.setString(3, "2026-11-20");      // 3つ目の ? に 期限
        ps.setInt(4, 1);                    // 4つ目の ? に ユーザーのid
        ps.setInt(5, 1);                    // 5つ目の ? に カテゴリーのid

        // ③ 実行する
        ps.executeUpdate();

        // ④ 閉じる
        ps.close();
        conn.close();

        System.out.println("タスクを1件 登録しました");
    }
}
