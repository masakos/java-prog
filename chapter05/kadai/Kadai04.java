package chapter05.kadai;

public class Kadai04 {

    // 合否を判定するメソッド
    public static String judge(int score) {
        if (score >= 80) {
            return "合格";
        } else {
            return "不合格";
        }
    }

    public static void main(String[] args) {
        // 引数に75を渡してメソッドを呼び出す
        String result = judge(75);

        // 戻り値を表示
        System.out.println(result);
    }
}