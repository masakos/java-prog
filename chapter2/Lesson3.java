package chapter2;

public class Lesson3 {
    public static void main(String[] args) {
        // 命令実行分の例
        System.out.println("Hello, World!");

        // 改行なし画面出力の命令
        System.out.print("Hello, ");
        System.out.print("World!");

        // 大きいほうの数値を代入する命令
        int a = 10;
        int b = 20;
        int max = Math.max(a, b);
        System.out.println("大きい方の数値: " + max);

        // String型をintに変換する命令
        String age = "31";
        int n = Integer.parseInt(age);
        System.out.println("あなたは来年、" + (n + 1) + "歳になりますね。");

        // ランダムな数を生成する命令
        int number = new java.util.Random().nextInt(10);
        System.out.println("今日のラッキーナンバーは" + number + "です！");

    }

}
