package chapter04;

public class Sample00 {
    public static void main(String[] args) {
        // テストの平均点を出す
        int score1001 = 100;
        int score1002 = 90;
        int score1003 = 80;
        int score1004 = 70;
        int score1005 = 60;

        int sum = score1001 + score1002 + score1003 + score1004 + score1005;
        double average = sum / 5.0;
        System.out.println("平均点は" + average + "点です。");
    }
}
