package chapter04;

public class Sample01 {
    public static void main(String[] args) {

        // (1) 宣言時に初期値を設定するケース(要素数も中身も最初から決まっている場合)
        int [] scores = {60, 70, 80, 90, 100};  // 配列を宣言するときだけ使える特別な書き方
        // int [] scores = new int[] {60, 70, 80, 90, 100};

        // 配列の要素の値を表示する
        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[2]);
        System.out.println(scores[3]);
        System.out.println(scores[4]);


        double[] values = {0.5, 1.2, 1.8};
        System.out.println(values[0]);
        System.out.println(values[1]);
        System.out.println(values[2]);

        // 配列の長さを調べる
        int scoresLength = scores.length;
        System.out.println("要素の数：" + scoresLength);

        int valuesLength = values.length;
        System.out.println("要素の数：" + valuesLength);

    };
}
