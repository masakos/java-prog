package chapter04;

public class Sample12 {
    public static void main(String[] args) {
        // 最大値・最小値探索
        int[] scores = { 60, 80, 95, 70, 50 };

        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        System.out.println(max);
    }
}
