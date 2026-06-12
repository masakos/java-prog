package chapter04;

public class Sample05 {
    public static void main(String[] args) {
        //配列を使った書き方
        int[] scores = {100, 90, 80, 70, 60};
        int sum = 0; 
        for (int i = 0 ; i < scores.length; i++) {
            sum += scores[i];
        }
        double average = sum / (double) scores.length;
        System.out.println("平均点は" + average + "点です。");
    }        int[] scores = {100, 90, 80, 70, 60};
}
