package chapter18.file;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

// ArrayListの中身をファイルに書き込む
public class Sample02 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> tasks = new ArrayList<String>();
        tasks.add("課題レポートを提出する");
        tasks.add("Javaの復習をする");
        tasks.add("教科書を読む");

        // ① ファイルを開く（ファイルがなければ新しく作られる。あれば上書きされる）
        FileWriter writer = new FileWriter("chapter18/data/output.txt", StandardCharsets.UTF_8);

        // ② 1行ずつ書き込む（"\n" は改行）
        for (String task : tasks) {
            writer.write(task + "\n");
        }

        // ③ ファイルを閉じる（閉じないと内容が保存されないことがある）
        writer.close();

        System.out.println("chapter18/data/output.txt に書き込みました");
    }
}
