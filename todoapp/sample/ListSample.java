package todoapp.sample;

import java.util.ArrayList;
import java.util.List;

public class ListSample {
    public static void main(String[] args) {
        // 文字列を複数保存できるリストを作るコード例
        List<String> tasks = new ArrayList<>();

        // 追加
        tasks.add("Javaの課題");
        tasks.add("DBの復習");
        tasks.add("レポート提出");

        // 件数
        System.out.println("件数：" + tasks.size());

        // 1件取得（インデックスは0から）
        System.out.println(tasks.get(0));

        // 全件表示
        for (String task : tasks) {
            System.out.println(task);
        }

        // 削除
        tasks.remove("DBの復習");
    }

}
