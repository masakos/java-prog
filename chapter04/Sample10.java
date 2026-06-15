package chapter04;

public class Sample10 {
    public static void main(String[] args) {
        int[][] scores = {
                { 80, 90, 70 }, // 学生1の点数(国語、数学、英語)
                { 60, 85, 75 }, // 学生2の点数(国語、数学、英語)
                { 90, 95, 88 } // 学生3の点数(国語、数学、英語)
        };

        // 国語の平均点
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i][0];
        }
        double average = (double) sum / scores.length;
        System.out.println("国語の平均点: " + average);

        // 数学の平均点
        sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i][1];
        }
        average = (double) sum / scores.length;
        System.out.println("数学の平均点: " + average);

        // 英語の平均点
        sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i][2];
        }
        average = (double) sum / scores.length;
        System.out.println("英語の平均点: " + average);

    }
}
