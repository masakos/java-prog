package chapter04;

public class Sample12 {
    public static void main(String[] args) {

        // この点数の中から、 一番大きい点数（最大値）を探したい というプログラム
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
