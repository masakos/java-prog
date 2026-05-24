package chapter03;

public class Sample2 {
    public static void main(String[] args) {

        String drink = "tea";

        switch (drink) {
            case "coffee" ->
                System.out.println("コーヒーを選びました");

            case "tea" ->
                System.out.println("紅茶を選びました");

            case "juice" ->
                System.out.println("ジュースを選びました");

            default ->
                System.out.println("メニューにありません");
        }
    }
}