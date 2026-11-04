package chapter18.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

// インターネット上のページを読み込んで、ArrayListに入れて表示する
public class Sample01 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lines = new ArrayList<String>();

        // ① 読み込みたいページのURL
        URL url = URI.create("https://example.com/").toURL();

        // ② URLに接続して開く（ここ以外はファイルの読み込みとほぼ同じ！）
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

        // ③ 1行ずつ読む
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }

        // ④ 閉じる
        reader.close();

        System.out.println("----取得したHTML----");
        for (String s : lines) {
            System.out.println(s);
        }
        System.out.println(lines.size() + "行取得しました");
    }
}
