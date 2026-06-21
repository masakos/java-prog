package chapter04;

public class Sample11 {
    public static void main(String[] args) {
        // 線形探索: 先頭から順番に1つずつ調べて、目的のデータを探す方法
        int[] scores = { 50, 70, 80, 90, 60 };

        int target = 50;
        boolean found = false;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("見つかりました");
        } else {
            System.out.println("見つかりませんでした");
        }   
    }
}
