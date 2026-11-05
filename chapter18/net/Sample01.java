package chapter18.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

// インターネット上のページを1行ずつ読み込んで表示する
public class Sample01 {
    public static void main(String[] args) throws Exception {
        // ① 読み込みたいページのURL
        URL url = URI.create("https://example.com/").toURL();

        // ② URLに接続して開く（ここ以外はファイルの読み込みとほぼ同じ！）
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

        // ③ 1行ずつ読む（読む行がなくなると null が返ってくる）
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }

        // ④ 閉じる
        reader.close();
    }
}
