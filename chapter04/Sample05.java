package chapter04;

public class Sample05 {
    public static void main(String[] args) {

        int[] scores = {100, 90, 80, 70, 60};
        int sum = 0;

        for (int i = 0 ; i < scores.length; i++) {
            // sum = sum + scores[i];
            sum += scores[i];
        }

        double average = sum / scores.length;
        System.out.println("平均点は" + average + "点です。");
    }
}
