package chapter04;

public class Sample11 {
    public static void main(String[] args) {
        // 線形探索（順番に探す）
        int[] scores = { 50, 70, 80, 90, 60 };

        int target = 90;
        boolean found = false;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                found = true;
                break;
            }
        }

        System.out.println(found);
    }

}
