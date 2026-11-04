package chapter18.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

// ファイルを1行ずつ読み込んで、ArrayListに入れて表示する
public class Sample01 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = new ArrayList<String>();

        // ① ファイルを開く
        BufferedReader reader = new BufferedReader(
                new FileReader("chapter18/data/books.csv", StandardCharsets.UTF_8));

        // ② 1行ずつ読む（読む行がなくなると null が返ってくる）
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }

        // ③ ファイルを閉じる
        reader.close();

        System.out.println("----ファイルの中身----");
        for (String s : lines) {
            System.out.println(s);
        }
        System.out.println(lines.size() + "行読み込みました");
    }
}
