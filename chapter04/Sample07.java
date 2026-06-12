package chapter04;

public class Sample07 {
    public static void main(String[] args) {
        int[] scores = {100, 90, 80, 70, 60};
        // 拡張for文 (要素だけ使うなら拡張for文)
        for (int score : scores) {
            System.out.println(score);
        }

        // インデックス（何番目か）が必要なら通常のfor文
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Index: " + i + ", Score: " + scores[i]);
        }
    }
}
