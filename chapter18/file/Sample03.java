package chapter18.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

// BufferedReaderでファイルを1行ずつ読み込んで表示する
public class Sample03 {
    public static void main(String[] args) throws Exception {
        // ① ファイルを開く（FileReaderをBufferedReaderで包むと、1行ずつ読めるようになる）
        BufferedReader reader = new BufferedReader(
                new FileReader("chapter18/data/books.csv", StandardCharsets.UTF_8));

        // ② 1行ずつ読む（読む行がなくなると null が返ってくる）
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }

        // ③ ファイルを閉じる
        reader.close();
    }
}
