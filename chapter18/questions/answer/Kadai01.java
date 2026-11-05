package chapter18.questions.answer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

// q1 の解答例（STEP 1 〜 STEP 5 とチャレンジ）
public class Kadai01 {
    public static void main(String[] args) throws Exception {
        ArrayList<Task> tasks = new ArrayList<Task>();

        // ① ファイルを開く
        BufferedReader reader = new BufferedReader(
                new FileReader("chapter18/data/tasks.csv", StandardCharsets.UTF_8));

        // ② 1行ずつ読んで、Task にして ArrayList に入れる（STEP 1・STEP 3）
        String line = reader.readLine();
        while (line != null) {
            // "教科書を読む,2026-11-15,0" → ["教科書を読む", "2026-11-15", "0"]
            String[] items = line.split(",");
            String title = items[0];
            String deadline = items[1];
            int isCompleted = Integer.parseInt(items[2]);

            tasks.add(new Task(title, deadline, isCompleted));
            line = reader.readLine();
        }

        // ③ ファイルを閉じる
        reader.close();

        // ④ ArrayList から1つずつ取り出して表示する（STEP 3・STEP 4・STEP 5）
        System.out.println("----タスク一覧----");
        int count = 0;
        for (Task task : tasks) {
            if (task.getIsCompleted() == 1) {
                System.out.print("[済] ");
            } else {
                System.out.print("[  ] ");
                count++;
            }
            System.out.println(task.getTitle() + "（期限 " + task.getDeadline() + "）");
        }

        System.out.println(tasks.size() + "件のタスクがあります");     // STEP 2
        System.out.println("まだ終わっていないタスクは" + count + "件です"); // STEP 5

        // チャレンジ：まだ終わっていないタスクをファイルに書き出す
        FileWriter writer = new FileWriter("chapter18/data/todo.txt", StandardCharsets.UTF_8);
        for (Task task : tasks) {
            if (task.getIsCompleted() == 0) {
                writer.write(task.getTitle() + "\n");
            }
        }
        writer.close();
    }
}
