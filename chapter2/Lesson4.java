package chapter2;

public class Lesson4 {
    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("あなたの名前を入力してください");
        String name = scanner.nextLine();

        System.out.println("好きな数字を入力してください");
        int num = scanner.nextInt();

        System.out.println("-------------------------------------------");
        System.out.println(name + "さんの好きな数字は" + num + "ですね。");

    }
}
