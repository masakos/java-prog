package chapter03;

public class Kadai02 {
    public static void main(String[] args) {
        System.out.println("整数を入力してください");
        int num = new java.util.Scanner(System.in).nextInt();
        if (num % 2 == 0) {
            System.out.println(num + "は偶数です");
        } else {
            System.out.println(num + "は奇数です");
        }
    }
}
