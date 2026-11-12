package chapter17;

// ① 自分で例外クラスを作る（Exception を継承する）
class ScoreException extends Exception {
    public ScoreException(String message) {
        super(message); // 親クラス（Exception）にメッセージを渡す
    }
}

// 独自の例外クラスを使う
public class Sample08 {
    public static void main(String[] args) {
        int[] scores = { 80, 120, 50 };

        for (int score : scores) {
            try {
                checkScore(score);
                System.out.println(score + "点：OK");
            } catch (ScoreException e) {
                // ③ 自分で作った例外も、同じように catch できる
                System.out.println("エラー：" + e.getMessage());
            }
        }
    }

    // ② 0〜100 の範囲外なら ScoreException を投げる
    //    Exception を継承した例外は、throws を書かないとコンパイルエラーになる
    static void checkScore(int score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("点数は0〜100で入力してください：" + score);
        }
    }
}
