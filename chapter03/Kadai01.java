package chapter03;

public class Kadai01 {
    public static void main(String[] args) {
        System.out.println("整数を入力してください");
        int num = new java.util.Scanner(System.in).nextInt();
        if (num >= 10) {
            System.out.println(num + "は10以上です");
        } else {
            System.out.println(num + "は10未満です");
        }
    }
}
