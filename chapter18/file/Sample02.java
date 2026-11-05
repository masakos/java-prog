package chapter18.file;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

// FileWriterでファイルに書き込む
public class Sample02 {
    public static void main(String[] args) throws Exception {
        // ① ファイルを開く（ファイルがなければ新しく作られる。あれば上書きされる）
        FileWriter writer = new FileWriter(
                "chapter18/data/output.txt",
                StandardCharsets.UTF_8);

        // ② 書き込む（"\n" は改行）
        writer.write("課題レポートを提出する\n");
        writer.write("Javaの復習をする\n");
        writer.write("教科書を読む\n");

        // ③ ファイルを閉じる（閉じないと内容が保存されないことがある）
        writer.close();

        System.out.println("chapter18/data/output.txt に書き込みました");
    }
}
