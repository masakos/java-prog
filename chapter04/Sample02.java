package chapter04;

public class Sample02 {
    public static void main(String[] args) {
        // 配列変数の宣言:
        int[] scores;
        // 要要の作成と代入
        scores = new int[5];

        // 配列の長さを調べる
        int num = scores.length;
        System.out.println("要素の数：" + num);

        // 配列は自動的に初期化される
        System.out.println("---初期化していない状態で値を表示する---");
        System.out.println(scores[0]); // 初期値は0
        System.out.println(scores[1]); // 初期値は0
        System.out.println(scores[2]); // 初期値は0
        System.out.println(scores[3]); // 初期値は0
        System.out.println(scores[4]); // 初期値は0

        // scores[5] = 50; // 配列の範囲外にアクセスしようとすると、エラーになる
        System.out.println(scores[5]);

        // 通常の変数は初期化しないと、エラーになる
        int a = 0;
        System.out.println(a);

        // 配列の要素に値を代入する
        scores[0] = 100;
        scores[1] = 90;
        scores[2] = 80;
        scores[3] = 70;
        scores[4] = 60;

        // 配列の要素の値を表示する
        System.out.println("---代入後の値---");
        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[2]);
        System.out.println(scores[3]);
        System.out.println(scores[4]);

        // 配列の初期化から代入までをまとめて書くこともできる
        int[] scores1 = new int[] { 100, 90, 80, 70, 60 };
        int[] scores2 = { 100, 90, 80, 70, 60 };
    };
}
