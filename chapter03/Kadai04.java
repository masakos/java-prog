package chapter03;

public class Kadai04 {
    public static void main(String[] args) {
        /*
         * 気温を整数で入力し、
         * 
         * 30以上 → 「暑い」
         * 20以上30未満 → 「過ごしやすい」
         * 20未満 → 「寒い」
         * 
         * と表示するプログラムを作成してください。
         */

        System.out.println("気温を整数で入力してください");
        int temperature = new java.util.Scanner(System.in).nextInt();
        if (temperature >= 30) {
            System.out.println("暑い");
        } else if (temperature >= 20) {
            // }else if (temperature >=20 && temperature < 30){
            System.out.println("過ごしやすい");
        } else {
            System.out.println("寒い");
        }
    }
}
