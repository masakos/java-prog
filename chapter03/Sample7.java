package chapter03;

public class Sample7 {
    public static void main(String[] args) {

        int total = 0; // for文の外で宣言 → ループ終了後も使える

        for (int i = 0; i < 5; i++) {
            // i はこのブロック内でしか使えない（スコープ）
            total += i;
            System.out.println("i = " + i + ", total = " + total);
        }

        // System.out.println(i); // ← コンパイルエラー！i はここでは使えない
        System.out.println("最終合計 = " + total); // total はここでも使える
    }
}
