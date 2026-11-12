package chapter17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// try-with-resources：使い終わったら自動で close() してくれる書き方
public class Sample05 {
    public static void main(String[] args) {
        // ① try の後ろの ( ) の中で開いたものは、最後に自動で閉じられる
        //    → reader.close() を書かなくてよい（finally もいらない）
        try (BufferedReader reader = new BufferedReader(
                new FileReader("chapter18/data/books.csv", StandardCharsets.UTF_8))) {

            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        } catch (IOException e) {
            // ② ファイルが見つからない・読めないときはここに来る
            System.out.println("ファイルを読み込めませんでした：" + e.getMessage());
        }
    }
}
