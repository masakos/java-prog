package chapter05.kadai;

public class Kadai03 {

    // 2つの整数のうち大きい方を返すメソッド
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        // 引数に10と20を渡してメソッドを呼び出す
        int result = max(10, 20);

        // 戻り値を表示
        System.out.println(result);
    }
}
    
