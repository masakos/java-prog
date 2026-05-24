package chapter03;

public class Kadai03 {
    public static void main(String[] args) {

        System.out.println("天気をsunny, cloudy, rainyのいずれかで 入力してください");

        String weather = new java.util.Scanner(System.in).nextLine();
        
        if (weather.equals("sunny")) {
            System.out.println("散歩に行く");
        } else if (weather.equals("cloudy")) {
            System.out.println("買い物に行く");
        } else if (weather.equals("rainy")) {
            System.out.println("映画を見る");
        } else {
            System.out.println("天気が正しくありません");
        }
    }
}
