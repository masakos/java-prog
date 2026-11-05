package chapter18.file;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;

// FileReaderでファイルを1文字ずつ読み込んで表示する
public class Sample01 {
    public static void main(String[] args) throws Exception {
        // ① ファイルを開く
        FileReader reader = new FileReader(
                "chapter18/data/books.csv",
                StandardCharsets.UTF_8);

        // ② 1文字ずつ読む（読む文字がなくなると -1 が返ってくる）
        int ch = reader.read();
        while (ch != -1) {
            System.out.print((char) ch); // 数値で返ってくるので char に変換して表示
            //System.out.println(ch);
            ch = reader.read();
        }

        // ③ ファイルを閉じる
        reader.close();
    }
}
