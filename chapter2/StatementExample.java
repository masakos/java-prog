package chapter2;

public class StatementExample {
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
        int r = new java.util.Random().nextInt(90);
        System.out.println("あなたはたぶん、" + r + "歳ですね？");

        // キーボードから入力を受けつける命令
        System.out.println("あなたの名前を入力してください");
        String name = new java.util.Scanner(System.in).nextLine();
        System.out.println("あなたの好きな数字を入力してください");
        int number = new java.util.Scanner(System.in).nextInt();
        System.out.println("ようこそ、" + name + "さん。好きな数字は" + number + " なんだね。");

    }

}
