package chapter05.kadai;

public class Kadai06 {

    // 配列の合計を求めるメソッド
    public static int sum(int[] numbers) {
        int total = 0;

        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }

        return total;
    }

    public static void main(String[] args) {
        // 配列を作成
        int[] numbers = { 1, 2, 3 };

        // メソッドを呼び出す
        int result = sum(numbers);

        // 戻り値を表示
        System.out.println(result);
    }
}
