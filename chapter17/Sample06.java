package chapter17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// throws：例外の処理を「呼び出し元」に任せる
public class Sample06 {
    public static void main(String[] args) {
        // ③ 呼び出し元（main）で例外をつかまえる
        try {
            String line = readFirstLine("chapter17/nofile.txt"); // 存在しないファイル
            System.out.println("1行目：" + line);
        } catch (IOException e) {
            System.out.println("ファイルを読み込めませんでした：" + e.getMessage());
        }
    }

    // ① throws IOException と書くと、
    //    「このメソッドは IOException が起きるかもしれません。処理は呼び出した側でお願いします」という意味
    // ② このメソッドの中では try-catch を書かなくてよい
    static String readFirstLine(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName, StandardCharsets.UTF_8))) {
            return reader.readLine();
        }
    }
}
