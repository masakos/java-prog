package chapter05.kadai;

public class Kadai05 {

    // 税込価格を計算するメソッド
    public static int calcTax(int price) {
        return (int) (price * 1.1);
    }

    public static void main(String[] args) {
        // 引数に1000を渡してメソッドを呼び出す
        int result = calcTax(1000);

        // 戻り値を表示
        System.out.println(result);
    }
}
